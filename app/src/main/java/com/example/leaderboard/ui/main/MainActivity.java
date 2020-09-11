package com.example.leaderboard.ui.main;

import android.content.Intent;
import android.os.Bundle;


import com.example.leaderboard.R;
import com.example.leaderboard.Submission.ProjectSubmission;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.example.leaderboard.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        button = (Button) findViewById(R.id.btSubmit1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProjectSubmission();
            }
        });

    }

    public void openProjectSubmission(){
        Intent intent = new Intent(this, ProjectSubmission.class);
        startActivity(intent);
    }
}