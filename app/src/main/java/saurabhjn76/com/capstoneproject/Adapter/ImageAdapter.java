package saurabhjn76.com.capstoneproject.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import saurabhjn76.com.capstoneproject.R;

/**
 * Created by saurabh on 12/3/17.
 */
public class ImageAdapter extends BaseAdapter {
    public static String[] mCatIds = {
            "History", "Arts"
            , "Mathematics", "Wildlife", "Music",
            "Films", "Sports", "Board Games", "Books",
            "Celebrities", "Computers", "Science & Nature", "Games",
            "Music & Theater", "Mythology", "Geography", "Television", "Politics",
            "GK", "Random"
    };
    public static String[] mImgUrls = {
            "https://i.imgsafe.org/d9e2c1b290.jpg", "https://i.imgsafe.org/d9e0c6dbac.jpg",
            "https://i.imgsafe.org/d9e27e8e46.jpg",
            "https://i.imgsafe.org/d9d9d373ec.jpg", "https://i.imgsafe.org/d9e265849b.jpg",
            "https://i.imgsafe.org/d9e1c78a92.jpg", "https://i.imgsafe.org/d9e43bbb17.jpg",
            "https://i.imgsafe.org/d9e1049818.jpg", "https://i.imgsafe.org/d9e14569ab.jpg",
            "https://i.imgsafe.org/d9e1731a0a.jpg", "https://i.imgsafe.org/d9e19a4e86.jpg",
            "https://i.imgsafe.org/da0097b6fd.jpg", "https://i.imgsafe.org/d9e426205f.jpeg",
            "https://i.imgsafe.org/d9e237fecd.jpg", "https://i.imgsafe.org/d9e301d296.jpg",
            "https://i.imgsafe.org/d9e1d7f61a.jpg",
            "https://i.imgsafe.org/d9e46d81a9.jpg", "https://i.imgsafe.org/d9e3163356.jpg",
            "https://i.imgsafe.org/d9ffebe478.png", "https://i.imgsafe.org/da004e30db.jpg"

    };
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mImgUrls.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }


    // references to our images

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
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

        // holder.imageView.setImageResource(mThumbIds[position]);
        Picasso.with(mContext)
                .load(mImgUrls[position])//this is optional the image to display while the url image is downloading
                .error(R.drawable.app_logo)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                .into(holder.imageView);
        holder.txtTitle.setText(mCatIds[position]);
        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
    }

}
