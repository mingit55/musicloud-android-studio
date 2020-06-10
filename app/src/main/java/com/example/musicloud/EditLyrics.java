package com.example.musicloud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditLyrics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lyrics);
    }

    public void goBack(View view){
        super.onBackPressed();
    }

    public void goSync(View view){
        Intent intent = new Intent(this, FitSync.class);
        startActivity(intent);
    }
}