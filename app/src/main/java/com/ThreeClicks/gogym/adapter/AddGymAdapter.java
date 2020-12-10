package com.ThreeClicks.gogym.adapter;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ThreeClicks.gogym.R;
import com.ThreeClicks.gogym.data.AddGymData;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class AddGymAdapter extends RecyclerView.Adapter<AddGymAdapter.ViewHolder> {
    private Context context;
    private List<AddGymData> gymDataList;
    int lastSelectedPosition = -1;

    public AddGymAdapter(Context context, List<AddGymData> gymDataList) {
        this.context = context;
        this.gymDataList = gymDataList;
    }

    @NonNull
    @Override
    public AddGymAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_manage_gym, parent, false);

        AddGymAdapter.ViewHolder viewHolder =
                new AddGymAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddGymAdapter.ViewHolder holder, int position) {
        AddGymData addGymData = gymDataList.get(position);
        holder.gymName.setText(addGymData.getDisplayName());
        holder.gymAddress.setText("" + addGymData.getAddressLine1() + ", " + addGymData.getAddressLine2());
        holder.gymState.setText("" + addGymData.getCity() + ", " + addGymData.getState());
        holder.selectGym.setChecked(lastSelectedPosition == position);
    }

    @Override
    public int getItemCount() {
        return gymDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView gymName;
        public TextView gymAddress;
        public TextView gymState;
        public ImageView moreOptions;

        public RadioButton selectGym;

        public ViewHolder(View view) {
            super(view);
            gymName = (TextView) view.findViewById(R.id.gym_name);
            gymAddress = (TextView) view.findViewById(R.id.address_line);
            gymState = (TextView) view.findViewById(R.id.gym_location);
            selectGym = (RadioButton) view.findViewById(R.id.selectGymRadio);
            selectGym.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();

                    Toast.makeText(AddGymAdapter.this.context,
                            "selected gym is " + gymName.getText(),
                            Toast.LENGTH_LONG).show();
                }
            });
            moreOptions = (ImageView) view.findViewById(R.id.more_options);
            moreOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopupMenu(v, true, R.style.PopTheme);
                }
            });
        }
    }

    public void showPopupMenu(View anchor, boolean isWithIcons, int style) {
        Context wrapper = new ContextThemeWrapper(context, style);


        PopupMenu popup = new PopupMenu(wrapper, anchor);

        if (isWithIcons) {
            try {
                Field[] fields = popup.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if ("mPopup".equals(field.getName())) {
                        field.setAccessible(true);
                        Object menuPopupHelper = field.get(popup);
                        Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                        Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                        setForceIcons.invoke(menuPopupHelper, true);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_edit:
                        break;
                    case R.id.action_delete:

                        break;

                }
                return true;
            }
        });
        popup.show();

    }

}

