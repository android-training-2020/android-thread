package us.erlang.android_activity;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class TaskHandler extends Handler {
    private Context context;

    public TaskHandler(Context context) {
        this.context = context;
    }

    @Override
    public void handleMessage(Message msg) {
        Toast.makeText(context, CustomMessage.getMessage(msg.what), Toast.LENGTH_LONG).show();
    }
}
