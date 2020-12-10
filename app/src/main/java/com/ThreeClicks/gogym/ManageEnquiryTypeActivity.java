package com.ThreeClicks.gogym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ThreeClicks.gogym.adapter.AddCategoryAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManageEnquiryTypeActivity extends AppCompatActivity {
    Toolbar toolbar;
SharedPreferences sharedPreferences;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_enquiry_type);
        toolbar = (Toolbar) findViewById(R.id.manage_enquiry_type_toolbar);
        setSupportActionBar(toolbar);
        sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);
        recyclerView=(RecyclerView) findViewById(R.id.enquiry_type_recyclerview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView enquiryType=(ImageView) findViewById(R.id.add_enquiry_type);
        if (getEnquiryType() != null) {
            populateList(getEnquiryType(), recyclerView);
        }
        enquiryType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManageEnquiryTypeActivity.this,AddEnquiryType.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    ArrayList<String> getEnquiryType() {
        ArrayList<String> categoryDataList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("enquiryTypeSet", "");
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        categoryDataList = gson.fromJson(json, type);
//        Log.e(TAG, "getGymData: " + gymDataList.size());
        return categoryDataList;
    }

    public void populateList(ArrayList<String> list, RecyclerView recyclerView) {
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        AddCategoryAdapter recyclerViewAdapter = new
                AddCategoryAdapter(list, this);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
    @Override
    protected void onResume() {
        super.onResume();
        if (getEnquiryType() != null) {
            populateList(getEnquiryType(), recyclerView);
        }
    }
}