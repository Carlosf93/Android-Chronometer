package com.example.carlos.Chronometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final android.widget.Button startbutton = findViewById(R.id.startbutton); //START/STOP Button
        final android.widget.Button resetbutton = findViewById(R.id.resetbutton); //RESET Button
        final MyChronometer chrono = findViewById(R.id.chronometer2); //Chronometer
        chrono.stop();

        /**
         * START/STOP Button listener
         */
        startbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!chrono.isRunning()){
                    chrono.start();
                    startbutton.setText("STOP");
                }
                else{
                    chrono.stop();
                    startbutton.setText("START");
                }
            }
        });

        /**
         * RESET Button listener
         */
        resetbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.stop();
                chrono.setBase(android.os.SystemClock.elapsedRealtime());
                chrono.setText("00:00:00");
                startbutton.setText("START");
            }
        });

        /**
         * Chronometer format controller
         */
        chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            public void onChronometerTick(Chronometer c) {
                chrono.setFormat("%s");
                int cTextSize = c.getText().length();
                if (cTextSize == 5) {
                    chrono.setText("00:"+c.getText().toString());
                } else if (cTextSize == 7) {
                    chrono.setText("0"+c.getText().toString());
                } else if (cTextSize == 8) {
                    chrono.setText(c.getText().toString());
                }
            }
        });

    }
}
