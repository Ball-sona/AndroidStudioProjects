package com.example.samplepager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3); //미리 로딩해놓을 아이템의 개수는 3개. -> 빠르게 좌우 스크롤 가능

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        fragment1 fragment1 = new fragment1();
        adapter.addItem(fragment1);
        fragment2 fragment2 = new fragment2();
        adapter.addItem(fragment2);
        fragment3 fragment3 = new fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);


    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }
        public Fragment getItem(int position){
            return items.get(position);
        }
        public int getCount(){
            return items.size();
        }
    }
}

//어뎁터는 각 프래그먼트를 관리하는 역할, 뷰페이저에 설정하면 서로 상호작용하면서 화면에 표시
//ArrayList를 만들어서 거기다가 프래그먼트 객체들을 담아.
