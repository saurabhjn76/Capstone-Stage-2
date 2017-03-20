package saurabhjn76.com.capstoneproject.service;

/**
 * Created by saurabh on 21/3/17.
 */
import android.os.Bundle;
import android.os.Handler;

public class MResultReceiver extends MResultReceiver {
    private Receiver mReceiver;

    public MResultReceiver(Handler handler) {
        super(handler);
    }

    public void setReceiver(Receiver receiver) {
        mReceiver = receiver;
    }

    public interface Receiver {
        public void onReceiveResult(int resultCode, Bundle resultData);
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (mReceiver != null) {
            mReceiver.onReceiveResult(resultCode, resultData);
        }
    }
}
