

package com.ThreeClicks.gogym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.ThreeClicks.gogym.data.AddGymData;

import java.util.ArrayList;

public class ManageGymActivity extends AppCompatActivity {
ImageView addGym;
Toolbar toolbar;
public ArrayList<AddGymData> gymData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_gym);
        addGym=(ImageView) findViewById(R.id.addGym);
        toolbar = findViewById(R.id.managaGymToolbar);
        gymData=new ArrayList<>();
        setSupportActionBar(toolbar);
        addGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManageGymActivity.this,AddGymActivity.class);
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
}