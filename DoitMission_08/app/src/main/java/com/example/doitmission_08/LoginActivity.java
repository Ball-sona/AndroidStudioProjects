package com.example.doitmission_08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    EditText editId;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editId = findViewById(R.id.editText);
        editPassword = findViewById(R.id.editPassword);

        Button button = findViewById(R.id.button4);
        button.setOnClickListener(v -> {
            if (checkLogin()) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            } else {
                Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 모두 입력하세요", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean checkLogin() {
        String id = editId.getText().toString();
        String password = editPassword.getText().toString();

        if( id.length() <1 || password.length() < 1) return false;
        else return true;
    };

}