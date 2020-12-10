package com.fitSecret.fitSecretMobileApp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.fitSecret.fitSecretMobileApp.BottomNavigationActivity;
import com.fitSecret.fitSecretMobileApp.R;
import com.fitSecret.fitSecretMobileApp.adapter.ImageAdapter;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationActivity.setTitleOfToolbar("Home");

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager mViewPager = (ViewPager) root.findViewById(R.id.viewpager);
        ImageAdapter adapterView = new ImageAdapter(getContext());
        mViewPager.setAdapter(adapterView);

        return root;
    }
}