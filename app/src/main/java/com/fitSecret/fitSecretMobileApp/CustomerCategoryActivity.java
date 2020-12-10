package com.fitSecret.fitSecretMobileApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.fitSecret.fitSecretMobileApp.adapter.AddCategoryAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CustomerCategoryActivity extends AppCompatActivity {
Toolbar toolbar;
SharedPreferences sharedPreferences;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_category);
        toolbar = findViewById(R.id.customer_category_toolbar);
        sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);
        setSupportActionBar(toolbar);
        recyclerView=(RecyclerView) findViewById(R.id.category_recyclerview);
        ImageView addCustomerCategory=(ImageView) findViewById(R.id.add_customer_category);
        addCustomerCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CustomerCategoryActivity.this,AddCustomerCategoryActivity.class);
                startActivity(i);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getCategoryData() != null) {
            populateList(getCategoryData(), recyclerView);
        }
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
    ArrayList<String> getCategoryData() {
        ArrayList<String> categoryDataList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("categorySet", "");
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
        if (getCategoryData() != null) {
            populateList(getCategoryData(), recyclerView);
        }
    }

}