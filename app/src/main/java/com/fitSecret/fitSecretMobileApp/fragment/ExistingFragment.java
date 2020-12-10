package com.fitSecret.fitSecretMobileApp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.fitSecret.fitSecretMobileApp.BottomNavigationActivity;
import com.fitSecret.fitSecretMobileApp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ExistingFragment extends Fragment {
    TextInputLayout memberId;
    LinearLayout otherPlatform, view;
    TextView forgetPass;
    TextInputEditText passwordEt, emailPhoneEt;
    TextView loginText;
    ProgressBar progressBar;
    private static final String TAG = "ExistingFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_existing, container, false);
        forgetPass = (TextView) rootView.findViewById(R.id.forgetPassword);
        memberId = (TextInputLayout) rootView.findViewById(R.id.memberId);
        emailPhoneEt = (TextInputEditText) rootView.findViewById(R.id.emailPhone);
        passwordEt = (TextInputEditText) rootView.findViewById(R.id.password);
        final CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.imMember);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    Log.e(TAG, "onCheckboxClicked: true");
                    memberId.setVisibility(View.VISIBLE);
                    forgetPass.setVisibility(View.GONE);
                } else {
                    memberId.setVisibility(View.GONE);
                    forgetPass.setVisibility(View.VISIBLE);

                }
            }
        });

        RelativeLayout loginBtn = (RelativeLayout) rootView.findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailPhoneEt.getText().toString();
                String password = passwordEt.getText().toString();
                boolean validEmail=isEmailValid(email);
                boolean validNumber=isEmailValid(email);

                if (email.equals("")) {
                    emailPhoneEt.setError("email is empty");
                } else if (password.equals("")) {
                    passwordEt.setError("please enter password");
                } else if(validEmail || validNumber){
                    Intent intent = new Intent(getActivity(), BottomNavigationActivity.class);
                    startActivity(intent);
                }else {
                    emailPhoneEt.setError("input is invalid");

                }
            }
        });
        return rootView;
    }
    public  boolean isEmailValid(String email) {

        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public boolean isPhoneValid(CharSequence phoneNumber){
        return android.util.Patterns.PHONE.matcher(phoneNumber).matches();

    }

}