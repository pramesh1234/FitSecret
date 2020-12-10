package com.fitSecret.fitSecretMobileApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fitSecret.fitSecretMobileApp.R;
import com.fitSecret.fitSecretMobileApp.data.AddNoticeData;

import java.util.ArrayList;

public class AddNoticeAdapter extends RecyclerView.Adapter<AddNoticeAdapter.ViewHolder> {
    ArrayList<AddNoticeData> arrayList;
Context context;
    public AddNoticeAdapter(Context context,ArrayList<AddNoticeData> arrayList) {
        this.context=context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AddNoticeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_notice, parent, false);

        AddNoticeAdapter.ViewHolder viewHolder =
                new AddNoticeAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddNoticeAdapter.ViewHolder holder, int position) {
        holder.member.setText(""+arrayList.get(position).getNoticeMember());
        holder.noticeName.setText(""+arrayList.get(position).getNoticeName());
        holder.duration.setText(""+arrayList.get(position).getNoticeDuration());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView noticeName;
        public TextView duration;
        public TextView member;

        public ViewHolder(View view) {
            super(view);
            noticeName = (TextView) view.findViewById(R.id.notice_name);
            duration= (TextView) view.findViewById(R.id.notice_duration);
            member = (TextView) view.findViewById(R.id.member);
        }
    }

}
