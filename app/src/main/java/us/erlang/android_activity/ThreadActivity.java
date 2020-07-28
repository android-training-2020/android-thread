package us.erlang.android_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class ThreadActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        button = findViewById(R.id.start_counter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCounter();
            }
        });
    }

    private void startCounter() {
        button.setEnabled(false);

        new Thread(new Runnable() {
            public void run() {
                int count = 0;

                while (count < 10) {
                    SystemClock.sleep(1000);
                    count++;
                    final int finalCount = count;
                    button.post(new Runnable() {
                        public void run() {
                            button.setText(String.format("%d", finalCount));
                            if (finalCount == 10) {
                                button.setEnabled(true);
                            }
                        }
                    });
                }
            }
        }).start();
    }
}