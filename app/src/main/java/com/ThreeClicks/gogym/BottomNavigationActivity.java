package com.ThreeClicks.gogym;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class BottomNavigationActivity extends AppCompatActivity {

    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView navView;
    NavController navController;
    static TextView titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        navView = findViewById(R.id.bottom_nav_view);
        toolbar = findViewById(R.id.toolba);
        titleBar = (TextView) findViewById(R.id.toolbarTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navController = Navigation.findNavController(this, R.id.nav_bottom_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(new int[]{R.id.nav_home, R.id.nav_shop, R.id.nav_workout, R.id.nav_nutrition}).setOpenableLayout(drawer)
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);


        drawerToggle = setupDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        setupDrawerContent(navigationView);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_name:
                Intent i = new Intent(BottomNavigationActivity.this, ManageGymActivity.class);
                startActivity(i);
                break;
            case R.id.nav_complaint:
                Intent iComplaint = new Intent(BottomNavigationActivity.this, ManageComplaintActivity.class);
                startActivity(iComplaint);
                break;
            case R.id.nav_need_help:
                Intent iHelp = new Intent(BottomNavigationActivity.this, HelpActivity.class);
                startActivity(iHelp);
                break;
            case R.id.nav_refer:
                Intent iRefer = new Intent(BottomNavigationActivity.this, ReferNEarnActivity.class);
                startActivity(iRefer);
                break;
            case R.id.nav_enrollment:
                Intent iEnrollment = new Intent(BottomNavigationActivity.this, EnrollmentFeeActivity.class);
                startActivity(iEnrollment);
                break;
            case R.id.nav_plan:
                Intent iPlan = new Intent(BottomNavigationActivity.this, ManagePlanActivity.class);
                startActivity(iPlan);
                break;
            case R.id.nav_tax:
                Intent iTax = new Intent(BottomNavigationActivity.this, ManTaxActivity.class);
                startActivity(iTax);
                break;
            case R.id.nav_batch:
                Intent iBatch = new Intent(BottomNavigationActivity.this, ManageUserActivity.class);
                startActivity(iBatch);
                break;
            case R.id.nav_invoice:
                Intent iInvoice = new Intent(BottomNavigationActivity.this, ManageInvoiceActivity.class);
                startActivity(iInvoice);
                break;
            case R.id.nav_notice:
                Intent iNotice = new Intent(BottomNavigationActivity.this, ManageNoticeActivity.class);
                startActivity(iNotice);
                break;
            default:
        }
        drawer.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

    public static void setTitleOfToolbar(String title) {
        titleBar.setText(title);
    }
}