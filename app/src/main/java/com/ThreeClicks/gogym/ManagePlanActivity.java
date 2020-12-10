package com.ThreeClicks.gogym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.ThreeClicks.gogym.adapter.AddGymAdapter;
import com.ThreeClicks.gogym.adapter.AddPlanAdapter;
import com.ThreeClicks.gogym.data.AddGymData;
import com.ThreeClicks.gogym.data.AddPlanData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManagePlanActivity extends AppCompatActivity {
ImageView addPlan;
Toolbar toolbar;
    private static final String TAG = "ManagePlanActivity";
SharedPreferences sharedPreferences;
RecyclerView planRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_plan);
        toolbar=(Toolbar) findViewById(R.id.managePlanToolbar);
        sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addPlan=(ImageView) findViewById(R.id.addPlan);
        planRecyclerview=(RecyclerView) findViewById(R.id.plan_recyclerview);
        if (getPlanData() != null) {
            populateList(getPlanData(), planRecyclerview);

        }
        addPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(ManagePlanActivity.this,AddPlanActivity.class);
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
    ArrayList<AddPlanData> getPlanData() {
        ArrayList<AddPlanData> addPlanDataList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("planSet", "");
        Type type = new TypeToken<ArrayList<AddPlanData>>() {
        }.getType();
        addPlanDataList = gson.fromJson(json, type);
        return addPlanDataList;
    }

    public void populateList(ArrayList<AddPlanData> list, RecyclerView recyclerView) {
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        AddPlanAdapter recyclerViewAdapter = new
                AddPlanAdapter(this, list);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getPlanData() != null) {
            populateList(getPlanData(), planRecyclerview);
//        Log.e(TAG, "onResume: "+getGymData().size() );
        }
    }
}