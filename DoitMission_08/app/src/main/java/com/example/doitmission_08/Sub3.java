package com.example.doitmission_08;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sub3 extends AppCompatActivity {
    public static final int PRODUCT_TO_MAIN = 124;
    public static final int PRODUCT_TO_LOGIN = 125;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Button buttonMenu = findViewById(R.id.button5);
        buttonMenu.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("buttonName","상품관리 -> 메뉴");
            setResult(PRODUCT_TO_MAIN,intent);
            finish();
        });

        Button buttonLogin = findViewById(R.id.button6);
        buttonLogin.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("buttonName","상품관리 -> 로그인");
            setResult(PRODUCT_TO_LOGIN,intent);
            finish();
        });
    }
}