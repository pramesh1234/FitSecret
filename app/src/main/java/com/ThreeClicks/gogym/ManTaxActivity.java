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
import com.ThreeClicks.gogym.adapter.AddTaxAdapter;
import com.ThreeClicks.gogym.data.AddGymData;
import com.ThreeClicks.gogym.data.AddTaxData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManTaxActivity extends AppCompatActivity {
    ImageView addTax;
    RecyclerView taxRecyclerView;
    Toolbar toolbar;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_tax);
        addTax = (ImageView) findViewById(R.id.addTax);
        toolbar = (Toolbar) findViewById(R.id.manageTaxToolbar);
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        taxRecyclerView = (RecyclerView) findViewById(R.id.tax_recyclerview);
        if (getTaxData() != null) {
            populateList(getTaxData(), taxRecyclerView);
        }
        addTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManTaxActivity.this, AddTaxActivity.class);
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

    ArrayList<AddTaxData> getTaxData() {
        ArrayList<AddTaxData> taxDataList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("taxSet", "");
        Type type = new TypeToken<ArrayList<AddTaxData>>() {
        }.getType();
        taxDataList = gson.fromJson(json, type);
//        Log.e(TAG, "getGymData: " + gymDataList.size());
        return taxDataList;
    }

    public void populateList(ArrayList<AddTaxData> list, RecyclerView recyclerView) {
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        AddTaxAdapter recyclerViewAdapter = new
                AddTaxAdapter(list, this);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getTaxData() != null) {
            populateList(getTaxData(), taxRecyclerView);
//        Log.e(TAG, "onResume: "+getGymData().size() );
        }
    }
}