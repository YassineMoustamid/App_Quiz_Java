package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.security.auth.login.LoginException;


public class login extends AppCompatActivity {
  Button loginbtn;
  EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginbtn=findViewById(R.id.loginbtn);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("yassine")
                    && password.getText().toString().equals("yassine123")){
                    Intent intent =new Intent(login.this,FormQuiz.class);
                    startActivity(intent);
                    finish();

                }else
                    Toast.makeText(login.this,"Login FAILED!!!",Toast.LENGTH_LONG).show();
            }
        });

    }
}