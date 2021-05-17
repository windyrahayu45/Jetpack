package com.dicoding.windi.jetpack.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dicoding.windi.jetpack.R;
import com.dicoding.windi.jetpack.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActivityHomeBinding activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        activityHomeBinding.viewPager.setAdapter(sectionsPagerAdapter);
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }
}