package com.fitSecret.fitSecretMobileApp;

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

import com.fitSecret.fitSecretMobileApp.adapter.AddNoticeAdapter;
import com.fitSecret.fitSecretMobileApp.data.AddNoticeData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManageNoticeActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView addNotice;
    SharedPreferences sharedPreferences;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_notice);
        toolbar = (Toolbar) findViewById(R.id.manageNoticeToolbar);
        setSupportActionBar(toolbar);
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.notice_recyclerview);
        addNotice = (ImageView) findViewById(R.id.addNotice);
        if (getNoticeData() != null) {
            populateList(getNoticeData(), recyclerView);
//        Log.e(TAG, "onResume: "+getGymData().size() );
        }
        addNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageNoticeActivity.this, AddNoticeActivity.class);
                startActivity(i);
            }
        });
    }

    ArrayList<AddNoticeData> getNoticeData() {
        ArrayList<AddNoticeData> addNoticeDataArrayList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("noticeSet", "");
        Type type = new TypeToken<ArrayList<AddNoticeData>>() {
        }.getType();
        addNoticeDataArrayList = gson.fromJson(json, type);
        return addNoticeDataArrayList;
    }

    public void populateList(ArrayList<AddNoticeData> list, RecyclerView recyclerView) {
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        AddNoticeAdapter recyclerViewAdapter = new
                AddNoticeAdapter(this, list);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getNoticeData() != null) {
            populateList(getNoticeData(), recyclerView);
//        Log.e(TAG, "onResume: "+getGymData().size() );
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
}