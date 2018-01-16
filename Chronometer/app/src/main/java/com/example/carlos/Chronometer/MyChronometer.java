package com.example.carlos.Chronometer;

import android.widget.Chronometer;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;

/**
 * Custom Chronometer class.
 * Changes from the original Chronometer Class:
 *  isRunning:boolean
 *  lastPause:long
 */
public class MyChronometer extends Chronometer {

    private boolean isRunning = false; //Chronometer is running
    private long lastPause; //Last paused time

    public MyChronometer(Context context) {
        super(context);
    }

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyChronometer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void start() {
        this.setBase(this.getBase() + SystemClock.elapsedRealtime() - lastPause);
        super.start();
        isRunning = true;
    }

    @Override
    public void stop() {
        lastPause = SystemClock.elapsedRealtime();
        super.stop();
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

}
