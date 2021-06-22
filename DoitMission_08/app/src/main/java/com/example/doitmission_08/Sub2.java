package com.example.doitmission_08;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sub2 extends AppCompatActivity {
    public static final int SALES_TO_MAIN = 122;
    public static final int SALES_TO_LOGIN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Button buttonMenu = findViewById(R.id.button5);
        buttonMenu.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("buttonName","매출관리 -> 메뉴");
            setResult(SALES_TO_MAIN,intent);
            finish();
        });

        Button buttonLogin = findViewById(R.id.button6);
        buttonLogin.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("buttonName","매출관리 -> 로그인");
            setResult(SALES_TO_LOGIN,intent);
            finish();
        });
    }
}