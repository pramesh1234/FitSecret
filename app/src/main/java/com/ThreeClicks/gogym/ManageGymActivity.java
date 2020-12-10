

package com.ThreeClicks.gogym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ThreeClicks.gogym.adapter.AddGymAdapter;
import com.ThreeClicks.gogym.data.AddGymData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManageGymActivity extends AppCompatActivity {
    ImageView addGym;
    Toolbar toolbar;
    public ArrayList<AddGymData> gymData;
    RecyclerView gymRecyclerView;
    SharedPreferences sharedPreferences;
    private static final String TAG = "ManageGymActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_gym);
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        addGym = (ImageView) findViewById(R.id.addGym);
        toolbar = findViewById(R.id.managaGymToolbar);
        gymData = new ArrayList<>();
        gymRecyclerView = (RecyclerView) findViewById(R.id.gymRecyclerView);
        if (getGymData() != null) {
            populateList(getGymData(), gymRecyclerView);

        }

        setSupportActionBar(toolbar);
        addGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageGymActivity.this, AddGymActivity.class);
                startActivity(i);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Manage Gym");
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

    ArrayList<AddGymData> getGymData() {
        ArrayList<AddGymData> gymDataList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Set", "");
        Type type = new TypeToken<ArrayList<AddGymData>>() {
        }.getType();
        gymDataList = gson.fromJson(json, type);
//        Log.e(TAG, "getGymData: " + gymDataList.size());
        return gymDataList;
    }

    public void populateList(ArrayList<AddGymData> list, RecyclerView recyclerView) {
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        AddGymAdapter recyclerViewAdapter = new
                AddGymAdapter(this, list);
        Log.e(TAG, "onCreate: ");
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getGymData() != null) {
            populateList(getGymData(), gymRecyclerView);
//        Log.e(TAG, "onResume: "+getGymData().size() );
        }
    }
}