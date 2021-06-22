package com.example.sampleparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView textView;

    public static final String KEY_SIMPLE_DATA= "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "sona"); //부가데이터
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent(); //메인액티비티로부터 전달 받은 인텐트 객체를 참조하기 위해서
        processIntent(intent);
    }

    private void processIntent(Intent intent){
            if(intent != null){
                Bundle bundle = intent.getExtras(); //Intent안 Bundle 객체가 반환
                SimpleData data = bundle.getParcelable(KEY_SIMPLE_DATA); //key로 데이터 찾아서 반환
                if(intent != null){
                    textView.setText("전달 받은 데이터\nNumber : "+data.number+ "\nMessage : "+data.message);
                }
            }
    }
}

//Parcelable인터페이스 사용하면 객체 정의해 데이터 전달할 수 있으므로 코드가 좀 더 단순해지고 재사용성 증가.
// 하지만 데이터 담아둘 새로운 객체를 일일이 정의하는 것이 번거로움.