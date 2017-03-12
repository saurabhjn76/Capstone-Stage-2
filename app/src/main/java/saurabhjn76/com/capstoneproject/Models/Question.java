package saurabhjn76.com.capstoneproject.Models;

import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by saurabh on 12/3/17.
 */
public class Question implements Parcelable {
    public int id;
    public String name;
    public float rating;
    public String released_date;
    public String synopsis;
    public String poster_url;
    public double popularity;

    public Question()
    {

    }
    protected Question(Parcel in) {
        name = in.readString();
        rating = in.readFloat();
        popularity = in.readDouble();
        released_date = in.readString();
        synopsis = in.readString();
        poster_url = in.readString();
        id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeFloat(rating);
        parcel.writeDouble(popularity);
        parcel.writeString(released_date);
        parcel.writeString(synopsis);
        parcel.writeString(poster_url);
        parcel.writeInt(id);
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel parcel) {
            return new Question(parcel);
        }

        @Override
        public Question[] newArray(int i) {
            return new Question[i];
        }
    };
}

