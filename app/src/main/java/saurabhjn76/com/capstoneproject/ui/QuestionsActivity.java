package saurabhjn76.com.capstoneproject.ui;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import saurabhjn76.com.capstoneproject.Models.Question;
import saurabhjn76.com.capstoneproject.R;

public class QuestionsActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     *
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private RequestQueue mRequestQueue;
    private ArrayList<Question> questions;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        fetch("medium",12);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);



       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }
    private void fetch(String difficulty, final int category) {

        String url="https://opentdb.com/api.php?amount=10&category="+category+"&difficulty="+difficulty+"&type=multiple";
        JsonObjectRequest request = new JsonObjectRequest(
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        // TODO: Parse the JSON
                        try {
                            JSONArray items = jsonObject.getJSONArray("results");
                            JSONObject questionObj;
                            for (int i=0; i<items.length(); i++){
                                questionObj = items.getJSONObject(i);

                                JSONArray st = questionObj.getJSONArray("incorrect_answers");
                                String[] inc =new String[st.length()];
                                for(int j=0;j<st.length();j++)
                                    inc[j]=st.getString(j);

                                Question question = new Question(i,questionObj.getString("question"),category,questionObj.getString("correct_answer"),inc,questionObj.getString("difficulty"));
                                    mSectionsPagerAdapter.addQuestion(question);
                                    mSectionsPagerAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(QuestionsActivity.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        mRequestQueue.add(request);
    }
    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_QUESTION = "QUESTION";
        private static final  String ARG_CORRRECT_ANS="ANSWER";
        private static final String ARG_INCORRECT_1="INC1";
        private static final String ARG_INCORRECT_2="INC3";
        private static final String ARG_INCORRECT_3="INC3";



        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber,Question question) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_QUESTION,question.getName());
            args.putString(ARG_CORRRECT_ANS,question.getCorrect_ans());
            args.putString(ARG_INCORRECT_1,question.getIncorrect_ans1());
            args.putString(ARG_INCORRECT_2,question.getIncorrect_ans2());
            args.putString(ARG_INCORRECT_3,question.getIncorrect_ans3());
            fragment.setArguments(args);
            return fragment;
        }



        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_questions, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.Question);
            Button button1 = (Button) rootView.findViewById(R.id.ans1);
            Button button2 = (Button) rootView.findViewById(R.id.ans2);
            Button button3 = (Button) rootView.findViewById(R.id.ans3);
            Button button4 = (Button) rootView.findViewById(R.id.ans4);
            textView.setText(getArguments().getString(ARG_QUESTION));
            Random random =new Random();

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public ArrayList<Question> questions = new ArrayList<Question>();
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1,questions.get(position));
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return questions.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return questions.get(position).getCategory()+"";
        }
        public void addQuestion(Question question){
            questions.add(question);
        }
    }
}
