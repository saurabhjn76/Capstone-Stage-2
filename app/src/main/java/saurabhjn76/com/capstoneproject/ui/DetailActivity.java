package saurabhjn76.com.capstoneproject.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;

import saurabhjn76.com.capstoneproject.R;

public class DetailActivity extends AppCompatActivity {

    RequestQueue ReqQueue;
    public String key ="Insert Your Key Here";
    //public String key = "c8618ff3d5fd73e6601c1d5e1ef3f337"; // Wrong Key
    public LinearLayout trailersList;
    public LinearLayout reviewList;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        FragmentManager manager = getSupportFragmentManager();
//        getSupportActionBar().setHomeButtonEnabled(true);
        Fragment frag =new DetailFragment();

        manager.beginTransaction().replace(R.id.detailContainer,frag).commit();


    }

}
