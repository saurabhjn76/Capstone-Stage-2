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
    public int category;
    public String correct_ans;
    public String incorrect_ans1,incorrect_ans2,incorrect_ans3;
    public String level;

    public Question(int id,String name, int Category, String correct_ans, String[] incorrect, String level)
    {
        this.id=id;
        this.name=name;
        this.level=level;
        this.correct_ans=correct_ans;
        this.incorrect_ans1=incorrect[0];
        this.incorrect_ans2=incorrect[1];
        this.incorrect_ans3=incorrect[2];
        this.category=category;
    }
    protected Question(Parcel in) {
        name = in.readString();
        category = in.readInt();
        correct_ans = in.readString();
        incorrect_ans1 = in.readString();
        incorrect_ans2 = in.readString();
        incorrect_ans3 = in.readString();
        level = in.readString();
        id = in.readInt();
    }

    public int getCategory() {
        return category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(correct_ans);
        parcel.writeString(correct_ans);
        parcel.writeString(correct_ans);
        parcel.writeString(correct_ans);
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

