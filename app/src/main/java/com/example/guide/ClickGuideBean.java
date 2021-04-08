package com.example.guide;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.animationdemo.CircleRevealActivity;
import com.example.uitest.CanvasActivity;
import com.example.uitest.GuideBean;
import com.example.uitest.TouchEventActivity;

/**
 * Created by leiyao6
 * on2021/3/23
 */
public class ClickGuideBean extends GuideBean {
    @Override
    public void onClick(View view, String string) {
        if (view == null) return;
        Context context = view.getContext();
        Intent intent = new Intent();
        intent.setClass(context, TouchEventActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        CircleRevealActivity.startActivity(context, intent);

    }
}
