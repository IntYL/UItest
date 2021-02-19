package com.example.media;

import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.util.Log;
import android.view.Surface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static android.media.MediaCodec.CONFIGURE_FLAG_ENCODE;

class ScreenThread extends Thread {
    private final String TAG = "ScreenThread";
    private MediaProjection mediaProjection;
    private MediaFormat mediaFormat;
    private MediaCodec mediaCodec;
    private VirtualDisplay virtualDisplay;
    private Surface mSurface;
    private int frameBit = 80000000;
    private int frameRate = 15;
    private int frameInterVal = 5;
    private int screenWidth;
    private int screenHeight;
    private Queue<byte[]> screenCacheQueue = new ConcurrentLinkedQueue<>();

    public ScreenThread(MediaProjection mediaProjection, int screenWidth, int screenHeight) {
        this.mediaProjection = mediaProjection;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    private String MEMETYPE = MediaFormat.MIMETYPE_VIDEO_AVC;

    /**
     * 初始化Codec
     */
    private void intMediaCodec() {
        mediaFormat = MediaFormat.createVideoFormat(MEMETYPE, screenWidth, screenHeight);
        mediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface);
        mediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, frameBit);
        mediaFormat.setInteger(MediaFormat.KEY_FRAME_RATE, frameRate);
        mediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, frameInterVal);
        try {
            mediaCodec = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_AVC);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
            return;
        }
        mediaCodec.configure(mediaFormat, null, null, CONFIGURE_FLAG_ENCODE);
        mSurface = mediaCodec.createInputSurface();
        mediaCodec.start();


    }

    /**
     * 发送录屏数据
     */
    private void sendScreenData() {

    }

    /**
     * 获取录屏数据
     */
    private void getScreenBuffer() {


            byte[] keyframe = null;
            MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

            try {
                int outputBufferIndex = mediaCodec.dequeueOutputBuffer(mBufferInfo, 10);
                while (outputBufferIndex >= 0) {
          /*          ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(outputBufferIndex);
                    byte[] outData = new byte[mBufferInfo.size];
                    outputBuffer.get(outData);
                    if (mBufferInfo.flags == MediaCodec.BUFFER_FLAG_CODEC_CONFIG) {
                        configbyte = new byte[mBufferInfo.size];
                        configbyte = outData;
                    } else if (mBufferInfo.flags == MediaCodec.BUFFER_FLAG_KEY_FRAME) {
                        keyframe = new byte[mBufferInfo.size + configbyte.length + commandJson.length + 4 + 4];
                        SysUtilEx.int2Byte(commandJson.length, keyframe, 0);//json长度
                        System.arraycopy(commandJson, 0, keyframe, 4, commandJson.length);

                        SysUtilEx.int2Byte(mBufferInfo.size + configbyte.length, keyframe, commandJson.length + 4);
                        System.arraycopy(configbyte, 0, keyframe, commandJson.length + 4 + 4, configbyte.length);
                        System.arraycopy(outData, 0, keyframe, configbyte.length + commandJson.length + 4 + 4, outData.length);
                        if (byteQueue.size() > BYTE_SIZE) {
                            byteQueue.clear();
                        }
                        byteQueue.add(keyframe);

                    } else {
                        keyframe = new byte[outData.length + commandJson.length + 4 + 4];
                        SysUtilEx.int2Byte(commandJson.length, keyframe, 0);//json长度
                        System.arraycopy(commandJson, 0, keyframe, 4, commandJson.length);
                        SysUtilEx.int2Byte(outData.length, keyframe, commandJson.length + 4);
                        System.arraycopy(outData, 0, keyframe, commandJson.length + 4 + 4, outData.length);

                        if (byteQueue.size() > BYTE_SIZE) {
                            byteQueue.clear();
                        }
                        byteQueue.add(keyframe);

                    }


                    mEncoder.releaseOutputBuffer(outputBufferIndex, false);
                    outputBufferIndex = mEncoder.dequeueOutputBuffer(mBufferInfo, TIMEOUT_USEC);*/
                }
            } catch (Exception e) {
                Log.e(TAG, "数据异常：" + e.fillInStackTrace());
            }
        }


    /**
     * 连接数据流
     */
    private void connectIp() {

    }

    public ScreenThread(@Nullable ThreadGroup group, @Nullable Runnable target) {
        super(group, target);
    }

    public ScreenThread(@Nullable ThreadGroup group, @NonNull String name) {
        super(group, name);
    }
}
/**
 * Created By leiyao6 on
 */