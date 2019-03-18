package com.eemf.sirgoingfar.android_design_pattern.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.eemf.sirgoingfar.android_design_pattern.R;
import com.eemf.sirgoingfar.android_design_pattern.utils.BottomNavUtil;

public class BottomNavActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{

    private TextView mTextMessage;
    private BottomNavigationView mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        mTextMessage = findViewById(R.id.message);
        mBottomNavigation = findViewById(R.id.navigation);
        mBottomNavigation.setOnNavigationItemSelectedListener(this);
//        menu_bottom_nav.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
//        menu_bottom_nav.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_bottom_nav));
        BottomNavUtil.removeShiftMode(mBottomNavigation);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mTextMessage.setText(R.string.title_home);
                return true;
            case R.id.navigation_dashboard:
                mTextMessage.setText(R.string.title_dashboard);
                return true;
            case R.id.navigation_notifications:
                mTextMessage.setText(R.string.title_notifications);
                return true;
            case R.id.navigation_home1:
                mTextMessage.setText(R.string.title_home);
                return true;
            case R.id.navigation_dashboard1:
                mTextMessage.setText(R.string.title_dashboard);
                return true;
        }

        return false;
    }

}
