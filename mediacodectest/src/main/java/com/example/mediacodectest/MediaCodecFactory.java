package com.example.mediacodectest;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaPlayer;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaCodecFactory {

    @TargetApi(21)
    public void CreateMediaCodect() throws IOException {
        MediaCodec mediaCodec = MediaCodec.createDecoderByType(MediaFormat.MIMETYPE_VIDEO_AVC);
        MediaFormat mediaFormat = MediaFormat.createVideoFormat(MediaFormat.KEY_AUDIO_SESSION_ID,1280,720);
        mediaCodec.setCallback(new MediaCodec.Callback() {
            @Override
            public void onInputBufferAvailable(@NonNull MediaCodec codec, int index) {
                 ByteBuffer inputByte = codec.getInputBuffer(index);
                 //fill inputBuffer with valid data
                codec.queueInputBuffer(index,0,0,0,1);
            }

            @Override
            public void onOutputBufferAvailable(@NonNull MediaCodec codec, int index, @NonNull MediaCodec.BufferInfo info) {
                ByteBuffer outputBuffer = codec.getOutputBuffer(index);
                MediaFormat bufferFormat = codec.getOutputFormat(index); // option A
                // bufferFormat is equivalent to mOutputFormat
                // outputBuffer is ready to be processed or rendered.

               // codec.releaseOutputBuffer(index, …);
            }

            @Override
            public void onError(@NonNull MediaCodec codec, @NonNull MediaCodec.CodecException e) {

            }

            @Override
            public void onOutputFormatChanged(@NonNull MediaCodec codec, @NonNull MediaFormat format) {

            }
        });
        mediaCodec.flush();

    }
}
