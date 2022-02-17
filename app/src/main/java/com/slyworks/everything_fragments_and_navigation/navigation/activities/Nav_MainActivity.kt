package com.slyworks.everything_fragments_and_navigation.navigation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.slyworks.everything_fragments_and_navigation.R
import com.slyworks.everything_fragments_and_navigation.navigation.ActivityWrapper
import com.slyworks.everything_fragments_and_navigation.navigation.FragmentWrapper
import com.slyworks.everything_fragments_and_navigation.navigation.NavigationManager

class Nav_MainActivity : AppCompatActivity() {
    //region Vars
    private lateinit var bottom_nav:BottomNavigationView
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_main)

        initData()
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    private fun initData(){
        ActivityWrapper.NAV_MAIN.setFragmentManager(supportFragmentManager)
    }
    private fun initViews(){
        bottom_nav = findViewById(R.id.bottom_nav_bar_activity_nav_main);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_bottom_nav_bar_home -> {
                NavigationManager.displayFragment(FragmentWrapper.HOME)
                bottom_nav.selectedItemId = R.id.action_bottom_nav_bar_home
            }
            R.id.action_bottom_nav_bar_find_doctors -> {
               NavigationManager.displayFragment(FragmentWrapper.FIND_DOCTORS)
               bottom_nav.selectedItemId = R.id.action_bottom_nav_bar_find_doctors
            }
            R.id.action_bottom_nav_bar_chat -> {
                NavigationManager.displayFragment(FragmentWrapper.CHAT_HOST)
                bottom_nav.selectedItemId = R.id.action_bottom_nav_bar_chat
            }
        }

        return true
    }
}