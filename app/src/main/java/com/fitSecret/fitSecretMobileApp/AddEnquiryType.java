package com.fitSecret.fitSecretMobileApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddEnquiryType extends AppCompatActivity {
TextInputEditText enquiryTypeEt;
SharedPreferences sharedPreferences;
ArrayList<String> enquiryTypeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_enquiry_type);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);
        setTitle("Add Enquiry Type");
        enquiryTypeList=new ArrayList<>();
        enquiryTypeEt=(TextInputEditText) findViewById(R.id.add_enquiry_type);
        Button submitBtn=(Button) findViewById(R.id.enquiry_type_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enquiryType=enquiryTypeEt.getText().toString();
                String json = sharedPreferences.getString("enquiryTypeSet", "");
                if (!json.equals("")) {
                    Type type = new TypeToken<ArrayList<String>>() {
                    }.getType();
                    Gson gson = new Gson();
                    enquiryTypeList = gson.fromJson(json, type);
                }
                enquiryTypeList.add(enquiryType);
                String jsone = new Gson().toJson(enquiryTypeList);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("enquiryTypeSet", jsone);
                editor.commit();
                onBackPressed();
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