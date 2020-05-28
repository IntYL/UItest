package com.example.musicdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;


public class MusicActivity extends AppCompatActivity  {
    TextView tv_total_time;
    TextView tv_current_time;
    SeekBar music_seekBar;
    Button btn_start;
    Button btn_pause;
    Button btn_replay;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_demo);
        initView();
    }

    private void initView() {
        tv_total_time = findViewById(R.id.tv_total_time);
        tv_current_time = findViewById(R.id.tv_current_time);
        btn_start = findViewById(R.id.btn_start);
        btn_pause = findViewById(R.id.btn_pause);
        music_seekBar = findViewById(R.id.music_seekBar);
        btn_replay = findViewById(R.id.btn_rePlay);
    }

    private void initMP() {
        mediaPlayer = new MediaPlayer();

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(0);
                mediaPlayer.stop();

            }
        });
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void initMpController() {

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null && !mediaPlayer.isPlaying()){
                    mediaPlayer.prepareAsync();
                }
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer!=null && mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            }
        });
        btn_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}
