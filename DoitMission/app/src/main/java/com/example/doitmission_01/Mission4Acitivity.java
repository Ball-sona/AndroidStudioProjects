package com.example.doitmission_01;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Mission4Acitivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission4);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView5);
        button1 = (Button) findViewById(R.id.button3);
        button1 = (Button) findViewById(R.id.button4);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                InputFilter[] filter = new InputFilter[1];
                filter[0] = new InputFilter.LengthFilter(80); // 문자 개수 80개로 제한
                editText.setFilters(filter);

                int currentBytes = s.toString().getBytes().length;
                String text = String.valueOf(currentBytes) + " /80 바이트";
                textView.setText(text);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void onButton3Clicked(View v){
        Toast.makeText(getApplicationContext(),(CharSequence) editText.getText(), Toast.LENGTH_LONG). show();
    }
    public void onButton4Clicked(View v){
        finish();
    }
}