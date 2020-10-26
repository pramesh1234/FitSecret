package com.ThreeClicks.gogym.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ThreeClicks.gogym.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoHelpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoHelpFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root=inflater.inflate(R.layout.fragment_video_help, container, false);
        return root;
    }
}