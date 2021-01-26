package com.example.runnable;

import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.util.DisplayMetrics;

public class ScreenThread extends Thread {

    private MediaFormat mediaFormat;
    private int width;
    private int height;
    public ScreenThread() {
    }

    private void initMediaCodec() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mediaFormat = MediaFormat.createVideoFormat(MediaFormat.MIMETYPE_VIDEO_AVC,width,height);
        mediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT,
                MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface);
        mediaFormat.setInteger(MediaFormat.KEY_BIT_RATE,1000000);
        mediaFormat.setInteger(MediaFormat.KEY_FRAME_RATE,15);
        mediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL,1);
    }
}
/**
 * Created By leiyao6 on
 */