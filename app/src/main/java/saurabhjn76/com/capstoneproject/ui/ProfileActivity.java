package saurabhjn76.com.capstoneproject.ui;

import android.content.Context;
import android.support.v4.content.CursorLoader;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
import saurabhjn76.com.capstoneproject.data.ScoreContract;
import saurabhjn76.com.capstoneproject.data.ScoresDB;

public class ProfileActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

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
    private static final int SCORE_LOADER = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        auth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        context=this;
        mdb = new ScoresDB();
        lv=(ListView) findViewById(R.id.listView);
        scoreAdapter= new ScoreAdapter(this); // TODO: pass on loader
        lv.setAdapter(scoreAdapter);
        getSupportLoaderManager().initLoader(SCORE_LOADER, null, this);

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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,
                ScoreContract.CONTENT_URI,
                ScoreContract.ScoreEntry.SCORE_COLUMNS,
                null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data.getCount() != 0) {
          //  error.setVisibility(View.GONE);
        }
       scoreAdapter.setCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        scoreAdapter.setCursor(null);
    }
}
