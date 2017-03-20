package saurabhjn76.com.capstoneproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import saurabhjn76.com.capstoneproject.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CircularProgressBar circularProgressBar = (CircularProgressBar)findViewById(R.id.progressBar);
        TextView result_score= (TextView) findViewById(R.id.resultText);
        Button reviewQuestion = (Button) findViewById(R.id.review);
        Button homeButton =(Button) findViewById(R.id.Choose);
        toolbar.setTitle("Result");
        Intent intent=getIntent();
        if(intent.getIntExtra("SCORE",-1)==-1){
            Toast.makeText(ResultActivity.this,"Error Occured,Sorry for inconvenience",Toast.LENGTH_SHORT).show();
            Intent newIntet= new Intent(ResultActivity.this,MainActivity.class);
            startActivity(newIntet);
        }
        else{
            int score= intent.getIntExtra("SCORE",-1);
            result_score.setText(score*5+"%");
            int animationDuration = 2500; // 2500ms = 2,5s
            circularProgressBar.setProgressWithAnimation(score*5, animationDuration);
        }
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
