package com.fitSecret.fitSecretMobileApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ManageInvoiceActivity extends AppCompatActivity {
Button deletedMembersBtn,allMembersBtn;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_invoice);
        toolbar=(Toolbar) findViewById(R.id.managaInvoiceToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        deletedMembersBtn=(Button) findViewById(R.id.deletedMemberBtn);
        allMembersBtn=(Button) findViewById(R.id.allMembersBtn);
        deletedMembersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allMembersBtn.setBackgroundTintList(ContextCompat.getColorStateList(ManageInvoiceActivity.this, R.color.colorWhite));
                deletedMembersBtn.setBackgroundTintList(ContextCompat.getColorStateList(ManageInvoiceActivity.this, R.color.colorPrimary));
                allMembersBtn.setTextColor(R.color.colorBlack);
                deletedMembersBtn.setTextColor(R.color.colorWhite);
            }
        });
        allMembersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allMembersBtn.setBackgroundTintList(ContextCompat.getColorStateList(ManageInvoiceActivity.this, R.color.colorPrimary));
                deletedMembersBtn.setBackgroundTintList(ContextCompat.getColorStateList(ManageInvoiceActivity.this, R.color.colorWhite));

                allMembersBtn.setTextColor(R.color.colorWhite);
                deletedMembersBtn.setTextColor(R.color.colorBlack);
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