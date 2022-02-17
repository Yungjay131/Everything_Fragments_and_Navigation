package com.slyworks.everything_fragments_and_navigation.book.chap_01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

import com.slyworks.everything_fragments_and_navigation.book.chap_01.fragments.Chap_01_DetailsFragment;

public class Chap_01_DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*notice there is no setContentView(), binding is done to android.R.id.content???*/
        initData();
    }

    private void initData(){
        boolean isInLandscapeOrientation =
                getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        boolean isThereIntent = getIntent() != null;

        if (isInLandscapeOrientation) {
            /*if the screen is now in LANDSCAPE mode it means that this Activity's parent activity
            * Chap_01_MainActivity is being shown with both the titles and the text
            * and hence this Activity is no longer needed, so exit and let Chap_01_MainActivity do all the work*/
            finish();
            return;
        }

        if(isThereIntent){
            /*another way to instantiate the Chap_01_DetailsFragment
            * i think this means that its in PORTRAIT mode, hence this Activity is being used*/
            Bundle bundle = getIntent().getExtras();
            Chap_01_DetailsFragment fragment = Chap_01_DetailsFragment.newInstance(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, fragment)
                    .commit();
        }
    }
}