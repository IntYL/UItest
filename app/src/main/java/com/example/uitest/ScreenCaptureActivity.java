package com.example.uitest;

import android.content.Context;
import android.content.Intent;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.nio.ByteBuffer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ScreenCaptureActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 10234;
    private final String TAG = ScreenCaptureActivity.class.getSimpleName();
    private Button screenBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_capture_layout);
        screenBtn = findViewById(R.id.screen_btn);
        screenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScreenRecording();
            }
        });
    }


    /**
     * 获取屏幕录制的权限
     */
    private void startScreenRecording() {
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
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
    private int width;
    private int heigth;
    private MediaCodec deCoder;
    private MediaCodec enCoder;
    private void getSize(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = getWindowManager();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        heigth = displayMetrics.heightPixels;
    }
    private void initDeCodec(){
        try {
            //创建视频编码器，
            enCoder = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_AVC);
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
        enCoder.setCallback(new MediaCodec.Callback() {
            @Override
            public void onInputBufferAvailable(@NonNull MediaCodec codec, int index) {
                ByteBuffer inputBuffer = codec.getInputBuffer(index);
                //codec.queueInputBuffer(index,);
            }

            @Override
            public void onOutputBufferAvailable(@NonNull MediaCodec codec, int index, @NonNull MediaCodec.BufferInfo info) {
               ByteBuffer outputBuffer = codec.getOutputBuffer(index);

               //codec.releaseOutputBuffer(index);
            }

            @Override
            public void onError(@NonNull MediaCodec codec, @NonNull MediaCodec.CodecException e) {

            }

            @Override
            public void onOutputFormatChanged(@NonNull MediaCodec codec, @NonNull MediaFormat format) {

            }
        });
    }
}
/**
 * Created By leiyao6 on
 */