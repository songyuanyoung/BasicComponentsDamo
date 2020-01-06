package com.example.mytodo.viewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mytodo.R;
import com.google.android.material.tabs.TabLayout;

public class ViewPagerActivity extends AppCompatActivity {


    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mTabLayout = (TabLayout) findViewById(R.id.tablayout);

        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.setAdapter(new FragmentViewPagerAdapter(getSupportFragmentManager()));
    }
}
