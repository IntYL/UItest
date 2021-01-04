package com.example.uitest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class BottomBulletSpan extends ReplacementSpan {
    private Paint mPaint;
    static Random random = new Random();
    private int mWidth = -1;
    private RectF mRectF = new RectF();

    private int[] mColors = new int[20];

    public BottomBulletSpan() {
        initPaint();
        //initColors();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    private void initColors() {
        for(int index = 0 ; index < mColors.length ; index++) {
            mColors[index] = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        //return text with relative to the Paint
        mWidth = (int) paint.measureText(text, start, end);
        return mWidth;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float charx = x;
        for(int i = start ; i<end; i++) {
            String charAt = extractText(text, i, i + 1);
            float charWidth = paint.measureText(charAt);
            float xP = (charx+charx+charWidth)/2;
            float yP= bottom;
            mRectF.set(charx, top, charx += charWidth, bottom);
            //根据每个字的位置绘制背景
            canvas.drawCircle(xP,yP,4,mPaint);
        }
        //绘制字体，如果不掉用这个函数，就不会显示字体啦。
        canvas.drawText(text, start, end, x, y, paint);
    }

    private String extractText(CharSequence text, int start, int end) {
        return text.subSequence(start, end).toString();
    }
}
/**
 * Created By leiyao6 on
 */