package com.revature.roommaintenanceprototype.controllers.navigation;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

public class TRDelegateNavigationController implements BottomNavigationView.OnNavigationItemSelectedListener{
    private static final String DEBUG_TAG = "TRVerifyNavigationController";

    private NavController navController;

    private TRDelegateNavigationController(){}

    public TRDelegateNavigationController(NavController navController){
        this.navController = navController;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuItem_tr_delegate_trainer:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.TR_Delegate_TrainerSelectionFragment);
                break;
            case R.id.menuItem_tr_delegate_room:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.TR_Delegate_RoomSelectionFragment);
                break;
            case R.id.menuItem_tr_delegate_date:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.TR_Delegate_DateFragment);
                break;
            case R.id.menuItem_tr_verify_review:
                break;
        }
        return true;
    }
}
