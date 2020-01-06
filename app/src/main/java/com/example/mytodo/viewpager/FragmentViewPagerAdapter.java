package com.example.mytodo.viewpager;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    private final static int FRAGMENTS_COUNT = 2;


    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new Fragment();
        switch (position) {
            case 0:
                fragment = FragmentOne.newInstance();
                break;
            case 1:
                fragment = FragmentTwo.newInstance();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return FRAGMENTS_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "page one";
            case 1:
                return "page two";
        }
        return super.getPageTitle(position);
    }
}
