package com.example.doitmission_08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int CUSTOMER_FROM_MENU = 110;
    public static final int SALES_FROM_MENU = 111;
    public static final int PRODUCT_FROM_MENU = 112;
    public static final int CUSTOMER_TO_MAIN = 120;
    public static final int CUSTOMER_TO_LOGIN = 121;
    public static final int SALES_TO_MAIN = 122;
    public static final int SALES_TO_LOGIN = 123;
    public static final int PRODUCT_TO_MAIN = 124;
    public static final int PRODUCT_TO_LOGIN = 125;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == CUSTOMER_TO_MAIN)
            println(data.getExtras().getString("buttonName"));
        else if(resultCode==CUSTOMER_TO_LOGIN) {
            println(data.getExtras().getString("buttonName"));
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
        else if(resultCode == SALES_TO_MAIN)
            println(data.getExtras().getString("buttonName"));
        else if(resultCode==SALES_TO_LOGIN) {
            println(data.getExtras().getString("buttonName"));
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
        else if(resultCode == PRODUCT_TO_MAIN)
            println(data.getExtras().getString("buttonName"));
        else if(resultCode==PRODUCT_TO_LOGIN) {
            println(data.getExtras().getString("buttonName"));
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),Sub1.class);
            startActivityForResult(intent,CUSTOMER_FROM_MENU);
        });
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),Sub2.class);
            startActivityForResult(intent,SALES_FROM_MENU);
        });
        button3.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),Sub3.class);
            startActivityForResult(intent,PRODUCT_FROM_MENU);
        });
    }

    private void println(String string){
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

}