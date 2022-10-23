package com.example.aliyiyakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       /* mediaPlayer = MediaPlayer.create(Menu.this, R.raw.mySong);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(30,30);
        mediaPlayer.start();*/
    }
    public void start(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}