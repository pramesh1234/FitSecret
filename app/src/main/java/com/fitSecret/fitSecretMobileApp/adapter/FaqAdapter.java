package com.fitSecret.fitSecretMobileApp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fitSecret.fitSecretMobileApp.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {
    private ArrayList<String> mDataset;
    private static final String TAG = "FaqAdapter";

    public static class FaqViewHolder extends RecyclerView.ViewHolder {

        public ExpandableTextView textView;

        public FaqViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.expand_text_view);
        }
    }
    public FaqAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public FaqAdapter.FaqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.row_faq,parent,false);
        FaqViewHolder vh=new FaqViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FaqAdapter.FaqViewHolder holder, int position) {
        holder.textView.setText(mDataset.get(position));

    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: "+ mDataset.size());
        return mDataset.size();
    }
}
