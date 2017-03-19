package saurabhjn76.com.capstoneproject.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;

import saurabhjn76.com.capstoneproject.Fragment.DetailFragment;
import saurabhjn76.com.capstoneproject.R;

public class DetailActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        FragmentManager manager = getSupportFragmentManager();
        Fragment frag =new DetailFragment();
        manager.beginTransaction().replace(R.id.detailContainer,frag).commit();


    }

}
