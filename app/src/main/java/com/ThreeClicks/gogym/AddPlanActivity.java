package com.ThreeClicks.gogym;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.ThreeClicks.gogym.data.AddPlanData;
import com.ThreeClicks.gogym.utils.BaseActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddPlanActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextInputEditText planName, planDuration, planAmount, planDescription;
    Button submitPlan;
    String planTypeText;
    TextInputLayout nameInputlayout, durationInputlayout, amountInputlayout, descriptionInputlayout;
    SharedPreferences sharedPreferences;
    ArrayList<AddPlanData> planDataArrayList;
    private static final String TAG = "AddPlanActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Add Plan");
        planDataArrayList = new ArrayList<>();
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        spinner = (Spinner) findViewById(R.id.planType);
        spinner.setAdapter(arraySpinnerAdapter(this, R.array.plan_type_array));
        spinner.setOnItemSelectedListener(this);
        planName = (TextInputEditText) findViewById(R.id.edit_plan_name);
        planAmount = (TextInputEditText) findViewById(R.id.edit_plan_amount);
        planDuration = (TextInputEditText) findViewById(R.id.edit_plan_Duration);
        planDescription = (TextInputEditText) findViewById(R.id.edit_plan_description);
        submitPlan = (Button) findViewById(R.id.submit_plan);
        nameInputlayout = (TextInputLayout) findViewById(R.id.planName);
        durationInputlayout = (TextInputLayout) findViewById(R.id.duration);

        amountInputlayout = (TextInputLayout) findViewById(R.id.amount);

        descriptionInputlayout = (TextInputLayout) findViewById(R.id.description);


        submitPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = planName.getText().toString();
                String amount = planAmount.getText().toString();
                String duration = planDuration.getText().toString();
                String description = planDescription.getText().toString();
                if (name.equals("")) {
                    nameInputlayout.setError("plan name is empty");
                } else if (amount.equals("")) {
                    amountInputlayout.setError("plan amount is empty");
                } else if (duration.equals("")) {
                    durationInputlayout.setError("plan duration is empty");
                } else if (description.equals("")) {
                    descriptionInputlayout.setError("plan description is empty");
                } else {
                    String json = sharedPreferences.getString("planSet", "");
                    if (!json.equals("")) {
                        Type type = new TypeToken<ArrayList<AddPlanData>>() {
                        }.getType();
                        Gson gson = new Gson();
                        planDataArrayList = gson.fromJson(json, type);
                        Log.e(TAG, "onClick: " + json.toString());
                    }
                    planDataArrayList.add(new AddPlanData(name, planTypeText, amount, duration, description));
                    String jsone = new Gson().toJson(planDataArrayList);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("planSet", jsone);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        planTypeText = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}