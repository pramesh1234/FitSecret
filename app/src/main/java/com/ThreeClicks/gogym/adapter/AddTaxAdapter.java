package com.ThreeClicks.gogym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ThreeClicks.gogym.R;
import com.ThreeClicks.gogym.data.AddTaxData;

import java.util.ArrayList;

public class AddTaxAdapter extends RecyclerView.Adapter<AddTaxAdapter.ViewHolder> {
    ArrayList<AddTaxData> arrayList;
    Context context;

    public AddTaxAdapter(ArrayList<AddTaxData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AddTaxAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_manage_tax, parent, false);

        AddTaxAdapter.ViewHolder viewHolder =
                new AddTaxAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddTaxAdapter.ViewHolder holder, int position) {
        AddTaxData addTaxData = arrayList.get(position);
        holder.taxName.setText("" + addTaxData.getTaxName());
        holder.taxPercentage.setText("" + addTaxData.getTaxPercentage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView taxName;
        public TextView taxPercentage;

        public ViewHolder(View view) {
            super(view);
            taxName = (TextView) view.findViewById(R.id.tax_name);
            taxPercentage = (TextView) view.findViewById(R.id.tax_percentage);
        }
    }
}
