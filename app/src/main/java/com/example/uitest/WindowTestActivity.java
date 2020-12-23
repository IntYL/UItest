package com.example.uitest;

import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.uitest.databinding.WindowTestBinding;

/**
 * Created By leiyao6 on
 */
public class WindowTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowTestBinding windowTestBinding = DataBindingUtil.setContentView(this, R.layout.window_test);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        WinDowBean winDowBean = new WinDowBean();
        winDowBean.setDpi(displayMetrics.densityDpi);
        String resolution = displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        winDowBean.setResolution(resolution);
        float sw1 =(displayMetrics.heightPixels / displayMetrics.density);
        float sw2 =(displayMetrics.widthPixels / displayMetrics.density);
        if (sw1 < sw2) {
            winDowBean.setSw(sw1);
        } else {
            winDowBean.setSw(sw2);
        }
        float intTest = getResources().getDimension(R.dimen.int_test_1);
        winDowBean.setIntTest((int) intTest);
        String str = getResources().getString(R.string.test_str);
        winDowBean.setTestStr(str);
        windowTestBinding.setWinDowBean(winDowBean);
    }
}
