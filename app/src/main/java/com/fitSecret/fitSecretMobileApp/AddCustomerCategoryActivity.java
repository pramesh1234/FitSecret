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

public class AddCustomerCategoryActivity extends AppCompatActivity {
TextInputEditText categoryEt;
ArrayList<String> categoryArraylist;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer_category);
        setTitle("Add Customer Category");
        categoryArraylist=new ArrayList<>();
        categoryEt=(TextInputEditText) findViewById(R.id.edit_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button submitButton=(Button) findViewById(R.id.category_btn);
        sharedPreferences=getSharedPreferences("USER",MODE_PRIVATE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category=categoryEt.getText().toString();
                String json = sharedPreferences.getString("categorySet", "");
                if (!json.equals("")) {
                    Type type = new TypeToken<ArrayList<String>>() {
                    }.getType();
                    Gson gson = new Gson();
                    categoryArraylist = gson.fromJson(json, type);
                }
                categoryArraylist.add(category);
                String jsone = new Gson().toJson(categoryArraylist);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("categorySet", jsone);
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