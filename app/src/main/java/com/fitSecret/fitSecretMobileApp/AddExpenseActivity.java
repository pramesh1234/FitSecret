package com.fitSecret.fitSecretMobileApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.fitSecret.fitSecretMobileApp.adapter.AddExpenseAdapter;

import java.util.ArrayList;

public class AddExpenseActivity extends AppCompatActivity {
RecyclerView recyclerView;
AddExpenseAdapter addExpenseAdapter;
ArrayList<String> expensePosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        expensePosition=new ArrayList<>();
        expensePosition.add("1");
        setTitle("Add Expense");
        recyclerView=(RecyclerView) findViewById(R.id.add_expense_recyclerview);

        addExpenseAdapter=new AddExpenseAdapter(expensePosition,this);
        recyclerView.setAdapter(addExpenseAdapter);


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