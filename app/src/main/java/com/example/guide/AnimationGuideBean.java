package com.example.guide;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.animationdemo.CircleRevealActivity;
import com.example.uitest.GuideBean;

public class AnimationGuideBean extends GuideBean {
    @Override
    public void onClick(View view, String string) {
        if (view==null)return;
        Context context = view.getContext();
        Intent intent = new Intent();
        intent.setClass(context,CircleRevealActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        CircleRevealActivity.startActivity(context,intent);

    }
}
/**
 * Created By leiyao6 on
 */