package com.fitSecret.fitSecretMobileApp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitSecret.fitSecretMobileApp.BottomNavigationActivity;
import com.fitSecret.fitSecretMobileApp.R;

public class ShopFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationActivity.setTitleOfToolbar("Shop");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_shop, container, false);
    }
}