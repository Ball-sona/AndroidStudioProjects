package com.example.samplefragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
                            implements ListFragment.ImageSelectionCallback{

    ListFragment listFragment;
    ViewerFragment viewerFragment;

    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.ViewerFragment);
    }

    @Override
    public void onImageSelected(int position){
        viewerFragment.setImage(images[position]);
    }
}