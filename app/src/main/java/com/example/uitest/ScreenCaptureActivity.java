package com.example.uitest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ScreenCaptureActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 10234;
    private final String TAG = ScreenCaptureActivity.class.getSimpleName();
    private Button screenBtn;
    private MediaRecorder mediaRecorder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_capture_layout);
        screenBtn = findViewById(R.id.screen_btn);
        Handler handler;
        ScreenCaptureActivity activity = new ScreenCaptureActivity();
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("11");
        stringThreadLocal.get();
        screenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScreenRecording();
            }
        });
    }

    private MediaProjectionManager mediaProjectionManager;

    /**
     * 获取屏幕录制的权限
     */
    private void startScreenRecording() {
        mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        Intent permissionIntent = mediaProjectionManager.createScreenCaptureIntent();
        startActivityForResult(permissionIntent, REQUEST_CODE);
    }

    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // 获得权限，启动Service开始录制
            /*    Intent service = new Intent(this, ScreenRecordService.class);
                service.putExtra("code", resultCode);
                service.putExtra("data", data);
                service.putExtra("audio", isAudio);
                service.putExtra("width", mScreenWidth);
                service.putExtra("height", mScreenHeight);
                service.putExtra("density", mScreenDensity);
                service.putExtra("quality", isVideoSd);
                startService(service);
                // 已经开始屏幕录制，修改UI状态
                isStarted = !isStarted;
                statusIsStarted();*/
//    simulateHome(); // this.finish(); // 可以直接关闭Activity
                Log.i(TAG, "Started screen recording");
            } else {
                Toast.makeText(this, "跳出提示框", Toast.LENGTH_LONG).show();
                Log.i(TAG, "User cancelled");
            }
        }
    }


    public MediaProjection getMediaProjection(int resultCode, @NonNull Intent resultData) {
        if (resultCode != Activity.RESULT_OK || resultData == null) {
            return null;
        }
        return mediaProjectionManager.getMediaProjection(resultCode, resultData);
    }

  
}
/**
 * Created By leiyao6 on
 */