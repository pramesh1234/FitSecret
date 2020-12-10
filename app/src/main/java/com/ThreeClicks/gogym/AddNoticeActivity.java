package com.ThreeClicks.gogym;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ThreeClicks.gogym.data.AddNoticeData;
import com.ThreeClicks.gogym.data.AddPlanData;
import com.ThreeClicks.gogym.utils.BaseActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddNoticeActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    TextView startDateEt, endDateEt;
    String startDuration, endDuration;
    TextInputEditText noticeName;
    SharedPreferences sharedPreferences;
    String name;
    final Calendar startCalendar = Calendar.getInstance();
    final Calendar endCalendar = Calendar.getInstance();
    String member;
    Button submitBtn;
    private static final String TAG = "AddNoticeActivity";
    ArrayList<AddNoticeData> noticeDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notice);
        noticeDataArrayList=new ArrayList<>();
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        startDateEt = (TextView) findViewById(R.id.startDate);
        endDateEt = (TextView) findViewById(R.id.endDate);
        noticeName=(TextInputEditText) findViewById(R.id.notice_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Add Notice");
        final DatePickerDialog.OnDateSetListener startDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                startCalendar.set(Calendar.YEAR, year);
                startCalendar.set(Calendar.MONTH, month);
                startCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(startCalendar, startDateEt,"start");
            }
        };
        final DatePickerDialog.OnDateSetListener endDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                endCalendar.set(Calendar.YEAR, year);
                endCalendar.set(Calendar.MONTH, month);
                endCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(endCalendar, endDateEt,"end");
            }
        };
        startDateEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddNoticeActivity.this, startDate, startCalendar
                        .get(Calendar.YEAR), startCalendar.get(Calendar.MONTH),
                        startCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        endDateEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddNoticeActivity.this, endDate, endCalendar
                        .get(Calendar.YEAR), endCalendar.get(Calendar.MONTH),
                        endCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.visibleTo);
        spinner.setAdapter(arraySpinnerAdapter(this, R.array.notice_array));
        spinner.setOnItemSelectedListener(this);
        submitBtn=(Button) findViewById(R.id.submit_notice_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String duration=startDuration+" to "+endDuration;
                name=noticeName.getText().toString();
                String json = sharedPreferences.getString("noticeSet", "");
                if (!json.equals("")) {
                    Type type = new TypeToken<ArrayList<AddNoticeData>>() {
                    }.getType();
                    Gson gson = new Gson();
                    noticeDataArrayList = gson.fromJson(json, type);
                    Log.e(TAG, "onClick: " + json.toString());
                }
                noticeDataArrayList.add(new AddNoticeData(name,duration,member));
                String jsone = new Gson().toJson(noticeDataArrayList);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("noticeSet", jsone);
                editor.commit();
                onBackPressed();
            }
        });
    }

    private void updateLabel(Calendar calendar, TextView et, String mode) {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.JAPAN);
        if (mode.equals("start")) {
            startDuration = sdf.format(calendar.getTime());
        } else {
            endDuration = sdf.format(calendar.getTime());
        }
        et.setText(sdf.format(calendar.getTime()));
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        member = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}