package com.example.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import androidx.annotation.Nullable;

import com.example.uitest.TouchEventActivity;

/**
 * Created by leiyao6
 * on2021/3/23
 */
public class TouchView extends View {
    public TouchView(Context context) {
        super(context);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TouchEventActivity.TAG,"    TouchView  dispatchTouchEvent:"+TouchEventActivity.getAction(event));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TouchEventActivity.TAG,"    TouchView onTouchEvent:"+TouchEventActivity.getAction(event));
        return true;
    }
}
