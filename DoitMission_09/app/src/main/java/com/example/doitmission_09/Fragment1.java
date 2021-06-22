package com.example.doitmission_09;


import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1,container,false);

        Button button = rootView.findViewById(R.id.button);
        EditText editTextBirth = rootView.findViewById(R.id.editTextBirth);
        EditText editTextName = rootView.findViewById(R.id.editTextName);
        EditText editTextAge = rootView.findViewById(R.id.editTextAge);

        //현재 날짜 초기화
        Date today = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("yyyy/mm/dd");
        editTextBirth.setText(Format.format(today));

        //날짜 선택 버튼 누르면 dialog 뜨게 하기
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editTextBirth.setText(year+"/"+month+"/"+dayOfMonth);
                    }
                },2021,6,21);
                dialog.show();
            }
        });

        //저장 버튼 누르면 토스트 뜨기.
        Button button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "이름 :"+editTextName.getText()+", 나이 : "+ editTextAge.getText()+", 생년월일 : "+editTextBirth.getText(), Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;

    }
}
