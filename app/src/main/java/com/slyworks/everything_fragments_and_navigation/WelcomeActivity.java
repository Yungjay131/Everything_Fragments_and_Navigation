package com.slyworks.everything_fragments_and_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.slyworks.everything_fragments_and_navigation.book.BookWelcomeActivity;
import com.slyworks.everything_fragments_and_navigation.navGraph.NavGraphMainActivity;
import com.slyworks.everything_fragments_and_navigation.navigation.activities.Nav_LoginActivity;
import com.slyworks.everything_fragments_and_navigation.navigation.activities.Nav_WelcomeActivity;

public class WelcomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //region Vars
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initViews();
    }

    private void initViews(){
       drawer = findViewById(R.id.drawer_welcome);
       toolbar = findViewById(R.id.toolBar_welcome);
       navigationView = findViewById(R.id.navigation_welcome);

       toolbar.setTitle("");
       setSupportActionBar(toolbar);

       toggle = new ActionBarDrawerToggle(
               this,
               drawer,
               R.string.navigation_drawer_open,
               R.string.navigation_drawer_close);
       toggle.syncState();

       drawer.addDrawerListener(toggle);

       navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_book:{
                inflateActivity(BookWelcomeActivity.class);
                return true;
            }
            case R.id.action_navigation: {
                inflateActivity(Nav_WelcomeActivity.class);
                return true;
            }
            case R.id.action_nav_graph:{
                inflateActivity(NavGraphMainActivity.class);
                return true;
            }
            default: return true;
        }
    }

    private <T extends AppCompatActivity> void inflateActivity(Class<T> cls){
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}