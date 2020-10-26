package com.ThreeClicks.gogym.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ThreeClicks.gogym.BottomNavigationActivity;
import com.ThreeClicks.gogym.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
public class ExistingFragment extends Fragment {
     TextInputLayout memberId;
     LinearLayout otherPlatform,view;
     TextView forgetPass;
     TextInputEditText passwordEt,emailPhoneEt;
     TextView loginText;
     ProgressBar progressBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_existing, container, false);
        forgetPass=(TextView) rootView.findViewById(R.id.forgetPassword);
        memberId=(TextInputLayout) rootView.findViewById(R.id.memberId);
        otherPlatform=(LinearLayout) rootView.findViewById(R.id.otherPlatform);
         view=(LinearLayout) rootView.findViewById(R.id.view);
         emailPhoneEt=(TextInputEditText) rootView.findViewById(R.id.emailPhone);
         passwordEt=(TextInputEditText) rootView.findViewById(R.id.password);
        RelativeLayout loginBtn=(RelativeLayout) rootView.findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailPhoneEt.getText().toString();
                String password=passwordEt.getText().toString();
                if(email.equals("")){
                    emailPhoneEt.setError("email is empty");
                }else if(password.equals("")){
                        passwordEt.setError("please enter password");
                    }
               else{
                Intent intent = new Intent(getActivity(), BottomNavigationActivity.class);
                startActivity(intent);
            }}
        });
        return rootView;
    }

    public void onCheckboxClicked(View v) {
        boolean checked = ((CheckBox) v).isChecked();
        switch (view.getId()) {
            case R.id.member:
                if (checked) {

                    memberId.setVisibility(View.VISIBLE);
                    otherPlatform.setVisibility(View.INVISIBLE);
                    forgetPass.setVisibility(View.INVISIBLE);
                    view.setVisibility(View.INVISIBLE);
                } else {
                    memberId.setVisibility(View.INVISIBLE);
                    otherPlatform.setVisibility(View.VISIBLE);
                    forgetPass.setVisibility(View.VISIBLE);
                    view.setVisibility(View.VISIBLE);
                }
break;

        }
    }}