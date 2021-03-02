package com.example.android.hughstourguideapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

// Created by katherinekuan on 4/14/16.

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Location} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {
    /** Context of the app */
    private final Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     * across swipes.
     * @param context is the context of the app
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new WelcomeFragment();
        } else if (position == 1) {
            return new TrailsFragment();
        } else if (position == 2) {
            return new AccommodationFragment();
        }
        else {
            return new BarsAndFoodFragment();
        }

    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return mContext.getString(R.string.category_welcome);
        }
        else if(position == 1){
            return mContext.getString(R.string.category_trails);
        }
        else if(position == 2){
            return mContext.getString(R.string.category_accommodation);
        }
        else {
            return mContext.getString(R.string.category_bars_and_Food);
        }

    }
}