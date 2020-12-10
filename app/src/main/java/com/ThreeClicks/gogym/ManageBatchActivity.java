package com.ThreeClicks.gogym;

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

import com.ThreeClicks.gogym.adapter.AddBatchAdapter;
import com.ThreeClicks.gogym.adapter.AddTaxAdapter;
import com.ThreeClicks.gogym.data.AddBatchData;
import com.ThreeClicks.gogym.data.AddTaxData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManageBatchActivity extends AppCompatActivity {
Toolbar toolbar;
ImageView addUser;
SharedPreferences sharedPreferences;
RecyclerView batchRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_batch);
        toolbar=(Toolbar) findViewById(R.id.manageUserToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);
        addUser=(ImageView) findViewById(R.id.addUser);
        batchRecyclerview=(RecyclerView) findViewById(R.id.batch_recyclerview);
        if (getTaxData() != null) {
            populateList(getTaxData(), batchRecyclerview);
        }
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManageBatchActivity.this, AddBatchActivity.class);
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
    ArrayList<AddBatchData> getTaxData() {
        ArrayList<AddBatchData> batchDataArrayList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("batchSet", "");
        Type type = new TypeToken<ArrayList<AddBatchData>>() {
        }.getType();
        batchDataArrayList = gson.fromJson(json, type);
//        Log.e(TAG, "getGymData: " + gymDataList.size());
        return batchDataArrayList;
    }

    public void populateList(ArrayList<AddBatchData> list, RecyclerView recyclerView) {
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        AddBatchAdapter recyclerViewAdapter = new
                AddBatchAdapter(this, list);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getTaxData() != null) {
            populateList(getTaxData(), batchRecyclerview);
        }
    }
}