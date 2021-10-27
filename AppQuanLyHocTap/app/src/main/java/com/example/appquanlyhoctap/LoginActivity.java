package com.example.appquanlyhoctap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;

    TextView textView1;

    Button btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        login();
    }

    public void login() {
        btnDangNhap.setOnClickListener(e -> {

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    public void init() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        textView1 = findViewById(R.id.text2);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
