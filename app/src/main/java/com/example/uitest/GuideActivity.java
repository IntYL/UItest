package com.example.uitest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        GuideAdapter guideAdapter = new GuideAdapter(dataList, this);
        guideRv = findViewById(R.id.guide_rv);
        guideRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        guideRv.setAdapter(guideAdapter);
    }
}
