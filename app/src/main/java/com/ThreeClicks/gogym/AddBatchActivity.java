package com.ThreeClicks.gogym;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.ThreeClicks.gogym.data.AddBatchData;
import com.ThreeClicks.gogym.data.AddTaxData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddBatchActivity extends AppCompatActivity {
    TimePicker openTimePicker;
    TimePicker closeTimePicker;
    TextInputEditText batchNameEt;
    TextInputEditText batchLimitEt;
    TextInputLayout batchNameLayout;
    TextInputLayout batchLimitLayout;
    SharedPreferences sharedPreferences;
    private String format = "";
    ArrayList<AddBatchData> batchDataArrayList;
    private static final String TAG = "AddBatchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_batch);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Add Batch");
        batchDataArrayList = new ArrayList<>();
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        closeTimePicker = (TimePicker) findViewById(R.id.close_time_picker);
        openTimePicker = (TimePicker) findViewById(R.id.open_time_picker);
        batchNameEt = (TextInputEditText) findViewById(R.id.batch_name_et);
        batchLimitEt = (TextInputEditText) findViewById(R.id.batch_limit_et);
        batchNameLayout = (TextInputLayout) findViewById(R.id.batchName);
        batchLimitLayout = (TextInputLayout) findViewById(R.id.batchLimit);
        Button submitBtn = (Button) findViewById(R.id.submit_batch_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int openTimeHour = openTimePicker.getHour();
                int openTimeMinute = openTimePicker.getMinute();
                int closeTimeHour = closeTimePicker.getHour();
                int closeTimeMinute = closeTimePicker.getMinute();
                String batchName = batchNameEt.getText().toString();
                String batchLimit = batchLimitEt.getText().toString();
                if (batchName.equals("")) {
                    batchNameLayout.setError("batch name is empty");
                } else if (batchLimit.equals("")) {
                    batchLimitLayout.setError("batch limit is empty");
                } else {
                    String json = sharedPreferences.getString("batchSet", "");
                    if (!json.equals("")) {
                        Type type = new TypeToken<ArrayList<AddTaxData>>() {
                        }.getType();
                        Gson gson = new Gson();
                        batchDataArrayList = gson.fromJson(json, type);
                    }
                    batchDataArrayList.add(new AddBatchData(batchName,batchLimit,showTime(openTimeHour,openTimeMinute)+" to "+showTime(closeTimeHour,closeTimeMinute)));
                    String jsone = new Gson().toJson(batchDataArrayList);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("batchSet", jsone);
                    editor.commit();
                    onBackPressed();
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

    public String showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        return new StringBuilder().append(hour).append(" : ").append(min)
                .append(" ").append(format).toString();
    }
}