package com.example.guide;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.uitest.FileDemoActivity;
import com.example.uitest.GuideBean;

/**
 * Created by leiyao6
 * on2021/4/21
 */
public class FileGuideNean extends GuideBean {
    @Override
    public void onClick(View view, String string) {
        if (view == null) return;
        Context context = view.getContext();
        Intent intent = new Intent();
        intent.setClass(context, FileDemoActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        FileDemoActivity.startActivity(context, intent);
    }
}
