package com.example.sampletab;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    fragment1 fragment1;
    fragment2 fragment2;
    fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //액티비티에 디폴트로 만들어진 액션바가 없을 경우에만 작동한다.

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);

        fragment1 = new fragment1();
        fragment2 = new fragment2();
        fragment3 = new fragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        //초기 프래그먼트는 1로 지정

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition(); //Return the current position of this tab in the action bar.
                Log.d("MainActivity","선택탭 : " +position);

                Fragment selected = null;
                if(position == 0){
                    selected = fragment1;
                } else if(position == 1){
                    selected = fragment2;
                } else if(position == 2){
                    selected = fragment3;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container,selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}