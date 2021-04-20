package com.example.opengl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class MySurfaceView extends GLSurfaceView {
    /**缩放因子*/
    private final float TOUCH_SCALE_FACTOR =180.0f/320;
    private Drawable drawable;
    public MySurfaceView(Context context) {
        super(context);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
