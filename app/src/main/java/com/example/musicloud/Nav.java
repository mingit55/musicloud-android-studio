package com.example.musicloud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.content.SharedPreferences;

import java.util.Locale;

public class Nav extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String lang;
    Spinner spinner;
    int lang_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        // 스피너 초기값 설정
        spinner = findViewById(R.id.lang_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lang_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        // 언어 설정 가져오기
        sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            lang = sharedPreferences.getString("locale", getResources().getConfiguration().getLocales().get(0).getLanguage());
        } else {
            lang = sharedPreferences.getString("locale", Resources.getSystem().getConfiguration().locale.getLanguage());
        }

        // 언어 설정에 맞춰 기본 값 설정
        assert lang != null;
        switch (lang){
            case "ko": { lang_no = 0; break;  }
            case "en": { lang_no = 1; break;  }
        }
        spinner.setSelection(lang_no);

        // 스피너 이벤트 설정
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                // 새롭게 언어를 바꾸었다면 언어 변경
                if(position != lang_no){
                    Locale locale;
                    if(position == 0) {
                        locale = Locale.KOREA;
                        lang = "ko";
                    }
                    else {
                        locale = Locale.US;
                        lang = "en";
                    }

                    // 설정 변경
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("locale", lang);
                    editor.commit();

                    // 앱 재시작
                    Context ctx = Nav.this;
                    ((Activity)ctx).finish();
                    startActivity(new Intent(Nav.this, MainActivity.class));

                    Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                    assert intent != null;
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    finish();
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(lang_no);
            }
        });
    }

    public void goPlayList(View view){
        Intent intent = new Intent(this, Playlist.class);
        startActivity(intent);
    }

    public void goSearch(View view){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    public void goMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goLogin(View view){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

    public void goJoin(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }


    public void goBack(View view){
        super.onBackPressed();
    }


    public void goPlayInfo(View view){
        Intent intent = new Intent(this, Playinfo.class);
        startActivity(intent);
    }


    public void goNav(View view){
        Intent intent = new Intent(this, Nav.class);
        startActivity(intent);
    }
}