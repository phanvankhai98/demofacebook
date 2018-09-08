package com.example.myducument.demofacebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView mTextUser;
    private TextView mTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inIt();
        getInfo();

    }

    private void inIt() {
        mTextPass = findViewById(R.id.text_username);
        mTextUser = findViewById(R.id.text_password);
    }

    public void getInfo() {
        Intent intent = getIntent();
        mTextUser.setText("Chao: " + intent.getStringExtra("user"));
        mTextPass.setText("Pass word: " + intent.getStringExtra("pass"));
    }
}
