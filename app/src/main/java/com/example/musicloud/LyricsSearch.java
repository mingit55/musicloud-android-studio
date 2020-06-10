package com.example.musicloud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LyricsSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics_search);
    }

    public void goBack(View view){
        super.onBackPressed();
    }
    public void goEdit(View view){
        Intent intent = new Intent(this, EditLyrics.class);
        startActivity(intent);
    }
    public void goLyrics(View view){
        Intent intent = new Intent(this, Lyrics.class);
        startActivity(intent);
    }
}