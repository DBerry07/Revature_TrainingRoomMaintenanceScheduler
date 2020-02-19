package com.revature.roommaintenanceprototype.util.fragmenthelpers;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.ReportsAdapter;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;

public class FragmentHelper {

    public static void updateToolbarTitle(final AppCompatActivity activity, String title) {
        if (activity != null) {
            Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
            if (toolbar != null) {
                toolbar.setTitle(title);
            } else {
                ScreenMessage.toastShortMsg(activity.getApplicationContext(), "Error setting toolbar title");
            }
        } else {
            ScreenMessage.toastShortMsg(activity.getApplicationContext(), "Error cannot set title of null activity");
        }
    }

    public static RecyclerView initRecyclerView(View rootView, int recyclerID, Activity activity, RecyclerView.Adapter recyclerAdapter) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(recyclerID);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        return  recyclerView;
    }

    public static void navigateBetweenFragments(NavController navController, Bundle bundle, int actionID){
        if(bundle != null){
            navController.navigate(actionID, bundle);
        }else{
            navController.navigate(actionID);
        }
    }
}
