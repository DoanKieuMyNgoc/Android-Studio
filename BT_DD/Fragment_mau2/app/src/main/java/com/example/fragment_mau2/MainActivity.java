package com.example.fragment_mau2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        FirstFragment firstFragment = new FirstFragment();
        if (findViewById(R.id.contentFrame) != null) {
            // Found the ID of only one Fragment ==> Portrait mode
            // Remove the existing fragment before add new one
            if (savedInstanceState != null) {
                getSupportFragmentManager().executePendingTransactions();
                Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.contentFrame);
                if (fragmentById != null) {
                    getSupportFragmentManager().beginTransaction().remove(fragmentById).commit();
                }
            }

            // Add new one
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, firstFragment).commit();
        } else {
            // Landscape mode
            // Remove the existing fragments before add new one
            if (savedInstanceState != null) {
                getSupportFragmentManager().executePendingTransactions();
                Fragment firstFragmentById = getSupportFragmentManager().findFragmentById(R.id.firstFrame);
                if (firstFragmentById != null) {
                    getSupportFragmentManager().beginTransaction().remove(firstFragmentById).commit();
                }
                Fragment secondFragmentById = getSupportFragmentManager().findFragmentById(R.id.secondFrame);
                if (secondFragmentById != null) {
                    getSupportFragmentManager().beginTransaction().remove(secondFragmentById).commit();
                }
            }

            // Add new one
            getSupportFragmentManager().beginTransaction().add(R.id.firstFrame, firstFragment).commit();
        }
    }
    @Override
    public void onItemPressed(String content) {
        SecondFragment secondFragment = SecondFragment.newInstance(content);
        if (findViewById(R.id.contentFrame) != null) {
            // Found the ID of only one Fragment ==> Portrait mode
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contentFrame, secondFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            // Landscape mode
            getSupportFragmentManager().beginTransaction().replace(R.id.secondFrame, secondFragment).commit();
        }
}}