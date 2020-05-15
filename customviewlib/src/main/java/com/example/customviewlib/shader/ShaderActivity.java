package com.example.customviewlib.shader;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.customviewlib.R;
import com.example.customviewlib.loacation.MyLocationListener;

public class ShaderActivity extends Activity {
    private MyLocationListener locationListener;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shader_layout);
    }
}
