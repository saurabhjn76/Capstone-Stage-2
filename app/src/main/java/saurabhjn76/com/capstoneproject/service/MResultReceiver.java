package saurabhjn76.com.capstoneproject.service;

/**
 * Created by saurabh on 21/3/17.
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

@SuppressLint("ParcelCreator")
public class MResultReceiver extends ResultReceiver {
    private Receiver mReceiver;

    public MResultReceiver(Handler handler) {
        super(handler);
    }

    public void setReceiver(Receiver receiver) {
        mReceiver = receiver;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (mReceiver != null) {
            mReceiver.onReceiveResult(resultCode, resultData);
        }
    }

    public interface Receiver {
        public void onReceiveResult(int resultCode, Bundle resultData);
    }
}
