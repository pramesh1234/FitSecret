package com.fitSecret.fitSecretMobileApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fitSecret.fitSecretMobileApp.fragment.DialogComplaintFragment;
import com.fitSecret.fitSecretMobileApp.fragment.DialogManualExpenseFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ManageExpensesActivity extends AppCompatActivity {
TextView expenseTypeTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_expenses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.manage_expense_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        expenseTypeTv=(TextView) findViewById(R.id.expense_type);
        FloatingActionButton addExpenseBtn=(FloatingActionButton) findViewById(R.id.add_expense_btn);
        addExpenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ManageExpensesActivity.this,AddExpenseActivity.class);
                startActivity(i);
            }
        });
        final ImageView moreOption = (ImageView) findViewById(R.id.more_option_expense);
        moreOption.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              PopupMenu popup = new PopupMenu(ManageExpensesActivity.this, moreOption);
                                              popup.getMenuInflater().inflate(R.menu.popup_menu_expenses, popup.getMenu());

                                              popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                  public boolean onMenuItemClick(MenuItem item) {
                                                      if(item.getTitle().toString().equals("Manually")){
                                                          DialogManualExpenseFragment manualSelect = new DialogManualExpenseFragment();
                                                          manualSelect.show(getSupportFragmentManager(),"show");
                                                      }else {
                                                          expenseTypeTv.setText("" + item.getTitle());
                                                      }
                                                      return true;
                                                  }
                                              });
                                              popup.show();
                                          }
                                      }
        );
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