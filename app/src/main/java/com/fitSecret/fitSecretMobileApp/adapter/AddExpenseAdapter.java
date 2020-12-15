package com.fitSecret.fitSecretMobileApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fitSecret.fitSecretMobileApp.R;

import java.util.ArrayList;

public class AddExpenseAdapter extends RecyclerView.Adapter<AddExpenseAdapter.ViewHolder> {
ArrayList<String> expenseArraylist;
Context context;

    public AddExpenseAdapter(ArrayList<String> expenseArraylist, Context context) {
        this.expenseArraylist = expenseArraylist;
        this.context = context;
    }

    @NonNull
    @Override
    public AddExpenseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_expense, parent, false);

        AddExpenseAdapter.ViewHolder viewHolder =
                new AddExpenseAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddExpenseAdapter.ViewHolder holder, int position) {
        holder.positionTextview.setText("" +(position+1));
    }

    @Override
    public int getItemCount() {
        return expenseArraylist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView positionTextview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            positionTextview = (TextView) itemView.findViewById(R.id.expense_position);
        }
    }
}
