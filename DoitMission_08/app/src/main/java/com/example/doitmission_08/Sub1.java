package com.example.doitmission_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sub1 extends AppCompatActivity {
    public static final int CUSTOMER_TO_MAIN = 120;
    public static final int CUSTOMER_TO_LOGIN = 121;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Button buttonMenu = findViewById(R.id.button5);
        buttonMenu.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("buttonName","고객관리 -> 메뉴");
            setResult(CUSTOMER_TO_MAIN,intent);
            finish();
        });

        Button buttonLogin = findViewById(R.id.button6);
        buttonLogin.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("buttonName","고객관리 -> 로그인");
            setResult(CUSTOMER_TO_LOGIN,intent);
            finish();
        });
    }

}