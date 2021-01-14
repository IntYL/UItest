package com.example.uitest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.BulletSpan;
import android.text.style.ImageSpan;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guide.AnimationGuideBean;
import com.example.guide.CanvasGuideBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By leiyao6 on
 */
public class GuideActivity extends AppCompatActivity {

    private RecyclerView guideRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_view);
        initGuideRv();
    }

    private void initGuideRv() {
        List<GuideBean> dataList = new ArrayList<>();
        GuideBean guideBean = new GuideBean();
        guideBean.setName("SpanDemo");
        dataList.add(guideBean);

        AnimationGuideBean animationGuideBean = new AnimationGuideBean();
        animationGuideBean.setName("AnimationDemo");
        dataList.add(animationGuideBean);

        CanvasGuideBean canvasGuideBean = new CanvasGuideBean();
        canvasGuideBean.setName("CanvasDemo");
        dataList.add(canvasGuideBean);

        GuideAdapter guideAdapter = new GuideAdapter(dataList, this);
        guideRv = findViewById(R.id.guide_rv);
        guideRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        guideRv.setAdapter(guideAdapter);
    }
}
