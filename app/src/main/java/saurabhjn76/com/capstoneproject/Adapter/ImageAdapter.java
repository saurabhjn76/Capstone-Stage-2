package saurabhjn76.com.capstoneproject.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

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
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,600));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.history, R.drawable.art,
            R.drawable.geo, R.drawable.math,
            R.drawable.animals,R.drawable.music,
            R.drawable.film,R.drawable.sports,
            R.drawable.board_game,R.drawable.books,
            R.drawable.celebrities,R.drawable.computer,
            R.drawable.science_nature,R.drawable.v_gam,
            R.drawable.musictheater,R.drawable.mytho,
            R.drawable.series,R.drawable.politics,
            R.drawable.gk,R.drawable.random

    };
}
