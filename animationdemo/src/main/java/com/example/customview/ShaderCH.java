package com.example.customview;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;

public class ShaderCH {
    View view;
    HandlerThread s;
    ThreadLocal<Integer> integerThreadLocal;
    ViewGroup viewGroup;
    Bitmap mBitQQ = null;
    int BitQQwidth = 0;
    int BitQQheight = 0;
    Paint mPaint = null;
    Shader mBitMapShader = null;
    Shader mLinearDradient = null;
    Shader mComposeShader = null;
    Shader mRadialGradient = null;

    private void setIntegerThreadLocal(){
        integerThreadLocal = new ThreadLocal<>();
        integerThreadLocal.get();
        integerThreadLocal.set(1);
    }
}
