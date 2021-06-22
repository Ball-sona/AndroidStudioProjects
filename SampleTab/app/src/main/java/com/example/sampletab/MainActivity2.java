package com.example.sampletab;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;


public class MainActivity2 extends AppCompatActivity {

    fragment1 fragment1;
    fragment2 fragment2;
    fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fragment1 = new fragment1();
        fragment2 = new fragment2();
        fragment3 = new fragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        //초기 프래그먼트는 1로 지정

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected( MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.tab1:
                                Toast.makeText(getApplicationContext(),"첫번째 탭 선택",Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
                                return true;
                            case R.id.tab2:
                                Toast.makeText(getApplicationContext(),"두번째 탭 선택",Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
                                return true;
                            case R.id.tab3:
                                Toast.makeText(getApplicationContext(),"세번째 탭 선택",Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
                                return true;
                        }
                        return false;
                    }
                }
        );


    }
}