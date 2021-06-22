package com.example.doitmission_01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LayoutCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this); //리니어 레이아웃 초기화
        mainLayout.setOrientation(LinearLayout.VERTICAL); //방향 설정

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );

        Button button1 = new Button(this);
        button1.setText("버튼1");
        button1.setLayoutParams(params);
        mainLayout.addView(button1);

        setContentView(mainLayout);
    }
}