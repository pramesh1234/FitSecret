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

import com.fitSecret.fitSecretMobileApp.adapter.AddSmsTemplateAdapter;
import com.fitSecret.fitSecretMobileApp.data.AddSmsTemplateData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SmsTemplateActivity extends AppCompatActivity {
Toolbar toolbar;
SharedPreferences sharedPreferences;
ImageView addSmsTemplate;
RecyclerView templateRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_template);
        toolbar=(Toolbar) findViewById(R.id.smsTemplateToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);
        addSmsTemplate=(ImageView) findViewById(R.id.addTemplate);
        templateRecyclerview=(RecyclerView) findViewById(R.id.template_recyclerview);
        if (getTemplateData() != null) {
            populateList(getTemplateData(), templateRecyclerview);
        }
        addSmsTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SmsTemplateActivity.this,AddSmsTemplateActivity.class);
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
    ArrayList<AddSmsTemplateData> getTemplateData() {
        ArrayList<AddSmsTemplateData> templateDataArrayList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("smsSet", "");
        Type type = new TypeToken<ArrayList<AddSmsTemplateData>>() {
        }.getType();
        templateDataArrayList = gson.fromJson(json, type);
//        Log.e(TAG, "getGymData: " + gymDataList.size());
        return templateDataArrayList;
    }

    public void populateList(ArrayList<AddSmsTemplateData> list, RecyclerView recyclerView) {
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        AddSmsTemplateAdapter recyclerViewAdapter = new
                AddSmsTemplateAdapter(this, list);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getTemplateData() != null) {
            populateList(getTemplateData(), templateRecyclerview);
        }
    }
}