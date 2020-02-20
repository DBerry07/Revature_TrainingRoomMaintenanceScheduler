package com.revature.roommaintenanceprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.revature.roommaintenanceprototype.util.MainActivityHelper;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

public class SiteManagerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    NavController navController;

    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        navigationView = findViewById(R.id.navigationView_main);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.menu_site_manager);

        drawerLayout = findViewById(R.id.drawerLayout_main);

        addOpenCloseToggleActionToToolbar();

        navController = Navigation.findNavController(this, R.id.fragment_mainContentContainer);
        navController.setGraph(R.navigation.sm_schedule);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);

        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        if( intent != null ){
            String userEmail = intent.getStringExtra( LoginActivity.EXTRA_TAG_USER_EMAIL );
            MainActivityHelper.setDrawerUserDetails(navigationView,userEmail);
        }else{
            Log.d("TESTING NAVDisplay","null intent");
        }
    }

    public void addOpenCloseToggleActionToToolbar(){
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menuItem_siteManager_schedule:
                navController.setGraph(R.navigation.sm_schedule);
                NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.SM_Schedule_CampusSelectionFragment);
                break;
            case R.id.menuItem_siteManager_reports:
                navController.setGraph(R.navigation.sm_reports);
                NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.SM_Reports_DateFragment);
                break;
            case R.id.menuItem_siteManager_logout:
                ScreenMessage.confirmLogOut(this);
                break;
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
