package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class CanvasView extends View {
    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private String TAG = CanvasView.class.getSimpleName();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        Log.d(TAG, "width:" + width + " height:" + height);

        Paint paint = new Paint();
        paint.setColor(Color.LTGRAY);

        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(24);
        canvas.drawColor(Color.BLUE);
        RectF outer = new RectF(500, 500, 700, 700);
        RectF inner = new RectF(550, 550, 650, 650);
        //  canvas.drawRoundRect(0,0,width,height,50,100,paint);
        //canvas.drawCircle(width/2,height/2,100,paint);
        //canvas.drawRect(0, 0, width, height, paint);
        //canvas.drawDoubleRoundRect(outer,50f,100f,inner,50f,100f,paint);
        Matrix matrix;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        canvas.drawRect(50, 50, 300, 300, paint);
        paint.setColor(Color.CYAN);
        canvas.drawRect(250, 250, 500, 500, paint);
        paint.setColor(Color.BLACK);
        canvas.drawRect(50, 50, 500, 500, paint);

        //========================  default & INTERSECT  ==========================
        canvas.save();
        canvas.clipRect(550, 0, 800, 300);
        canvas.clipRect(750, 250, 1000, 500);
        canvas.clipRect(550, 0, 1000, 500);
        canvas.drawColor(Color.YELLOW);
        canvas.restore();

        canvas.drawText("default & INTERSECT", 700, 550, textPaint);

        //========================  DIFFERENCE  ==========================
        canvas.save();
        canvas.clipRect(50, 600, 300, 900);
        canvas.clipRect(250, 850, 500, 1100, Region.Op.DIFFERENCE);
        canvas.clipRect(50, 600, 500, 1100);
        canvas.drawColor(Color.YELLOW);
        canvas.restore();

        canvas.drawText("DIFFERENCE", 200, 1150, textPaint);

        //========================  REVERSE_DIFFERENCE  ==========================
   /*     canvas.save();
        canvas.clipRect(550, 600, 800, 900);
        canvas.clipRect(750, 850, 1000, 1100, Region.Op.REVERSE_DIFFERENCE);
        canvas.clipRect(550, 600, 1000, 1100);
        canvas.drawColor(Color.YELLOW);
        canvas.restore();

        canvas.drawText("REVERSE_DIFFERENCE",700,1150,textPaint);*/

        //========================  REPLACE  ==========================
    /*    canvas.save();
        canvas.clipRect(50, 1150, 300, 1450);
        canvas.clipRect(250, 1400, 500, 1650, Region.Op.REPLACE);
        canvas.clipRect(50, 1150, 500, 1650);
        canvas.drawColor(Color.YELLOW);
        canvas.restore();

        canvas.drawText("REPLACE",200,1700,textPaint);

        //========================  XOR  ==========================
        canvas.save();
        canvas.clipRect(550, 1150, 800, 1450);
        canvas.clipRect(750, 1400, 1000, 1650, Region.Op.XOR);
        canvas.clipRect(550, 1150, 1000, 1650);
        canvas.drawColor(Color.YELLOW);
        canvas.restore();

        canvas.drawText("XOR",700,1700,textPaint);

        //========================  UNION  ==========================
        canvas.save();
        canvas.clipRect(50, 1700, 300, 2000);
        canvas.clipRect(250, 1950, 500, 2200, Region.Op.UNION);
        canvas.clipRect(50, 1700, 500, 2200);
        canvas.drawColor(Color.YELLOW);
        canvas.restore();

        canvas.drawText("UNION",200,2250,textPaint);*/
    }
}
/**
 * Created By leiyao6 on
 */