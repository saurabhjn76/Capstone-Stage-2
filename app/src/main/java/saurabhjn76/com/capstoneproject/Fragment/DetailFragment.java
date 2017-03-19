package saurabhjn76.com.capstoneproject.Fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import saurabhjn76.com.capstoneproject.Adapter.ImageAdapter;
import saurabhjn76.com.capstoneproject.Models.Question;
import saurabhjn76.com.capstoneproject.R;
import saurabhjn76.com.capstoneproject.ui.QuestionsActivity;

public class DetailFragment extends Fragment {
    public static DetailFragment instance;
    public View detailFragmentView;
    TextView startQuiz;
    int question_id;
    ImageView Fav;

    public DetailFragment() {
        instance=this;
    }

    public static DetailFragment newInstance(Question newMovie) {
        Bundle args = new Bundle();
        DetailFragment fragment = new DetailFragment();
      //  args.putParcelable("QUESTION",question);
        //fragment.setArguments(args);
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
        if(getActivity().getIntent().getIntExtra("POSITION",-23)!=-23)
            question_id = getActivity().getIntent().getIntExtra("POSITION",-23);
        Log.e("Ques",question_id+"");
        Picasso.with(getContext())
                .load(ImageAdapter.mImgUrls[question_id])//this is optional the image to display while the url image is downloading
                .error(R.drawable.app_logo)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                .into((ImageView)detailFragmentView.findViewById(R.id.detailImage));
        TextView detailHead=(TextView) detailFragmentView.findViewById(R.id.detailHeading);
        detailHead.setText(ImageAdapter.mCatIds[question_id]);
        startQuiz=(TextView)detailFragmentView.findViewById(R.id.strq);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),QuestionsActivity.class);
                startActivity(intent);
            }
        });



    }
}
