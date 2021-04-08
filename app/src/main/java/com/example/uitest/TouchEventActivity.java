package com.example.uitest;

import android.os.Bundle;

import com.example.customview.TouchView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
*      1.无拦截touch事件分发流程
        *Activity dispatchTouchEvent
        *ViewGroup dispatchTouchEvent
        *ViewGroup onInterceptTouchEvent
        *TouchView dispatchTouchEvent
        *TouchView onTouchEvent
        *ViewGroup onTouchEvent
        *Activity onTouchEvent
        *Activity dispatchTouchEvent
        *Activity onTouchEvent
 *   2.
* */
public class TouchEventActivity extends AppCompatActivity implements View.OnTouchListener {
    public static final String TAG = TouchEventActivity.class.getSimpleName();
    private TouchView touchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
        touchView = findViewById(R.id.touchview);
        // view的touch事件会被设置的TouchListener拦截，从而不会触发ontouchEvent;
/*        touchView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "lal", Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "Activity dispatchTouchEvent:"+getAction(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "Activity onTouchEvent:"+getAction(event));
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, "Activity onTouch"+getAction(event));
        return false;
    }

    public static String getAction(MotionEvent event){
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";
            default:
                return "";
        }
    }
}