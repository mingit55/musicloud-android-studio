package com.example.musicloud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    String USER_ID = "tester";
    String PASSWORD = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void onSignIn(View view){
        EditText i_user_id = findViewById(R.id.user_id);
        String user_id = i_user_id.getText().toString();

        EditText i_password = findViewById(R.id.password);
        String password = i_password.getText().toString();

        if(user_id.equals(USER_ID) && password.equals(PASSWORD)){
            Toast.makeText(this, "로그인 되었습니다!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "아이디 혹은 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
        }

    }

    public void goJoin(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}