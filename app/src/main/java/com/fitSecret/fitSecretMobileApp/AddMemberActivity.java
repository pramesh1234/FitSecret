package com.fitSecret.fitSecretMobileApp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.fitSecret.fitSecretMobileApp.data.AddPlanData;
import com.fitSecret.fitSecretMobileApp.data.AddTaxData;
import com.fitSecret.fitSecretMobileApp.utils.BaseActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddMemberActivity extends BaseActivity {
    LinearLayout planDetailLayout, otherDetailLayout;
    RelativeLayout planDetail, otherDetail;
    SharedPreferences sharedPreferences;
    ArrayList<String> planNameArray,taxNameArray;
    boolean planDetailClicked, otherDetailClicked;
    ImageView downArrow, leftArrow, otherDownArrow, otherLeftArrow;
    private static final String TAG = "AddMemberActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        planNameArray=new ArrayList<>();
        taxNameArray=new ArrayList<>();
        sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Add Member");
        planDetailClicked = false;
        planDetail = (RelativeLayout) findViewById(R.id.plan_details);
        planDetailLayout = (LinearLayout) findViewById(R.id.plan_details_content);
        downArrow = (ImageView) findViewById(R.id.detail_down_arrow);
        leftArrow = (ImageView) findViewById(R.id.detail_left_arrow);
        otherDetailClicked = false;
        otherDetail = (RelativeLayout) findViewById(R.id.other_details);
        otherDetailLayout = (LinearLayout) findViewById(R.id.other_detail_layout);
        otherDownArrow = (ImageView) findViewById(R.id.other_down_arrow);
        otherLeftArrow = (ImageView) findViewById(R.id.other_left_arrow);
        planDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (planDetailClicked) {
                    planDetailClicked = false;
                    planDetailLayout.setVisibility(View.GONE);
                    leftArrow.setVisibility(View.VISIBLE);
                    downArrow.setVisibility(View.INVISIBLE);
                } else {
                    planDetailClicked = true;
                    planDetailLayout.setVisibility(View.VISIBLE);
                    leftArrow.setVisibility(View.INVISIBLE);
                    downArrow.setVisibility(View.VISIBLE);
                }
            }
        });
        otherDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otherDetailClicked) {
                    otherDetailClicked = false;
                    otherDetailLayout.setVisibility(View.GONE);
                    otherLeftArrow.setVisibility(View.VISIBLE);
                    otherDownArrow.setVisibility(View.INVISIBLE);
                } else {
                    otherDetailClicked = true;
                    otherDetailLayout.setVisibility(View.VISIBLE);
                    otherLeftArrow.setVisibility(View.INVISIBLE);
                    otherDownArrow.setVisibility(View.VISIBLE);
                }
            }
        });
        ArrayList<AddPlanData> addPlanDataList = new ArrayList<>();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("planSet", "");
        Type type = new TypeToken<ArrayList<AddPlanData>>() {
        }.getType();
        addPlanDataList = gson.fromJson(json, type);
        planNameArray.add("select plan");
        try {
            for (int i = 0; i < addPlanDataList.size(); i++) {
                planNameArray.add(addPlanDataList.get(i).getPlanName());
            }
        }catch (NullPointerException e){
            Log.e(TAG, "onCreate: "+e.toString() );
        }
        Log.e(TAG, "onCreate: "+planNameArray.size() );
        Spinner planSpinner=(Spinner) findViewById(R.id.plan_spinner);
        planSpinner.setAdapter(spinnerAdapter(this,planNameArray));
        Spinner discountSpinner=(Spinner) findViewById(R.id.discount_spinner);
        discountSpinner.setAdapter(arraySpinnerAdapter(this,R.array.discount_type_array));
        Spinner paymentSpinner=(Spinner) findViewById(R.id.payment_spinner);
        paymentSpinner.setAdapter(arraySpinnerAdapter(this,R.array.payment_type_array));

        ArrayList<AddTaxData> taxDataList = new ArrayList<>();
        Gson gson1 = new Gson();
        String json1 = sharedPreferences.getString("taxSet", "");
        Type type1 = new TypeToken<ArrayList<AddTaxData>>() {
        }.getType();
        taxDataList = gson1.fromJson(json1, type1);
        try {
            for (int i = 0; i < taxDataList.size(); i++) {
                taxNameArray.add(taxDataList.get(i).getTaxName());
                Log.e(TAG, "onCreate: tax "+taxNameArray.size() );
            }
        }catch (NullPointerException e){
            Log.e(TAG, "onCreate: "+e.toString() );
        }
        ListView taxListView=(ListView) findViewById(R.id.tax_recyclerview);
        taxListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice,taxNameArray);
        taxListView.setAdapter(arrayAdapter);
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