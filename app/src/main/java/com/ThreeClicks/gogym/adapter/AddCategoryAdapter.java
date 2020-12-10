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

public class AddCategoryAdapter extends RecyclerView.Adapter<AddCategoryAdapter.ViewHolder> {
    ArrayList<String> arrayList;
    Context context;

    public AddCategoryAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AddCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_category, parent, false);

        AddCategoryAdapter.ViewHolder viewHolder =
                new AddCategoryAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddCategoryAdapter.ViewHolder holder, int position) {
        String categoriy = arrayList.get(position);
        holder.categoryTextview.setText("" +categoriy);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTextview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTextview = (TextView) itemView.findViewById(R.id.category);
        }
    }
}
