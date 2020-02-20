package com.revature.roommaintenanceprototype.controllers.navigation;

import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

public class SMScheduleNavigationController implements BottomNavigationView.OnNavigationItemSelectedListener{
    private static final String DEBUG_TAG = "SMScheduleNavigationController";

    private NavController navController;

    private SMScheduleNavigationController(){}

    public SMScheduleNavigationController(NavController navController){
        this.navController = navController;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuItem_sm_schedule_campus:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.SM_Schedule_CampusSelectionFragment);
                Log.d(DEBUG_TAG,"Campus menu");
                break;
            case R.id.menuItem_sm_schedule_room:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.SM_Schedule_RoomSelectionFragment);
                Log.d(DEBUG_TAG,"Room menu");
                break;
            case R.id.menuItem_sm_schedule_criteria:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.SM_Schedule_CriteriaSelectionFragment);
                Log.d(DEBUG_TAG,"Critera menu");
                break;
            case R.id.menuItem_sm_schedule_trainer:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.SM_Schedule_TrainerSelectionFragment);
                Log.d(DEBUG_TAG,"Trainer menu");
                break;
            case R.id.menuItem_sm_schedule_date:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.SM_Schedule_DelegateDateFragment);
                Log.d(DEBUG_TAG,"Date menu");
                break;
        }
        return true;
    }
}
