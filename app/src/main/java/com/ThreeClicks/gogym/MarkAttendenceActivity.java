package com.ThreeClicks.gogym;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MarkAttendenceActivity extends AppCompatActivity {
    Button memberBtn, trainerBtn, livebtn, expiredBtn;
    boolean memberBtnClicked = true;
    boolean liveBtnClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendence);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Mark Attendance");
        memberBtn = (Button) findViewById(R.id.member_btn);
        trainerBtn = (Button) findViewById(R.id.trainer_btn);
        livebtn = (Button) findViewById(R.id.live_btn);
        expiredBtn = (Button) findViewById(R.id.expired_btn);
        memberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!memberBtnClicked) {
                    livebtn.setVisibility(View.VISIBLE);
                    expiredBtn.setVisibility(View.VISIBLE);
                    trainerBtn.setBackgroundColor(Color.WHITE);
                    trainerBtn.setTextColor(Color.BLACK);
                    memberBtn.setTextColor(Color.WHITE);
                    memberBtn.setBackgroundColor(Color.parseColor("#3584FB"));
                    memberBtnClicked = true;

                }
            }
        });
        trainerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memberBtnClicked) {
                    livebtn.setVisibility(View.GONE);
                    expiredBtn.setVisibility(View.GONE);
                    memberBtn.setBackgroundColor(Color.WHITE);
                    memberBtn.setTextColor(Color.BLACK);
                    trainerBtn.setTextColor(Color.WHITE);
                    trainerBtn.setBackgroundColor(Color.parseColor("#3584FB"));
                    memberBtnClicked=false;
                }

            }
        });
        livebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(!liveBtnClicked){
                     livebtn.setBackgroundColor(Color.parseColor("#3584FB"));
                     expiredBtn.setBackgroundColor(Color.WHITE);
                     expiredBtn.setTextColor(Color.BLACK);
                     livebtn.setTextColor(Color.WHITE);
                     liveBtnClicked=true;
                 }
            }
        });
        expiredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(liveBtnClicked){
                    expiredBtn.setBackgroundColor(Color.parseColor("#3584FB"));
                    livebtn.setBackgroundColor(Color.WHITE);
                    livebtn.setTextColor(Color.BLACK);
                    expiredBtn.setTextColor(Color.WHITE);
                    liveBtnClicked=false;
                }
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
}