package com.ThreeClicks.gogym;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ThreeClicks.gogym.data.AddSmsTemplateData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddSmsTemplateActivity extends AppCompatActivity {
    TextInputEditText templateNameEt, templateContentEt;
    Button submitBtn;
    SharedPreferences sharedPreferences;
    ArrayList<AddSmsTemplateData> smsTemplateDataArrayList;
    private static final String TAG = "AddSmsTemplateActivity";
    TextInputLayout nameLayout, contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sms_template);
        smsTemplateDataArrayList = new ArrayList<>();
        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        templateNameEt = (TextInputEditText) findViewById(R.id.template_name);
        templateContentEt = (TextInputEditText) findViewById(R.id.template_content);
        submitBtn = (Button) findViewById(R.id.template_submit_btn);
        nameLayout = (TextInputLayout) findViewById(R.id.template_name_layout);
        contentLayout = (TextInputLayout) findViewById(R.id.template_content_layout);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = templateNameEt.getText().toString();
                String content = templateContentEt.getText().toString();
                if(name.equals("")) {
                  nameLayout.setError("Sms name is empty");
                } else if (content.equals("")) {
                       contentLayout.setError("Sms content is empty");
                } else {
                    String json = sharedPreferences.getString("smsSet", "");
                    if (!json.equals("")) {
                        Type type = new TypeToken<ArrayList<AddSmsTemplateData>>() {
                        }.getType();
                        Gson gson = new Gson();
                        smsTemplateDataArrayList = gson.fromJson(json, type);
                        Log.e(TAG, "onClick: " + json.toString());
                    }
                    smsTemplateDataArrayList.add(new AddSmsTemplateData(name, content));
                    String jsone = new Gson().toJson(smsTemplateDataArrayList);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("smsSet", jsone);
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