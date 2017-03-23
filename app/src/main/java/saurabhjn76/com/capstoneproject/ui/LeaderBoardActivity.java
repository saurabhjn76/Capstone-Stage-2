package saurabhjn76.com.capstoneproject.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

import saurabhjn76.com.capstoneproject.Adapter.LeaderBoardScoreAdapter;
import saurabhjn76.com.capstoneproject.Models.LeaderBoardScores;
import saurabhjn76.com.capstoneproject.Models.User;
import saurabhjn76.com.capstoneproject.R;

public class LeaderBoardActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;
    ListView lv;

    LeaderBoardScoreAdapter leaderBoardScoreAdapter;
    private static final String TAG = LeaderBoardActivity.class.getSimpleName();
    ArrayList<LeaderBoardScores> lScores= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lv=(ListView) findViewById(R.id.listView);
        leaderBoardScoreAdapter= new LeaderBoardScoreAdapter(lScores,this);
        lv.setAdapter(leaderBoardScoreAdapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        auth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("scores");
        userId =auth.getCurrentUser().getUid();
      //  User user = new User(name, email);
        Query queryRef =  mFirebaseDatabase.orderByChild("scores").limitToLast(100);
        queryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    LeaderBoardScores score=postSnapshot.getValue(LeaderBoardScores.class);
                    Log.e(TAG ,"values is " + score.getUser_name()  + " " + score.getScores());
                    lScores.add(score);
                   // Toast.makeText(getApplicationContext(),score.getScores(),Toast.LENGTH_SHORT).show();
                }
                Collections.reverse(lScores);
                leaderBoardScoreAdapter= new LeaderBoardScoreAdapter(lScores,LeaderBoardActivity.this);
                lv.setAdapter(leaderBoardScoreAdapter);
                leaderBoardScoreAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read score", error.toException());
            }
        });
    }

    /**
     * LeaderBoardScore data change listener
     */
    private void addScoreChangeListener() {
        // Score data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                LeaderBoardScores scores = dataSnapshot.getValue(LeaderBoardScores.class);

                // Check for null
                if (scores == null) {
                    Log.e(TAG, "score data is null!");
                    return;
                }
                Log.e(TAG, "score data is changed!" + scores.getName() + ", " + scores.getUser_name());
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read score", error.toException());
            }
        });
    }

}
