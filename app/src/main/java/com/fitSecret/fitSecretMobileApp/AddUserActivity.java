package com.fitSecret.fitSecretMobileApp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.fitSecret.fitSecretMobileApp.data.AddUserData;
import com.fitSecret.fitSecretMobileApp.utils.BaseActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddUserActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    Spinner userType;
    SharedPreferences sharedPreferences;
    String type="";
    private static final String TAG = "AddUserActivity";
    TextInputLayout userNameLayout,userEmailLayout,userMobileLayout,userPasswordLayout,userConfirmPassword;
    TextInputEditText userNameEt, userMobileEt, userEmailEt, userPasswordEt, userConfirmPasswordEt;
    boolean homeCb = false, sliderCb = false, enrollmentCb = false, userCb = false, planCb = false, taxCb = false, memberCb = false, smsCb = false, invoiceCb = false, exportCb = false, noticeCb = false, trainerCb = false, enquiryCb = false, dietCb = false, measurementCb = false, exerciseCb = false;
    ArrayList<AddUserData> userDataArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        userDataArrayList=new ArrayList<>();
        userType = (Spinner) findViewById(R.id.user_type_spinner);
        userType.setAdapter(arraySpinnerAdapter(this, R.array.user_type_array));
        userType.setOnItemSelectedListener(this);
        setTitle("Add User");
        userNameLayout=(TextInputLayout) findViewById(R.id.user_name_layout);
        userMobileLayout=(TextInputLayout) findViewById(R.id.user_mobile_layout);
        userEmailLayout=(TextInputLayout) findViewById(R.id.user_email_layout);
        userPasswordLayout=(TextInputLayout) findViewById(R.id.user_email_layout);
        userConfirmPassword=(TextInputLayout) findViewById(R.id.confirm_password_layout);
        userNameEt = (TextInputEditText) findViewById(R.id.user_name_et);
        userMobileEt = (TextInputEditText) findViewById(R.id.mobile_no_et);
        userEmailEt = (TextInputEditText) findViewById(R.id.user_email_et);
        userPasswordEt = (TextInputEditText) findViewById(R.id.user_password_et);
        userConfirmPasswordEt = (TextInputEditText) findViewById(R.id.user_confirm_password_et);
        Button submitBtn = (Button) findViewById(R.id.submit_user_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = userPasswordEt.getText().toString();
                String confirmPassword = userConfirmPasswordEt.getText().toString();
                String userName = userNameEt.getText().toString();
                String userMobile = userMobileEt.getText().toString();
                String userEmail = userEmailEt.getText().toString();

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(AddUserActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                } else if(userName.equals("")) {
                    userNameLayout.setError("user name is empty");
                }else if(userMobile.equals("")) {
                    userMobileLayout.setError("user mobile is empty");
                }else if(userEmail.equals("")) {
                    userEmailLayout.setError("user email is empty");
                }else if(password.equals("")) {
                    userPasswordLayout.setError("password is empty");
                }else if(confirmPassword.equals("")) {
                    userConfirmPassword.setError("confirm password is empty");
                }else{
                    String json = sharedPreferences.getString("userSet", "");
                    if (!json.equals("")) {
                        Type type = new TypeToken<ArrayList<AddUserData>>() {
                        }.getType();
                        Gson gson = new Gson();
                        userDataArrayList = gson.fromJson(json, type);
                    }
                    userDataArrayList.add(new AddUserData(type,userName,userMobile,userEmail,homeCb,enrollmentCb,userCb,planCb,taxCb,invoiceCb,trainerCb,memberCb,enquiryCb,smsCb,dietCb,measurementCb,sliderCb,exportCb,noticeCb,exerciseCb));
                    String jsone = new Gson().toJson(userDataArrayList);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userSet", jsone);
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

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.home_cb:
                if (checked)
                    homeCb = true;
                else
                    homeCb = false;
                break;
            case R.id.slider_cb:
                if (checked)
                    sliderCb = true;
                else
                    sliderCb = false;
                break;
            case R.id.user_cb:
                if (checked) {
                    userCb = true;
                    Log.e(TAG, "onCheckboxClicked: " + userCb);
                }
                else
                    userCb = false;
                break;
            case R.id.plan_cb:
                if (checked)
                    planCb = true;
                else
                    planCb = false;
                break;
            case R.id.tax_cb:
                if (checked)
                    taxCb = true;
                else
                    taxCb = false;
                break;
            case R.id.member_cb:
                if (checked)
                    memberCb = true;
                else
                    memberCb = false;
                break;
            case R.id.sms_cb:
                if (checked)
                    smsCb = true;
                else
                    smsCb = false;
                break;
            case R.id.invoice_cb:
                if (checked)
                    invoiceCb = true;
                else
                    invoiceCb = false;
                break;
            case R.id.export_cb:
                if (checked)
                    exportCb = true;
                else
                    exportCb = false;
                break;
            case R.id.notice_cb:
                if (checked)
                    noticeCb = true;
                else
                    noticeCb = false;
                break;
            case R.id.trainer_cb:
                if (checked)
                    trainerCb = true;
                else
                    trainerCb = false;
                break;
            case R.id.enquiry_cb:
                if (checked)
                    enquiryCb = true;
                else
                    enquiryCb = false;
                break;
            case R.id.diet_cb:
                if (checked)
                    dietCb = true;
                else
                    dietCb = false;
                break;
            case R.id.measurement_cb:
                if (checked)
                    measurementCb = true;
                else
                    measurementCb = false;
                break;
            case R.id.exercise_cb:
                if (checked)
                    exerciseCb = true;
                else
                    exerciseCb = false;
                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        type=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}