package com.dicoding.windi.jetpack.ui.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dicoding.windi.jetpack.R;
import com.dicoding.windi.jetpack.ui.film.FilmFragment;
import com.dicoding.windi.jetpack.ui.show.ShowFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.film, R.string.show};
    private final Context mContext;

    SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FilmFragment();
            case 1:
                return new ShowFragment();
            default:
                return new Fragment();
        }
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
