package com.fitSecret.fitSecretMobileApp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fitSecret.fitSecretMobileApp.R;
import com.fitSecret.fitSecretMobileApp.fragment.FaqFragment;
import com.fitSecret.fitSecretMobileApp.fragment.VideoHelpFragment;

public class HelpPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.FAQs_tab, R.string.video_help};
    private final Context mContext;
    public HelpPagerAdapter(Context mContext, FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new FaqFragment();
        }
        else if (position == 1)
        {
            fragment = new VideoHelpFragment();
        }
        return fragment;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
    @Override
    public int getCount() {
        return 2;
    }
}
