package com.ThreeClicks.gogym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ThreeClicks.gogym.R;
import com.ThreeClicks.gogym.data.AddPlanData;

import java.util.ArrayList;

public class AddPlanAdapter extends RecyclerView.Adapter<AddPlanAdapter.ViewHolder> {
    Context context;
    ArrayList<AddPlanData> arrayList;

    public AddPlanAdapter(Context context, ArrayList<AddPlanData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AddPlanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_manage_plan, parent, false);

        AddPlanAdapter.ViewHolder viewHolder =
                new AddPlanAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddPlanAdapter.ViewHolder holder, int position) {
        AddPlanData addPlanData = arrayList.get(position);
        holder.planName.setText("" + addPlanData.getPlanName());
        holder.planType.setText("" + addPlanData.getPlanType());
        holder.planAmount.setText("" + addPlanData.getPlanAmount());
        holder.planDuration.setText("" + addPlanData.getPlanDuration());
        holder.planDescription.setText("" + addPlanData.getPlanDescription());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView planName;
        public TextView planType;
        public TextView planAmount;
        public TextView planDuration;
        public TextView planDescription;


        public ViewHolder(View view) {
            super(view);
            planName = (TextView) view.findViewById(R.id.plan_name);
            planType = (TextView) view.findViewById(R.id.plan_type);
            planAmount = (TextView) view.findViewById(R.id.plan_amount);
            planDuration = (TextView) view.findViewById(R.id.plan_duration);
            planDescription = (TextView) view.findViewById(R.id.plan_description);
        }
    }
}
