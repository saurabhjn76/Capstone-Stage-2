package saurabhjn76.com.capstoneproject.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import saurabhjn76.com.capstoneproject.Models.Question;
import saurabhjn76.com.capstoneproject.R;

public class DetailFragment extends Fragment {
    public static DetailFragment instance;
    RequestQueue ReqQueue;

    // public String key = "c8618ff3d5fd73e6601c1d5e1ef3f337";// Wrong Key
    public String key ="Insert Your Key Here";

    public LinearLayout trailersList;
    public LinearLayout reviewList;
    public View detailFragmentView;
    TextView startQuiz;
    Question movies;
    ImageView Fav;

    public DetailFragment() {
        instance=this;
    }

    public static DetailFragment newInstance(Question newMovie) {
        Bundle args = new Bundle();
        DetailFragment fragment = new DetailFragment();
        args.putParcelable("movies", newMovie);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        detailFragmentView = inflater.inflate(R.layout.fragment_detail, container, false);
        return  detailFragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ReqQueue= Volley.newRequestQueue(getActivity().getApplicationContext());
        if (getArguments() != null)
            movies = getArguments().getParcelable("movies");
        if(getActivity().getIntent().getParcelableExtra(Intent.EXTRA_SUBJECT)!=null)
            movies = getActivity().getIntent().getParcelableExtra(Intent.EXTRA_SUBJECT);

        startQuiz=(TextView)detailFragmentView.findViewById(R.id.strq);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),QuestionsActivity.class);
                startActivity(intent);
            }
        });
      //  getReviews(movies.id);
        //TextView headder=  ((TextView) detailFragmentView.findViewById(R.id.textView_movietitle));
       // headder.setText(movies.name);
        //Picasso.with(getActivity()).load(movies.poster_url).
          //      placeholder(R.mipmap.ic_launcher).into((ImageView)detailFragmentView.findViewById(R.id.imageView));
        //((TextView) detailFragmentView.findViewById(R.id.textView_plotSynopsis)).setText(movies.synopsis);
        //((RatingBar) detailFragmentView.findViewById(R.id.ratingBar)).setRating(movies.rating / 2f);
        //((TextView) detailFragmentView.findViewById(R.id.Rating_text)).setText((float) Math.round(movies.rating*10d)/10d + "/10");

       /* SimpleDateFormat df = new SimpleDateFormat("dd MMM, yyyy");
        SimpleDateFormat dfInput = new SimpleDateFormat("yyyy-MM-dd");
        String releasedDate;
        try {
            releasedDate = df.format(dfInput.parse(movies.released_date));
        } catch (ParseException e){
            e.printStackTrace();
            releasedDate = movies.released_date;
        }*/
        //((TextView) detailFragmentView.findViewById(R.id.textView_release_date)).setText(releasedDate);
        //Fav=(ImageView) detailFragmentView.findViewById(R.id.favourite);
        ContentResolver contentResolver = getActivity().getApplicationContext().getContentResolver();

    }


    /*public void getReviews(int id){
        String url = "http://api.themoviedb.org/3/movie/" + id + "/reviews?api_key=" + key;
        //System.out.println("link" +url);

        JsonObjectRequest req = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray items = response.getJSONArray("results");
                            JSONObject reviewObj;
                            View view;
                            for (int i = 0; i < items.length(); i++) {
                                reviewObj = items.getJSONObject(i);
                                Review review = new Review(reviewObj.getString("author"),reviewObj.getString("content"),reviewObj.getString("url"));
                                reviewsAdapter.addReview(review);

                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                        if(reviewsAdapter.getCount()==0){
                            reviewList.addView(reviewsAdapter.getView(-1,null,null));
                        }
                        for (int i = 0; i < reviewsAdapter.getCount(); i++){
                            reviewList.addView(reviewsAdapter.getView(i, null, null));
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error in json parsing
            }
        });

        ReqQueue.add(req);
    }
*/



}
