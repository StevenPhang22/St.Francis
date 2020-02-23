package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.StrictMode;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment;
    private FragmentManager fm = getSupportFragmentManager();
    private FragmentTransaction transaction;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    swapFragment(new HomeFragment());
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    swapFragment(new DonateFragment());
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    swapFragment(new NotificationsFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
        swapFragment(new HomeFragment());
    }

    protected void swapFragment(Fragment f)
    {
        transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment6, f);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
