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
import com.ThreeClicks.gogym.data.AddSmsTemplateData;

import java.util.ArrayList;

public class AddSmsTemplateAdapter extends RecyclerView.Adapter<AddSmsTemplateAdapter.ViewHolder> {
Context context;
ArrayList<AddSmsTemplateData> arrayList;

    public AddSmsTemplateAdapter(Context context, ArrayList<AddSmsTemplateData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_sms_template, parent, false);

        AddSmsTemplateAdapter.ViewHolder viewHolder = new AddSmsTemplateAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AddSmsTemplateData addSmsTemplateData = arrayList.get(position);
        holder.smsName.setText("" + addSmsTemplateData.getSmsName());
        holder.smsContent.setText("" + addSmsTemplateData.getSmsContent());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView smsName;
        public TextView smsContent;

        public ViewHolder(View view) {
            super(view);
            smsName = (TextView) view.findViewById(R.id.sms_name);
            smsContent = (TextView) view.findViewById(R.id.sms_content);

        }
    }
}
