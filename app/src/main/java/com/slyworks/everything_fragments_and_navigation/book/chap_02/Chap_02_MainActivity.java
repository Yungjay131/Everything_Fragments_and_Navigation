package com.slyworks.everything_fragments_and_navigation.book.chap_02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

import com.slyworks.everything_fragments_and_navigation.R;

public class Chap_02_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap02_main);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT ){}
        /*add other configuration you are handling*/
    }
}