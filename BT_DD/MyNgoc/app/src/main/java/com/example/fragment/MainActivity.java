package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentInfo fragmentProductInfo = (FragmentInfo) getFragmentManager().findFragmentById(R.id.fragmenifo);
//
//        Configuration configuration = getResources().getConfiguration();
//
//        if (fragmentProductInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//
//        }else {
//
//            Intent intent = new Intent(MainActivity.this, FragmentInfo.class);
//            intent.putExtra("product", "da qua");
//            startActivity(intent);
//        }
    }
}