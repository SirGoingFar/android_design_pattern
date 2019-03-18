package com.eemf.sirgoingfar.android_design_pattern.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.eemf.sirgoingfar.android_design_pattern.R;
import com.eemf.sirgoingfar.android_design_pattern.fragment.FiveFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.FourFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.OneFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.ThreeFragment;
import com.eemf.sirgoingfar.android_design_pattern.fragment.TwoFragment;

public class NavDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawer;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private android.support.v4.app.FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        if(fm == null)
            fm = getSupportFragmentManager();

        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            closeNavDrawer();
        } else if (fm.getBackStackEntryCount() < 2){
            finish();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bottom_nav_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings Activity opens", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        if (item == null) {
            return false;
        }

        // Handle menu_bottom_nav view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startFragment(new OneFragment(), true);
        } else if (id == R.id.nav_expense) {
            startFragment(new TwoFragment(), true);
        } else if (id == R.id.nav_income) {
            startFragment(new ThreeFragment(), true);
        } else if (id == R.id.nav_fin_plan) {
            startFragment(new FourFragment(), true);
        } else if (id == R.id.nav_budget) {
            startFragment(new FiveFragment(), true);
        }

        //close the
        closeNavDrawer();

        return true;
    }

    private void closeNavDrawer() {
        mDrawer.closeDrawer(GravityCompat.START);
    }

    public void startFragment(@NonNull Fragment fragment, boolean addToBackstack) {

        String tag = fragment.getClass().getName();

        if (fm == null)
            fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction().replace(R.id.container, fragment, tag);

        if(addToBackstack)
            ft.addToBackStack(tag).commit();
        else
            ft.commit();
    }
}
