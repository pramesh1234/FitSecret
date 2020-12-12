package com.fitSecret.fitSecretMobileApp.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fitSecret.fitSecretMobileApp.AddNoticeActivity;
import com.fitSecret.fitSecretMobileApp.R;

import java.util.Calendar;
import java.util.Locale;

public class DialogManualExpenseFragment extends DialogFragment {
    TextView selectDate,fromDate,toDate;
    LinearLayout dateRange;
    String toDuration,fromDuration,selectDuration;
    final Calendar fromCalendar = Calendar.getInstance();
    final Calendar toCalendar = Calendar.getInstance();
    final Calendar selectCalendar=Calendar.getInstance();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_dialog_manual_expense, container, false);
        dateRange=(LinearLayout) rootView.findViewById(R.id.date_range);
        selectDate=(TextView) rootView.findViewById(R.id.select_date);
        RadioGroup radioGroupExpense=(RadioGroup) rootView.findViewById(R.id.expense_radio_group);
        radioGroupExpense.clearCheck();
        radioGroupExpense.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    Toast.makeText(getActivity(), rb.getText(), Toast.LENGTH_SHORT).show();
                    if(rb.getText().toString().equals("Date Range")){
                        selectDate.setVisibility(View.GONE);
                        dateRange.setVisibility(View.VISIBLE);
                    }else{
                        dateRange.setVisibility(View.GONE);
                        selectDate.setVisibility(View.VISIBLE);
                    }
            }}});
        toDate=(TextView) rootView.findViewById(R.id.toDate);
        fromDate=(TextView) rootView.findViewById(R.id.fromDate);

        final DatePickerDialog.OnDateSetListener toDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                toCalendar.set(Calendar.YEAR, year);
                toCalendar.set(Calendar.MONTH, month);
                toCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(toCalendar, toDate,"to");
            }
        };
        final DatePickerDialog.OnDateSetListener fromDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fromCalendar.set(Calendar.YEAR, year);
                fromCalendar.set(Calendar.MONTH, month);
                fromCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(fromCalendar, fromDate,"from");
            }
        };
        final DatePickerDialog.OnDateSetListener selectDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                selectCalendar.set(Calendar.YEAR, year);
                selectCalendar.set(Calendar.MONTH, month);
                selectCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(selectCalendar, selectDate,"select");
            }
        };
        toDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), toDateListener, toCalendar
                        .get(Calendar.YEAR), toCalendar.get(Calendar.MONTH),
                        toCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        fromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), fromDateListener, fromCalendar
                        .get(Calendar.YEAR), fromCalendar.get(Calendar.MONTH),
                        fromCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), selectDateListener, selectCalendar
                        .get(Calendar.YEAR), selectCalendar.get(Calendar.MONTH),
                        selectCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        return rootView;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return dialog;
    }
    private void updateLabel(Calendar calendar, TextView et, String mode) {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.JAPAN);
        et.setText(sdf.format(calendar.getTime()));
    }
}