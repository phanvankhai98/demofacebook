package com.example.myducument.demofacebook;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mEditUserName;
    private EditText mEditPassWord;
    private Button mButtonLogin;
    private TextView mTextViewSignUp;
    private List<TaiKhoan> QuanLi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuanLi.add(new TaiKhoan("khai", "12345"));
        inIt();
        onClick();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if (resultCode==MainActivity.RESULT_OK) {
                QuanLi.add(new TaiKhoan(data.getStringExtra("user"), data.getStringExtra("pass")));
                mEditUserName.setText(data.getStringExtra("user"));
                mEditPassWord.setText(data.getStringExtra("pass"));
                Toast.makeText(this, "them tai khoan thanh cong!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void onClick() {
        mButtonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user = mEditUserName.getText().toString();
                String pass = mEditPassWord.getText().toString();
                TaiKhoan mTaiKhoan = new TaiKhoan(user, pass);
                int check = checkTaiKhoan(mTaiKhoan);
                if (check == 1) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("user", user);
                    intent.putExtra("pass", pass);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Sai tai khoan hoac mat khau vui long dang nhap lai!!!"
                            , Toast.LENGTH_SHORT).show();
                }
            }

            private int checkTaiKhoan(TaiKhoan mTaiKhoan) {
                for (int i = 0; i < QuanLi.size(); i++) {
                    if (mTaiKhoan.PassWord.equals(QuanLi.get(i).PassWord)&&mTaiKhoan.UserName.equals(QuanLi.get(i).UserName)) return 1;
                }
                return 0;
            }
        });
        mTextViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void inIt() {
        mEditUserName = findViewById(R.id.edit_username);
        mEditPassWord = findViewById(R.id.edit_password);
        mButtonLogin = findViewById(R.id.button_login);
        mTextViewSignUp = findViewById(R.id.text_signup);
    }
}
