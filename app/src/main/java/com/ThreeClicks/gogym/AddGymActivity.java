package com.ThreeClicks.gogym;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.ThreeClicks.gogym.data.AddGymData;
import com.ThreeClicks.gogym.utils.BaseActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddGymActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "AddGymActivity";
    Spinner currencySpinner, countrySpinner;
    String countryText, currencyText;
    Button submitBtn;
    ArrayList<AddGymData> gymDataList;
    SharedPreferences sharedPreferences;
    TextInputEditText organizationNameEt, displayNameEt, addressLine1Et, addressLine2Et, cityEt, stateEt, emailEt, phoneEt, websiteEt, ownerContactEt, gstNoEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gym);
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Add Gym");
        gymDataList = new ArrayList<>();
        currencySpinner = (Spinner) findViewById(R.id.currencySpinner);
        countrySpinner = (Spinner) findViewById(R.id.countrySpinner);
        currencySpinner.setAdapter(arraySpinnerAdapter(this,R.array.array_currency_codes));
        countrySpinner.setAdapter(arraySpinnerAdapter(this,R.array.countries_array));
        organizationNameEt = (TextInputEditText) findViewById(R.id.organizationNameEt);
        displayNameEt = (TextInputEditText) findViewById(R.id.displayNameEt);
        addressLine1Et = (TextInputEditText) findViewById(R.id.addressLine1Et);
        addressLine2Et = (TextInputEditText) findViewById(R.id.addressLine2Et);
        cityEt = (TextInputEditText) findViewById(R.id.cityEt);
        stateEt = (TextInputEditText) findViewById(R.id.stateEt);
        emailEt = (TextInputEditText) findViewById(R.id.emailEt);
        phoneEt = (TextInputEditText) findViewById(R.id.phoneEt);
        submitBtn = (Button) findViewById(R.id.addGymSubmitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (displayNameEt.getText().equals("")) {
                    displayNameEt.setError("display name is empty");
                } else if (organizationNameEt.getText().equals("")) {
                    organizationNameEt.setError("organization name is empty");
                } else if (addressLine1Et.getText().equals("")) {
                    addressLine1Et.setError("address line 1 is empty");
                } else if (addressLine2Et.getText().equals("")) {
                    addressLine2Et.setError("adress line 2 is empty");
                } else if (cityEt.getText().equals("")) {
                    cityEt.setError("city is empty");
                } else if (stateEt.getText().equals("")) {
                    displayNameEt.setError("state is empty");
                } else if (emailEt.getText().equals("")) {
                    displayNameEt.setError("email is empty");
                } else if (phoneEt.getText().equals("")) {
                    displayNameEt.setError("phone is empty");
                } else {
                    String gymName = displayNameEt.getText().toString();
                    String addressLine1 = addressLine1Et.getText().toString();
                    String addressLine2 = addressLine2Et.getText().toString();
                    String city = cityEt.getText().toString();
                    String state = stateEt.getText().toString();
                    String json = sharedPreferences.getString("Set", "");
                    if(!json.equals("")){
                        Log.e(TAG, "onClick: joks"+json);
                        Type type = new TypeToken<ArrayList<AddGymData>>() {
                        }.getType();
                        Gson gson=new Gson();
                        gymDataList = gson.fromJson(json, type);
                    }
                    gymDataList.add(new AddGymData(gymName, addressLine1, addressLine2, city, state));

                }

                String json = new Gson().toJson(gymDataList);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Set", json);
                editor.commit();
                String jsone = sharedPreferences.getString("Set", "");
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner currencySpinner = (Spinner) parent;
        Spinner countrySpinner = (Spinner) parent;
        if (currencySpinner.getId() == R.id.currencySpinner) {
            currencyText = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, "Your choose :" + currencyText, Toast.LENGTH_SHORT).show();
        }
        if (countrySpinner.getId() == R.id.countrySpinner) {
            countryText =  parent.getItemAtPosition(position).toString();

            Toast.makeText(this, "Your choose :" + countryText, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}