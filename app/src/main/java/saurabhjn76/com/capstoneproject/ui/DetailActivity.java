package saurabhjn76.com.capstoneproject.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;

import saurabhjn76.com.capstoneproject.Adapter.ImageAdapter;
import saurabhjn76.com.capstoneproject.Fragment.DetailFragment;
import saurabhjn76.com.capstoneproject.R;

public class DetailActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(ImageAdapter.mCatIds[getIntent().getIntExtra("POSITION",-23)]);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FragmentManager manager = getSupportFragmentManager();
        Fragment frag =new DetailFragment();
        manager.beginTransaction().replace(R.id.detailContainer,frag).commit();

    }

}
