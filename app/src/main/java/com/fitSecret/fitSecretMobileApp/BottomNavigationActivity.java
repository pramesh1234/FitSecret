package com.fitSecret.fitSecretMobileApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
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
        navigationView.getMenu().getItem(0).setActionView(R.layout.menu_image);
        navigationView.setItemIconTintList(null);
        navController = Navigation.findNavController(this, R.id.nav_bottom_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(new int[]{R.id.nav_home, R.id.nav_shop, R.id.nav_workout, R.id.nav_nutrition}).setOpenableLayout(drawer)
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);

        View headerView = navigationView.getHeaderView(0);
        LinearLayout userDetail = (LinearLayout) headerView.findViewById(R.id.userDetailLinearLayout);
        userDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BottomNavigationActivity.this, MyProfileActivity.class);
                startActivity(i);
            }
        });
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
                Intent iBatch = new Intent(BottomNavigationActivity.this, ManageBatchActivity.class);
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
            case R.id.nav_user:
                Intent iUser = new Intent(BottomNavigationActivity.this, ManageUserActivity.class);
                startActivity(iUser);
                break;
            case R.id.nav_trainer:
                Intent iTrainer = new Intent(BottomNavigationActivity.this, ManageTrainerActivity.class);
                startActivity(iTrainer);
                break;
            case R.id.nav_add_member:
                Intent iAddMember = new Intent(BottomNavigationActivity.this, AddMemberActivity.class);
                startActivity(iAddMember);
                break;
            case R.id.nav_mark_attendance:
                Intent iMarkAttendance = new Intent(BottomNavigationActivity.this, MarkAttendenceActivity.class);
                startActivity(iMarkAttendance);
                break;
            case R.id.nav_attendance_report:
                Intent iAttendanceReport = new Intent(BottomNavigationActivity.this, AttendanceReportActivity.class);
                startActivity(iAttendanceReport);
                break;
            case R.id.nav_customer_category:
                Intent iCustomerCategory = new Intent(BottomNavigationActivity.this, CustomerCategoryActivity.class);
                startActivity(iCustomerCategory);
                break;
            case R.id.nav_enquiry_type:
                Intent iEnquiryType = new Intent(BottomNavigationActivity.this, ManageEnquiryTypeActivity.class);
                startActivity(iEnquiryType);
                break;
            case R.id.nav_enquiry:
                Intent iEnquiry = new Intent(BottomNavigationActivity.this, ManageEnquiryActivity.class);
                startActivity(iEnquiry);
                break;
            case R.id.nav_measurement:
                Intent iMeasurement = new Intent(BottomNavigationActivity.this, ManageMeasurementActivity.class);
                startActivity(iMeasurement);
                break;
            case R.id.nav_manage_expense:
                Intent iExpense = new Intent(BottomNavigationActivity.this, ManageExpensesActivity.class);
                startActivity(iExpense);
                break;
            case R.id.nav_sms_template:
                Intent iSmsTemplate = new Intent(BottomNavigationActivity.this, SmsTemplateActivity.class);
                startActivity(iSmsTemplate);
                break;
            case R.id.nav_manage_diet:
                Intent iManageDiet = new Intent(BottomNavigationActivity.this, ManageDietingActivity.class);
                startActivity(iManageDiet);
                break;
            case R.id.nav_sms_history:
                Intent iSmsHistory = new Intent(BottomNavigationActivity.this, SmsHistoryActivity.class);
                startActivity(iSmsHistory);
                break;
            case R.id.nav_exercise_category:
                Intent iExerciseCategory = new Intent(BottomNavigationActivity.this, ExerciseCategoryActivity.class);
                startActivity(iExerciseCategory);
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