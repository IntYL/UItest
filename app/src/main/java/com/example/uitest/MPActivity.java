package com.example.uitest;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/**
 * Created By leiyao6 on
 */
public class MPActivity extends AppCompatActivity {
    List<MediaPlayer> mediaPlayerList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.only_textview);
    }

    private void initMpList(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.good);
    }
}
