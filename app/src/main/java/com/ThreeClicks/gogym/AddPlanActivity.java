package com.ThreeClicks.gogym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddPlanActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Add Tax");
    }
}