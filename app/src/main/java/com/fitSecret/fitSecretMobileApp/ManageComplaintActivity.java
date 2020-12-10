package com.fitSecret.fitSecretMobileApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.fitSecret.fitSecretMobileApp.fragment.DialogComplaintFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ManageComplaintActivity extends AppCompatActivity {
FloatingActionButton addComplaintBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_complaint);
        addComplaintBtn=(FloatingActionButton) findViewById(R.id.addComplaint);
        addComplaintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogComplaintFragment newComplaint = new DialogComplaintFragment();
                newComplaint.show(getSupportFragmentManager(),"show");
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Manage Complain");
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