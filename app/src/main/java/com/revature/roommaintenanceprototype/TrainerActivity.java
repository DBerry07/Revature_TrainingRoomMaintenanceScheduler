package com.revature.roommaintenanceprototype;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

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
import com.revature.roommaintenanceprototype.controller.LogOutController;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import com.revature.roommaintenanceprototype.database.api.APIrequester;

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

        APIrequester.populateDatabase(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigationView_main);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.menu_trainer);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_main);

        addOpenCloseToggleActionToToolbar();

        navController = Navigation.findNavController(this, R.id.fragment_mainContentContainer);
        navController.setGraph(R.navigation.tr_verify);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);

        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        if( intent != null ){
            String userEmail = intent.getStringExtra( LoginActivity.EXTRA_TAG_USER_EMAIL );
            setNavDrawerUserEmail(userEmail);
        }else{
            Log.d("TESTING NAVDisplay","null intent");
        }
    }

    public void addOpenCloseToggleActionToToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menuItem_trainer_verify:
                navController.setGraph(R.navigation.tr_verify);
                NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.TR_Verify_RoomSelectionFragment2);
                break;
            case R.id.menuItem_trainer_delegate:
                navController.setGraph(R.navigation.tr_delegate);
                NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.TR_Delegate_TrainerSelectionFragment);
                break;
            case R.id.menuItem_trainer_reports:
                navController.setGraph(R.navigation.tr_reports);
                NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.TR_Reports_DateFragment);
                break;
            case R.id.menuItem_trainer_logout:
                ScreenMessage.confirmLogOut(this);
                break;
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setNavDrawerUserEmail(String username){

        TextView textView = (TextView)navigationView.getHeaderView(0).findViewById(R.id.tv_nav_username);
        if( textView != null ){
            textView.setText(username);
        }else{
            Log.d("TESTING NAVDisplay","null nav textView");
        }
    }
}
