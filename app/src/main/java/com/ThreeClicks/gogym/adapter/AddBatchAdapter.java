package com.ThreeClicks.gogym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ThreeClicks.gogym.R;
import com.ThreeClicks.gogym.data.AddBatchData;

import java.util.ArrayList;

public class AddBatchAdapter extends RecyclerView.Adapter<AddBatchAdapter.ViewHolder> {
    Context context;
    ArrayList<AddBatchData> arrayList;

    public AddBatchAdapter(Context context, ArrayList<AddBatchData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AddBatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_manage_batch, parent, false);

        AddBatchAdapter.ViewHolder viewHolder =
                new AddBatchAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddBatchAdapter.ViewHolder holder, int position) {
        AddBatchData addBatchData = arrayList.get(position);
        holder.batchNameTextView.setText("" + addBatchData.getBatchName());
        holder.batchLimitTextView.setText("" + addBatchData.getBatchLimit());
        holder.batchTimeTextView.setText("" + addBatchData.getBatchTime());
        holder.totalBatchLimitTextView.setText("" + addBatchData.getBatchLimit());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView batchNameTextView;
        TextView batchLimitTextView;
        TextView batchTimeTextView;
        TextView totalBatchLimitTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            batchNameTextView = (TextView) itemView.findViewById(R.id.batch_name);
            batchLimitTextView = (TextView) itemView.findViewById(R.id.batch_limit);
            batchTimeTextView = (TextView) itemView.findViewById(R.id.batch_time);
            totalBatchLimitTextView= (TextView) itemView.findViewById(R.id.batch_total_limit);

        }
    }
}

