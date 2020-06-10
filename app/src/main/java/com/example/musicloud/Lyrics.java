package com.example.musicloud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lyrics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);
    }


    public void goPlayList(View view){
        Intent intent = new Intent(this, Playlist.class);
        startActivity(intent);
    }

    public void goBack(View view){
        super.onBackPressed();
    }

    public void goPlayInfo(View view){
        Intent intent = new Intent(this, Playinfo.class);
        startActivity(intent);
    }

    public void goSearch(View view){
        Intent intent = new Intent(this, LyricsSearch.class);
        startActivity(intent);
    }
}