package com.revature.roommaintenanceprototype;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.revature.roommaintenanceprototype.database.MaintenanceDatabase;
import com.revature.roommaintenanceprototype.database.MaintenanceDatabase_Impl;

public class TrainerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    NavController navController;

    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigationView_main);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.menu_trainer);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_main);

        addOpenCloseToggleActionToToolbar();

        navController = Navigation.findNavController(this, R.id.fragment_mainContentContainer);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);

        navigationView.setNavigationItemSelectedListener(this);
    }

    public void addOpenCloseToggleActionToToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menuItem_trainer_verify:
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.verifyNavFragment);
                break;
            case R.id.menuItem_trainer_delegate:
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.delegateNavFragment);
                break;
            case R.id.menuItem_trainer_reports:
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.reportsTrainerNavFragment);
                break;
            case R.id.menuItem_trainer_logout:
                finish();
                break;
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
