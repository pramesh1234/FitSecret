package com.fitSecret.fitSecretMobileApp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitSecret.fitSecretMobileApp.R;
import com.fitSecret.fitSecretMobileApp.adapter.FaqAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FaqFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FaqFragment extends Fragment {
    RecyclerView faqRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<String> myDataset;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDataset=new ArrayList<>();
        myDataset.add("Just-LeaseIt has been in the Rent-to-Own business for over 30 years.They found that they had a number of well-educated or mid to high-income clients that asked about Leasing vs. Renting. Many understood finances better, and were going through a divorce or something else that put them in their situation. They decided to launch a new site, designed and built by Clarity to provide more desireable leasing terms for those clients, and the FAQ spells it all out for them.");
        myDataset.add("CoServ Electric Co-op services almost 300,000 customers. The FAQs dramatically reduce the number of phone calls the company receives and improves the speed at which their customers can find answers to their questions. The module allows the company to easily categorize and add their own FAQs when they need.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_faq, container, false);
        faqRecyclerView = (RecyclerView) root.findViewById(R.id.faqRecyclerView);
        faqRecyclerView.hasFixedSize();
        layoutManager=new LinearLayoutManager(getContext());
        faqRecyclerView.setLayoutManager(layoutManager);
         mAdapter = new FaqAdapter(myDataset);
        faqRecyclerView.setAdapter(mAdapter);
        return root;
    }
}