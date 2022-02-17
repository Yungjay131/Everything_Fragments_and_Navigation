package com.slyworks.everything_fragments_and_navigation.navigation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.slyworks.everything_fragments_and_navigation.R
import com.slyworks.everything_fragments_and_navigation.navigation.ActivityWrapper
import com.slyworks.everything_fragments_and_navigation.navigation.NavigationManager

class Nav_WelcomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //region Vars
    private lateinit var drawer:DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var toggle:ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    //endregion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_welcome)
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    private fun initViews(){
        drawer = findViewById(R.id.drawer_nav_welcome)
        toolbar = findViewById(R.id.toolBar_nav_welcome)
        navigationView = findViewById(R.id.navigation_nav_welcome)

        toolbar.title = ""
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(
            this,
            drawer,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_nav_login -> NavigationManager.display(ActivityWrapper.NAV_LOGIN)
            R.id.action_nav_main -> NavigationManager.display(ActivityWrapper.NAV_MAIN)
            R.id.action_nav_message -> NavigationManager.display(ActivityWrapper.NAV_MESSAGE)
            R.id.action_nav_videocall -> NavigationManager.display(ActivityWrapper.NAV_VIDEO_CALL)
        }

        return true
    }

    override fun onBackPressed() {
        NavigationManager.onBackPressed()
    }
}