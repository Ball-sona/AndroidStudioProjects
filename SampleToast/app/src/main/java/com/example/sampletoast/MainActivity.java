package com.example.sampletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
    }

    /*public void onButton1Clicked(View v){
        try {
            Toast toast = Toast.makeText(this,"토스트다.",Toast.LENGTH_LONG);

            int xOffset = Integer.parseInt(editText1.getText().toString());
            // editText에 적은거 문자열로 배열하고, 그걸 정수로 변환해서 x값 구함.
            int yOffset = Integer.parseInt(editText2.getText().toString());

            toast.setGravity(Gravity.TOP|Gravity.TOP, xOffset, yOffset);
            toast.show();

        } catch ( NumberFormatException e){
            e.printStackTrace(); //에러 메세지 근원지 찾아서 단계별로 에러 출력
        }
    }

    public void onButton2Clicked(View v){
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(
                R.layout.toastborder,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewById(R.id.text);

        Toast toast = new Toast(this);
        text.setText("모양 바꿈");
        toast.setGravity(Gravity.CENTER,0,-100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }*/
    public void onButton3Clicked(View v){
        Snackbar.make(v, "스낵바임", Snackbar.LENGTH_LONG).show();
    }
}