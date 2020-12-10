package com.ThreeClicks.gogym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.ReceiverCallNotAllowedException;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.ThreeClicks.gogym.adapter.AddBatchAdapter;
import com.ThreeClicks.gogym.adapter.AddUserAdapter;
import com.ThreeClicks.gogym.data.AddBatchData;
import com.ThreeClicks.gogym.data.AddUserData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManageUserActivity extends AppCompatActivity {
ImageView addUser;
SharedPreferences sharedPreferences;
ArrayList<AddUserData> userDataArrayList;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user);
       Toolbar toolbar=(Toolbar) findViewById(R.id.managerUserToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addUser=(ImageView) findViewById(R.id.addUser);
        sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);
        recyclerView=(RecyclerView) findViewById(R.id.user_recyclerview);
        if (getUserData() != null) {
            populateList(getUserData(), recyclerView);
        }
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManageUserActivity.this,AddUserActivity.class);
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
    ArrayList<AddUserData> getUserData() {
        ArrayList<AddUserData> userArrayList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("userSet", "");
        Type type = new TypeToken<ArrayList<AddUserData>>() {
        }.getType();
        userArrayList = gson.fromJson(json, type);
//        Log.e(TAG, "getGymData: " + gymDataList.size());
        return userArrayList;
    }

    public void populateList(ArrayList<AddUserData> list, RecyclerView recyclerView) {
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        AddUserAdapter recyclerViewAdapter = new
                AddUserAdapter(this, list);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getUserData() != null) {
            populateList(getUserData(), recyclerView);
        }
    }
}