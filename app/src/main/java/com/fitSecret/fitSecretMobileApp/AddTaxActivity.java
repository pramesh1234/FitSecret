package com.fitSecret.fitSecretMobileApp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fitSecret.fitSecretMobileApp.data.AddTaxData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddTaxActivity extends AppCompatActivity {
    TextInputEditText editTaxName, editTaxPercentage;
    Button submitTax;
    SharedPreferences sharedPreferences;
    ArrayList<AddTaxData> taxDataArrayList;
    TextInputLayout nameInputLayout,percentageInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tax);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        taxDataArrayList = new ArrayList<>();
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        setTitle("Add Tax");
        editTaxName = (TextInputEditText) findViewById(R.id.edit_tax_name);
        editTaxPercentage = (TextInputEditText) findViewById(R.id.edit_tax_percentage);
        nameInputLayout=(TextInputLayout) findViewById(R.id.taxName);
        percentageInputLayout=(TextInputLayout) findViewById(R.id.taxPercentage);
        submitTax = (Button) findViewById(R.id.submit_tax);
        submitTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taxName = editTaxName.getText().toString();
                String taxPercentage = editTaxPercentage.getText().toString();
                if(taxName.equals("")){
                    nameInputLayout.setError("tax name is empty");
                }else if(taxPercentage.equals("")){
                    percentageInputLayout.setError("tax percentage is empty");
                }else {
                    String json = sharedPreferences.getString("taxSet", "");
                    if (!json.equals("")) {
                        Type type = new TypeToken<ArrayList<AddTaxData>>() {
                        }.getType();
                        Gson gson = new Gson();
                        taxDataArrayList = gson.fromJson(json, type);
                    }
                    taxDataArrayList.add(new AddTaxData(taxName, taxPercentage));
                    String jsone = new Gson().toJson(taxDataArrayList);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("taxSet", jsone);
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
}