package com.ThreeClicks.gogym;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddGymActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner currencySpinner,countrySpinner;
    String[] country = { "India", "USA", "China", "Japan", "Other"};
    String[] currency = { "Rupee", "Dollar", "yuan", "Yen", "Other"};
    String countryText,currencyText;
    Button submitBtn;
    TextInputEditText organizationNameEt,displayNameEt,addressLine1Et,addressLine2Et,cityEt,stateEt,emailEt,phoneEt,websiteEt,ownerContactEt,gstNoEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gym);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Add Gym");
        currencySpinner=(Spinner) findViewById(R.id.currencySpinner);
        countrySpinner=(Spinner) findViewById(R.id.countrySpinner);
        organizationNameEt=(TextInputEditText) findViewById(R.id.organizationNameEt);
        displayNameEt=(TextInputEditText) findViewById(R.id.displayNameEt);
        addressLine1Et=(TextInputEditText) findViewById(R.id.addressLine1Et);
        addressLine2Et=(TextInputEditText) findViewById(R.id.addressLine2Et);
        cityEt=(TextInputEditText) findViewById(R.id.cityEt);
        stateEt=(TextInputEditText) findViewById(R.id.stateEt);
        emailEt=(TextInputEditText) findViewById(R.id.emailEt);
        phoneEt=(TextInputEditText) findViewById(R.id.phoneEt);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(displayNameEt.getText().equals("")){
                    displayNameEt.setError("display name is empty");
                }else
                if(organizationNameEt.getText().equals("")){
                    organizationNameEt.setError("organization name is empty");
                }else if(addressLine1Et.getText().equals("")){
                    addressLine1Et.setError("address line 1 is empty");
                }else if(addressLine2Et.getText().equals("")){
                    addressLine2Et.setError("adress line 2 is empty");
                }else
                if(cityEt.getText().equals("")){
                    cityEt.setError("city is empty");
                }else
                if(stateEt.getText().equals("")){
                    displayNameEt.setError("state is empty");
                }else
                if(emailEt.getText().equals("")){
                    displayNameEt.setError("email is empty");
                }else
                if(phoneEt.getText().equals("")){
                    displayNameEt.setError("phone is empty");
                }
        }});

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
        Spinner currencySpinner = (Spinner)parent;
        Spinner countrySpinner = (Spinner)parent;
        if(currencySpinner.getId() == R.id.currencySpinner)
        {
            currencyText=currency[position];
            Toast.makeText(this, "Your choose :" + currency[position],Toast.LENGTH_SHORT).show();
        }
        if(countrySpinner.getId() == R.id.countrySpinner)
        {
            countryText=country[position];
            Toast.makeText(this, "Your choose :" + country[position],Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}