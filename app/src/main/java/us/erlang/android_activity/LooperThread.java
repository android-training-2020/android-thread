package us.erlang.android_activity;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class LooperThread extends Thread {
    public Looper looper;
    public Handler handler;
    private Context context;

    public LooperThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        Looper.prepare();

        this.looper = Looper.myLooper();
        this.handler = new TaskHandler(context);
        Looper.loop();
    }
}
