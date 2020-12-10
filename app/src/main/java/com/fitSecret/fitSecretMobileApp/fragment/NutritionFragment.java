package com.fitSecret.fitSecretMobileApp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitSecret.fitSecretMobileApp.BottomNavigationActivity;
import com.fitSecret.fitSecretMobileApp.R;

public class NutritionFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationActivity.setTitleOfToolbar("Nutrition");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_nutrition, container, false);
    }
}