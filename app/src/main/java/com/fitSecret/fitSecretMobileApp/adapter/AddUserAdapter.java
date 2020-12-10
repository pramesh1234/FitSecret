package com.fitSecret.fitSecretMobileApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fitSecret.fitSecretMobileApp.R;
import com.fitSecret.fitSecretMobileApp.data.AddUserData;

import java.util.ArrayList;

public class AddUserAdapter extends RecyclerView.Adapter<AddUserAdapter.ViewHolder> {
    Context context;
    ArrayList<AddUserData> addUserDataArrayList;

    public AddUserAdapter(Context context, ArrayList<AddUserData> addUserDataArrayList) {
        this.context = context;
        this.addUserDataArrayList = addUserDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_manage_user, parent, false);

        AddUserAdapter.ViewHolder viewHolder =
                new AddUserAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AddUserData addUserData = addUserDataArrayList.get(position);
        holder.userNameTv.setText("" + addUserData.getUserName());
        holder.userEmailTv.setText("" + addUserData.getUserEmail());
        holder.userTypeTv.setText("" + addUserData.getUserType());
        holder.userMobileTv.setText("" + addUserData.getUserMobileNo());
        holder.homeCb.setChecked(addUserData.isHome());
        holder.sliderCb.setChecked(addUserData.isSlider());
        holder.enrollmentCb.setChecked(addUserData.isEnrollment());
        holder.userCb.setChecked(addUserData.isUser());
        holder.planCb.setChecked(addUserData.isPlan());
        holder.taxCb.setChecked(addUserData.isTax());
        holder.memberCb.setChecked(addUserData.isMember());
        holder.smsCb.setChecked(addUserData.isSms());
        holder.invoiceCb.setChecked(addUserData.isInvoice());
        holder.exportCb.setChecked(addUserData.isExport());
        holder.noticeCb.setChecked(addUserData.isNotice());
        holder.trainerCb.setChecked(addUserData.isTrainer());
        holder.enquiryCb.setChecked(addUserData.isEnquiry());
        holder.dietCb.setChecked(addUserData.isDiet());
        holder.measurementCb.setChecked(addUserData.isMeasurement());
        holder.exerciseCb.setChecked(addUserData.isExercise());
    }

    @Override
    public int getItemCount() {
        return addUserDataArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView userNameTv, userEmailTv, userTypeTv, userMobileTv;
        CheckBox homeCb, sliderCb, enrollmentCb, userCb, planCb, taxCb, memberCb, smsCb, invoiceCb, exportCb, noticeCb, trainerCb, enquiryCb, dietCb, measurementCb, exerciseCb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userNameTv = (TextView) itemView.findViewById(R.id.user_name);
            userEmailTv = (TextView) itemView.findViewById(R.id.user_email);
            userMobileTv = (TextView) itemView.findViewById(R.id.user_mobile);
            userTypeTv = (TextView) itemView.findViewById(R.id.user_type_tv);
            homeCb = (CheckBox) itemView.findViewById(R.id.home_checkbox);
            sliderCb = (CheckBox) itemView.findViewById(R.id.slider_checkbox);
            enrollmentCb = (CheckBox) itemView.findViewById(R.id.enrollment_checkbox);
            planCb = (CheckBox) itemView.findViewById(R.id.plan_checkbox);
            taxCb = (CheckBox) itemView.findViewById(R.id.tax_checkbox);
            memberCb = (CheckBox) itemView.findViewById(R.id.member_checkbox);
            smsCb = (CheckBox) itemView.findViewById(R.id.sms_checkbox);
            invoiceCb = (CheckBox) itemView.findViewById(R.id.invoice_checkbox);
            exportCb = (CheckBox) itemView.findViewById(R.id.export_checkbox);
            noticeCb = (CheckBox) itemView.findViewById(R.id.notice_checkbox);
            trainerCb = (CheckBox) itemView.findViewById(R.id.trainer_checkbox);
            enquiryCb = (CheckBox) itemView.findViewById(R.id.enquiry_checkbox);
            dietCb = (CheckBox) itemView.findViewById(R.id.diet_checkbox);
            userCb=(CheckBox) itemView.findViewById(R.id.user_checkbox);
            measurementCb = (CheckBox) itemView.findViewById(R.id.measurement_checkbox);
            exerciseCb = (CheckBox) itemView.findViewById(R.id.exercise_checkbox);

        }
    }
}
