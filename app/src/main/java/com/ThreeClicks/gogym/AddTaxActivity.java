package com.ThreeClicks.gogym;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tax);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Add Tax");
    }
}