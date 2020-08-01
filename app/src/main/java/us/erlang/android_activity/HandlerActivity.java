package us.erlang.android_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class HandlerActivity extends AppCompatActivity {
    private LooperThread looperThread;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        looperThread = new LooperThread(this);
        looperThread.start();


        button1 = findViewById(R.id.send_msg_1);
        button2 = findViewById(R.id.send_msg_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                looperThread.sendMessage(CustomMessage.MESSAGE_TYPE_1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                looperThread.sendMessage(CustomMessage.MESSAGE_TYPE_2);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        looperThread.looper.quit();
    }
}