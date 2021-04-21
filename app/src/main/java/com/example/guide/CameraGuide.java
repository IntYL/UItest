package com.example.guide;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.animationdemo.CircleRevealActivity;
import com.example.uitest.CameraDemoActivity;
import com.example.uitest.GuideBean;
import com.example.uitest.TouchEventActivity;

/**
 * Created by leiyao6
 * on2021/4/21
 */
public class CameraGuide extends GuideBean {
    @Override
    public void onClick(View view, String string) {
        if (view == null) return;
        Context context = view.getContext();
        Intent intent = new Intent();
        intent.setClass(context, CameraDemoActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        CameraDemoActivity.startActivity(context, intent);
    }
}
