package saurabhjn76.com.capstoneproject.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import saurabhjn76.com.capstoneproject.Adapter.ScoreAdapter;
import saurabhjn76.com.capstoneproject.Models.Score;
import saurabhjn76.com.capstoneproject.Models.User;
import saurabhjn76.com.capstoneproject.R;
import saurabhjn76.com.capstoneproject.data.ScoresDB;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private TextView name,email;
    String userId ;
    ScoresDB mdb;
    ListView lv;
    Context context;
    ScoreAdapter scoreAdapter;
    private static final String TAG = ProfileActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        auth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        context=this;
        mdb = new ScoresDB();
        lv=(ListView) findViewById(R.id.listView);
        scoreAdapter= new ScoreAdapter(this,mdb.getAllScores(getContentResolver())); // TODO: pass on loader
        lv.setAdapter(scoreAdapter);

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");

        name= (TextView) findViewById(R.id.name);
        email=(TextView) findViewById(R.id.email);
        userId =auth.getCurrentUser().getUid();
        mDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                User user = dataSnapshot.getValue(User.class);

                Log.d(TAG, "User name: " + user.getName() + ", email " + user.getEmail());
                name.setText(user.getName());
                email.setText(user.getEmail());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}
