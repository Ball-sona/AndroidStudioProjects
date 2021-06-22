package com.example.samplelifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        println("onPause 호출됨");
        saveState(); //현재 입력상자에 입력된 데이터를 저장
    }

    @Override
    protected void onResume() {
        super.onResume();
        println("onResume호출됨");
        restoreState();
    }

    public void println(String data){
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        Log.d("Main",data);
    }

    protected void restoreState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if( (pref!=null) & (pref.contains("name"))) {
            String name = pref.getString("name", "");
            editText.setText(name);
        }
    }

    protected void saveState(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit(); //데이터 저장 가능
        editor.putString("name",editText.getText().toString());
        editor.commit();
    }

    protected void clearState(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}