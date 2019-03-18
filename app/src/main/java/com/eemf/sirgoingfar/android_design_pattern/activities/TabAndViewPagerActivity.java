package com.eemf.sirgoingfar.android_design_pattern.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;

import com.eemf.sirgoingfar.android_design_pattern.R;
import com.eemf.sirgoingfar.android_design_pattern.fragment.EightFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.FiveFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.FourFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.NineFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.OneFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.SevenFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.SixFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.TenFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.ThreeFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;


public class TabAndViewPagerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_and_view_pager);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        adapter.addFragment(new FourFragment(), "FOUR");
        adapter.addFragment(new FiveFragment(), "FIVE");
        adapter.addFragment(new SixFragment(), "SIX");
        adapter.addFragment(new SevenFragment(), "SEVEN");
        adapter.addFragment(new EightFragment(), "EIGHT");
        adapter.addFragment(new NineFragment(), "NINE");
        adapter.addFragment(new TenFragment(), "TEN");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {

            View view = LayoutInflater.from(TabAndViewPagerActivity.this).inflate(R.layout.item_category_list, null);
            CheckedTextView catName = view.findViewById(R.id.ctv_category_name);
            catName.setText(String.valueOf(position));
            tabLayout.getTabAt(position).setCustomView(view);

            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
