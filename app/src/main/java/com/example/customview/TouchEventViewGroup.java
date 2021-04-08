package com.example.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintSet;

import com.example.uitest.TouchEventActivity;

/**
 * Created by leiyao6
 * on2021/3/23
 */
public class TouchEventViewGroup extends RelativeLayout {
    public TouchEventViewGroup(Context context) {
        super(context);
    }

    public TouchEventViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TouchEventActivity.TAG,"  ViewGroup dispatchTouchEvent:"+TouchEventActivity.getAction(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TouchEventActivity.TAG,"  ViewGroup onInterceptTouchEvent:"+TouchEventActivity.getAction(ev));
        //拦截不处理
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_MOVE)return true;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TouchEventActivity.TAG,"  ViewGroup onTouchEvent:"+TouchEventActivity.getAction(event));
        int action = event.getAction();
        if (action == MotionEvent.ACTION_MOVE)return true;
        return super.onTouchEvent(event);
       // return true;
    }
}
