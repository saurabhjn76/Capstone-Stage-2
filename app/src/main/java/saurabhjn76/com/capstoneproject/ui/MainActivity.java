package saurabhjn76.com.capstoneproject.ui;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import saurabhjn76.com.capstoneproject.Adapter.ImageAdapter;
import saurabhjn76.com.capstoneproject.R;

public class MainActivity extends AppCompatActivity {
    public  View v;
    public View s;
    boolean mTwoPane=true;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
        {
            //  MainFragment.instance.movies.clear();
            // MainFragment.instance.movies =(ArrayList<Movies>)savedInstanceState.get("Movie_Saved");
        }
        setContentView(R.layout.activity_main);
        v= findViewById(R.id.content_layout);
        gridView= (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (!checknetconnection()) {
            Snackbar.make(v, "No internet Connection", Snackbar.LENGTH_INDEFINITE)
                    .setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                    .show();

        }



        setSupportActionBar(toolbar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!checknetconnection()) {
            Snackbar.make(v, "No internet Connection", Snackbar.LENGTH_INDEFINITE)
                    .setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                        }
                    })
                    .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                    .show();

        }


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (!checknetconnection()) {
            Snackbar.make(v, "No internet Connection", Snackbar.LENGTH_INDEFINITE)
                    .setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                    .show();

        }

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (!checknetconnection()) {
            Snackbar.make(v, "No internet Connection", Snackbar.LENGTH_INDEFINITE)
                    .setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                    .show();

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        // outState.putParcelableArrayList("Movie_Saved", MainFragment.instance.movies);
        if (!checknetconnection()) {
            Snackbar.make(v, "No internet Connection", Snackbar.LENGTH_INDEFINITE)
                    .setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                    .show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       /* int id = item.getItemId();
        MainFragment fragment = MainFragment.instance;

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_popularity) {
            fragment.sort_order = "popular";
            fragment.update(fragment.sort_order);



        }
        if(id==R.id.action_rated)
        {
            fragment.sort_order = "top_rated";
            fragment.update(fragment.sort_order);
        }
        if(id==R.id.action_fav)
        {
            fragment.sort_order="favourites";
            fragment.update(fragment.sort_order);
        }*/

        return super.onOptionsItemSelected(item);
    }
    public boolean checknetconnection()
    {
        ConnectivityManager manager_c =(ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork=manager_c.getActiveNetworkInfo();
        boolean isConnected= activenetwork!= null && activenetwork.isConnectedOrConnecting();
        return isConnected;
    }

}

