package com.slyworks.everything_fragments_and_navigation.book.chap_01.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import com.slyworks.everything_fragments_and_navigation.R;
import com.slyworks.everything_fragments_and_navigation.book.chap_01.fragments.Chap_01_DetailsFragment;

public class Chap_01_MainActivity extends AppCompatActivity {
    //region Vars
    private static final String TAG = Chap_01_MainActivity.class.getSimpleName();
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //FragmentManager.enableDebugLogging(true);
        setContentView(R.layout.activity_chap01_main);
    }

    private boolean isMultiPane(){
        /*helper function to determine if the phone is flipped hence show 2
        * Fragments side by side*/
        boolean isInLandscapeOrientation =
                getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        return isInLandscapeOrientation;
    }

    public void showDetails(int index){
        /*
         * Helper function to show the details of a selected item, either by
         * displaying a fragment in-place in the current UI, or starting a
         * whole new activity in which it is displayed.
         */
        Log.e(TAG, "showDetails: in Chapter_01_Activity showDetails(" +index+")" );

        if(!isMultiPane()) return;

        /*check what Fragment is shown, replace if needed
        * in the FrameLayout, would return null if the FrameLayout is empty*/
        Chap_01_DetailsFragment fragment = (Chap_01_DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_main);

        if (fragment != null || fragment.getShownIndex() == index) {
            /*launch a new Activity to display the dialog Fragment with the
             * selected text???*/
            Intent intent = new Intent();
            intent.setClass(this, Chap_01_DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
            return;
        }

            /*getting here means the above conditions failed,
            make new Fragment to show this selection*/
        fragment = Chap_01_DetailsFragment.newInstance(index);

        /*execute a transation, replacing any existing fragment with the one
         * with the one inside the Frame???*/
        Log.e(TAG, "showDetails: about to run FragmentTransaction...");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        /*you can set custom animation transitions
        * 1st is entering transition, 2nd is exit transition */
        /*transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);*/
         transaction.setCustomAnimations(R.animator.bounce_in_down, R.animator.slide_out_right);
        /*transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);*/
        /* details here is the TAG for the Fragment
        transaction.addToBackStack("details");
        */
        transaction.replace(R.id.fragment_container_main, fragment);
        transaction.commit();

        /*
        * there is a BUNDLE and KEY method of retrieving a Fragment only works
        * using putFragment()
        * getFragment()
        * findFragmentById()
        * findFragmentByTag()
        * you can add a Fragment without making it visible to the user(OG way of doing ViewModels)
        * and setRetainState() can be called on such a Fragment*/
    }

}