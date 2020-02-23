package com.revature.roommaintenanceprototype;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.revature.roommaintenanceprototype.controllers.navigation.SMScheduleNavigationController;
import com.revature.roommaintenanceprototype.controllers.navigation.TRDelegateNavigationController;
import com.revature.roommaintenanceprototype.controllers.navigation.TRVerifyNavigationController;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRDelegatePersistance;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRVerifyPersistance;
import com.revature.roommaintenanceprototype.util.MainActivityHelper;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

public class TrainerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    NavController navController;
    BottomNavigationView bottomNavigationView;

    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    ImageView imgHoverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //APIrequester.populateDatabase(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigationView_main);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.menu_trainer);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_main);

        setSupportActionBar(toolbar);

        navController = Navigation.findNavController(this, R.id.fragment_mainContentContainer);
        navController.setGraph(R.navigation.tr_verify);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.getMenu().clear();
        bottomNavigationView.inflateMenu(R.menu.menu_tr_verify);
        bottomNavigationView.setOnNavigationItemSelectedListener(new TRVerifyNavigationController(navController));

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        setUserDetails();
        imgHoverButton = findViewById(R.id.img_hover_btn);
        imgHoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ScreenMessage.displayResults(TRVerifyPersistance.getResults(), TrainerActivity.this);
                Log.d("RESULTS",TRVerifyPersistance.getResults());
            }
        });
    }

    private void setUserDetails(){
        Intent intent = getIntent();
        if( intent != null ){
            String userEmail = intent.getStringExtra( LoginActivity.EXTRA_TAG_USER_EMAIL );
            MainActivityHelper.setDrawerUserDetails(navigationView,userEmail);
        }else{
            Log.d("TESTING NAVDisplay","null intent");
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menuItem_trainer_verify:
                navController.setGraph(R.navigation.tr_verify);
                NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.TR_Verify_RoomSelectionFragment2);
                bottomNavigationView.getMenu().clear();
                bottomNavigationView.inflateMenu(R.menu.menu_tr_verify);
                bottomNavigationView.setVisibility(View.VISIBLE);
                bottomNavigationView.setOnNavigationItemSelectedListener(new TRVerifyNavigationController(navController));
                imgHoverButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //ScreenMessage.displayResults(TRVerifyPersistance.getResults(), TrainerActivity.this);
                        Log.d("RESULTS",TRVerifyPersistance.getResults());
                    }
                });
                break;
            case R.id.menuItem_trainer_delegate:
                navController.setGraph(R.navigation.tr_delegate);
                NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.TR_Delegate_TrainerSelectionFragment);
                bottomNavigationView.getMenu().clear();
                bottomNavigationView.inflateMenu(R.menu.menu_tr_delegate);
                bottomNavigationView.setVisibility(View.VISIBLE);
                bottomNavigationView.setOnNavigationItemSelectedListener(new TRDelegateNavigationController(navController));
                imgHoverButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("RESULTS", TRDelegatePersistance.getResults());
                    }
                });
                break;
            case R.id.menuItem_trainer_reports:
                bottomNavigationView.setVisibility(View.INVISIBLE);
                navController.setGraph(R.navigation.tr_reports);
                NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
                Navigation.findNavController(this,R.id.fragment_mainContentContainer).navigate(R.id.TR_Reports_DateFragment);
                break;
            case R.id.menuItem_trainer_logout:
                bottomNavigationView.setVisibility(View.INVISIBLE);
                ScreenMessage.confirmLogOut(this);
                break;
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,drawerLayout);
    }
}
