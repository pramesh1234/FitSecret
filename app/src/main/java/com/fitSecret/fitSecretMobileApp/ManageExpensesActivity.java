package com.fitSecret.fitSecretMobileApp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
        final ImageView moreOption = (ImageView) findViewById(R.id.more_option_expense);
        moreOption.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              PopupMenu popup = new PopupMenu(ManageExpensesActivity.this, moreOption);
                                              popup.getMenuInflater().inflate(R.menu.popup_menu_expenses, popup.getMenu());

                                              popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                  public boolean onMenuItemClick(MenuItem item) {
                                                     expenseTypeTv.setText(""+ item.getTitle());
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