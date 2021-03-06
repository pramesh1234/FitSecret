package com.fitSecret.fitSecretMobileApp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.fitSecret.fitSecretMobileApp.BottomNavigationActivity;
import com.fitSecret.fitSecretMobileApp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpFragment extends Fragment {
    TextInputEditText fullNameEt,emailEt,mobileEt,passwordEt,cnfrmPasswordEt;
    RelativeLayout registerBtn;
    TextInputLayout referral;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_sign_up, container, false);
        referral=(TextInputLayout) rootView.findViewById(R.id.referal);
        final CheckBox checkBox=(CheckBox) rootView.findViewById(R.id.referralCheckbox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    referral.setVisibility(View.VISIBLE);
                }else{
                    referral.setVisibility(View.GONE);
                }
            }
        });
         fullNameEt=(TextInputEditText) rootView.findViewById(R.id.fullNameEt);
         mobileEt=(TextInputEditText) rootView.findViewById(R.id.mobileEt);
         emailEt=(TextInputEditText) rootView.findViewById(R.id.emailEt);
         passwordEt=(TextInputEditText) rootView.findViewById(R.id.passwordEt);
         cnfrmPasswordEt=(TextInputEditText) rootView.findViewById(R.id.confirmPasswordEt);
         registerBtn=(RelativeLayout) rootView.findViewById(R.id.registerBtn);
         registerBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String fullName=fullNameEt.getText().toString();
                 String mobile=mobileEt.getText().toString();
                 String email=emailEt.getText().toString();
                 String password=passwordEt.getText().toString();
                 String cnfrmPassword=cnfrmPasswordEt.getText().toString();
                 if(fullName.equals("")){
                     fullNameEt.setError("Full name is Empty");
                 }else if(mobile.equals("")){
                     mobileEt.setError("Mobile no. is Empty");
                 }else if(email.equals("")){
                     emailEt.setError("Email is Empty");
                 }else if(password.equals("")){
                     passwordEt.setError("Password is Empty");
                 }else if(cnfrmPassword.equals("")){
                     cnfrmPasswordEt.setError("Password is Empty");
                 }else if(!password.equals(cnfrmPassword)){
                     Toast.makeText(getContext(), "Passwords are not matching", Toast.LENGTH_SHORT).show();
                 }else{
                     Intent i=new Intent(getActivity(), BottomNavigationActivity.class);
                     startActivity(i);
                 }
             }
         });
        return rootView;
    }
}