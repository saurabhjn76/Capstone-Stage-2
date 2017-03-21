package saurabhjn76.com.capstoneproject.Adapter;

/**
 * Created by saurabh on 21/3/17.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import saurabhjn76.com.capstoneproject.Models.Score;
import saurabhjn76.com.capstoneproject.R;
import saurabhjn76.com.capstoneproject.ui.ProfileActivity;

public class ScoreAdapter extends BaseAdapter{
    ArrayList<Score> scores;
    Context context;
    private static LayoutInflater inflater=null;
    public ScoreAdapter(ProfileActivity profileActivity, ArrayList<Score> scores) {
        // TODO Auto-generated constructor stub
        context=profileActivity;
        this.scores=new ArrayList<>(scores);
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return scores.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView date;
        TextView name;
        TextView level;
        TextView score;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.custom_row_scores, null);
        holder.date=(TextView) rowView.findViewById(R.id.date);
        holder.name=(TextView) rowView.findViewById(R.id.name);
        holder.level=(TextView) rowView.findViewById(R.id.level);
        holder.score=(TextView) rowView.findViewById(R.id.score);
        holder.date.setText(scores.get(position).getDate());
        holder.name.setText(scores.get(position).getName());
        holder.score.setText(scores.get(position).getScores()+"");
        holder.level.setText(scores.get(position).getLevel());
        return rowView;
    }

}
