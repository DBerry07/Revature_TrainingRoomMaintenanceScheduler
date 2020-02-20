package com.revature.roommaintenanceprototype.util;

import android.util.Log;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.revature.roommaintenanceprototype.R;

public class MainActivityHelper {
    private static final String DEBUG_TAG = "MainActivityHelper";

    public static void setDrawerUserDetails(NavigationView navigationView, String userEmail){
        TextView textView = navigationView.getHeaderView(0).findViewById(R.id.tv_nav_username);
        if( textView != null ){
            textView.setText(userEmail);
        }else{
            Log.d(DEBUG_TAG,"null nav textView");
        }
    }
}
