package com.example.uitest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
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
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guide.AnimationGuideBean;
import com.example.guide.CameraGuide;
import com.example.guide.CanvasGuideBean;
import com.example.guide.ClickGuideBean;
import com.example.guide.FileGuideNean;
import com.example.guide.JNIGuideBean;
import com.example.guide.ScreenGuideBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By leiyao6 on
 */
public class GuideActivity extends AppCompatActivity {
   private String TAG = GuideActivity.class.getSimpleName();
    private RecyclerView guideRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_view);
        initGuideRv();
        initDialog();
        Log.d(TAG,"onCreate()");
    }

    private void initDialog(){
        AlertDialog alertDialog =new AlertDialog.Builder(this)
                .setTitle("测试").create();
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

        ScreenGuideBean screenGuideBean = new ScreenGuideBean();
        screenGuideBean.setName("录屏");
        dataList.add(screenGuideBean);

        JNIGuideBean jniGuideBean = new JNIGuideBean();
        jniGuideBean.setName("JNI");
        dataList.add(jniGuideBean);

        ClickGuideBean clickGuideBean = new ClickGuideBean();
        clickGuideBean.setName("ClickDemo");
        dataList.add(clickGuideBean);

        CameraGuide cameraGuide = new CameraGuide();
        cameraGuide.setName("相机");
        dataList.add(cameraGuide);

        FileGuideNean fileGuideNean = new FileGuideNean();
        fileGuideNean.setName("文件系统");
        dataList.add(fileGuideNean);

        GuideAdapter guideAdapter = new GuideAdapter(dataList, this);
        guideRv = findViewById(R.id.guide_rv);
        guideRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        guideRv.setAdapter(guideAdapter);
        requestPermission();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart()");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            int size = grantResults.length;
            for (int i = 0; i < size; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "授权未通过", Toast.LENGTH_LONG).show();
                    return;
                }
            }

        }
    }
    private void requestPermission() {
        List<String> permissionList = new ArrayList<>();
        int result = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        int result1 = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (result1 != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.CAMERA);
        }

        int result2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result2 != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (permissionList.size() > 0) {
            Log.d(TAG, "request permission");
            String[] a = new String[]{};
            ActivityCompat.requestPermissions(this, permissionList.toArray(a), 101);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG,"onConfigurationChanged()");
    }
}
