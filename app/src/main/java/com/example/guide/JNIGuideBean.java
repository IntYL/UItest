package com.example.guide;

import android.view.View;
import android.widget.Toast;

import com.example.HelloC;
import com.example.uitest.GuideBean;

public class JNIGuideBean extends GuideBean {
    @Override
    public void onClick(View view, String string) {
        Toast.makeText(view.getContext(), HelloC.helloFromC(), Toast.LENGTH_LONG).show();
    }
}
/**
 * Created By leiyao6 on
 */