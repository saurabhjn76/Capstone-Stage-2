package saurabhjn76.com.capstoneproject.data;

/**
 * Created by saurabh on 21/3/17.
 */
import android.net.Uri;
import android.provider.BaseColumns;

public class ScoreContract {

    public static final String AUTHORITY = "saurabhjn76.com.capstoneproject";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public ScoreContract(){
    }

    public static final class ScoreEntry implements BaseColumns {
        public static final String TABLE_NAME = "scores";
        public static final String COLUMN_NAME = "category_name";
        public static final String COLUMN_LEVEL = "level";
        public static final String COLUMN_DATE = "quiz_date";
        public static final String COLUMN_SCORE = "score";
        public static final String COLUMN_ID = "id";

    }
}
