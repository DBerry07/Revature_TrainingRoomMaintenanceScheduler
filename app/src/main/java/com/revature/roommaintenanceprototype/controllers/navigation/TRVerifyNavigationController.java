package com.revature.roommaintenanceprototype.controllers.navigation;

import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

public class TRVerifyNavigationController implements BottomNavigationView.OnNavigationItemSelectedListener{
    private static final String DEBUG_TAG = "TRVerifyNavigationController";

    private NavController navController;

    private TRVerifyNavigationController(){}

    public TRVerifyNavigationController(NavController navController){
        this.navController = navController;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuItem_tr_verify_room:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.TR_Verify_RoomSelectionFragment2);
                break;
            case R.id.menuItem_tr_verify_criteria:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.TR_Verify_CriteriaSelectionFragment2);
                break;
            case R.id.menuItem_tr_verify_signature:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.TR_Verify_SignatureFragment2);
                break;
        }
        return true;
    }
}
