package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Intent intents [] = new Intent [3];


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    //mTextMessage.setText(R.string.title_home);
                    startActivity(intents[0]);
                    return true;
                }
                case R.id.navigation_dashboard: {
                    //mTextMessage.setText(R.string.title_dashboard);
                    startActivity(intents[1]);
                    return true;
                }
                case R.id.navigation_notifications: {
                    //mTextMessage.setText(R.string.title_notifications);
                    startActivity(intents[2]);
                    return true;
                }
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);

        intents[0] = new Intent(this,MainNotificationsActivity.class);
        intents[1] = new Intent(this,MainActivity.class);
        intents[2] = new Intent(this,MainDonateActivity.class);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTextMessage.setText(R.string.title_home);
    }

}
