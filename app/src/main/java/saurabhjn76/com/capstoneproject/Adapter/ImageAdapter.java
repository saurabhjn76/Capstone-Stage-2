package saurabhjn76.com.capstoneproject.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import saurabhjn76.com.capstoneproject.R;

/**
 * Created by saurabh on 12/3/17.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder= null;
        ImageView imageView;
        LayoutInflater mInflater = (LayoutInflater) mContext
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes

            convertView = mInflater.inflate(R.layout.custom_row, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.category);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);


           /* imageView.setPadding(0,4,0,4);*/
        } else {
           // imageView = (ImageView) convertView;
            holder = (ViewHolder) convertView.getTag();

        }

        holder.imageView.setImageResource(mThumbIds[position]);
        holder.txtTitle.setText(mCatIds[position]);
        return convertView;
    }
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
    }


    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.history, R.drawable.art,
            R.drawable.geo, R.drawable.math,
            R.drawable.animals,R.drawable.music,
            R.drawable.film,R.drawable.sports,
            R.drawable.board_game,R.drawable.books_small,
            R.drawable.celebrities,R.drawable.computer,
            R.drawable.science_nature,R.drawable.v_gam,
            R.drawable.musictheater,R.drawable.mytho,
            R.drawable.series,R.drawable.politics,
            R.drawable.gk,R.drawable.random

    };
    private String[] mCatIds = {
            "History","Arts","Geography"
            ,"Mathmatics","Wildlife","Music",
            "Films","Sports","Board Games","Books",
            "Celebrities","Computers","Science & Nature","Games",
            "Music & Theater", "Mythology", "Television","Politics",
            "GK","Random"
    };
}
