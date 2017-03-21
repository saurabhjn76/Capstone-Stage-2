package saurabhjn76.com.capstoneproject.ui;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.text.SimpleDateFormat;
import java.util.Date;

import saurabhjn76.com.capstoneproject.Models.Score;
import saurabhjn76.com.capstoneproject.R;
import saurabhjn76.com.capstoneproject.Widget.WidgetProvider;
import saurabhjn76.com.capstoneproject.data.ScoresDB;

public class ResultActivity extends AppCompatActivity {

    ContentResolver contentResolver;
    ScoresDB mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CircularProgressBar circularProgressBar = (CircularProgressBar)findViewById(R.id.progressBar);
        TextView result_score= (TextView) findViewById(R.id.resultText);
        Button reviewQuestion = (Button) findViewById(R.id.review);
        mdb = new ScoresDB();
        int scored=0;
        contentResolver= getContentResolver();
        Button homeButton =(Button) findViewById(R.id.Choose);
        toolbar.setTitle("Result");
        Intent intent=getIntent();
        String level =intent.getStringExtra("LEVEL");
        String category = intent.getStringExtra("CATEGORY");
        if(intent.getIntExtra("SCORE",-1)==-1){
            Toast.makeText(ResultActivity.this,"Error Occured,Sorry for inconvenience",Toast.LENGTH_SHORT).show();
            Intent newIntet= new Intent(ResultActivity.this,MainActivity.class);
            startActivity(newIntet);
        }
        else{
             scored= intent.getIntExtra("SCORE",-1);
            result_score.setText(scored*5+"%");
            int animationDuration = 2500; // 2500ms = 2,5s
            circularProgressBar.setProgressWithAnimation(scored*5, animationDuration);
        }
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        Score score = new Score(mdb.getCount(contentResolver)+1,category,scored*5,date,level);
       mdb.addScore(contentResolver,score);
        Intent wIntent = new Intent(this, WidgetProvider.class);
        wIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        int ids[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), WidgetProvider.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,ids);
        sendBroadcast(wIntent);
        Log.e("Score Added","Move to database");


        reviewQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ResultActivity.this.onBackPressed();
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntet= new Intent(ResultActivity.this,MainActivity.class);
                startActivity(newIntet);
            }
        });
        setSupportActionBar(toolbar);


    }

}
