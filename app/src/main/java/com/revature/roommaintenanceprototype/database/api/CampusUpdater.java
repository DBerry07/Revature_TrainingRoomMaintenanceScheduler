package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.SMSchedulePersistance;
import com.revature.roommaintenanceprototype.database.table.Campus;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CampusUpdater implements View.OnClickListener, OnItemClickListener {

    private NavController navController;
    private int navId;

    public void updateSiteManagerCampus(List<Campus> list, Activity activity,
                                        View rootView, NavController navController, int navId){
        this.navController = navController;
        this.navId = navId;

        List<String> names = new ArrayList<>();
        for (Campus each : list) {
            names.add(each.getName());
            Log.d("JSON", names.toString());
        }

        FragmentHelper.initRecyclerView(rootView, R.id.rv_campusSelection, activity,
                new SimpleStringAdapter((ArrayList<String>) names , this));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        SMSchedulePersistance.setCampus( FragmentHelper.getSelectedItem(view) );
        FragmentHelper.navigateBetweenFragments(navController,
                null, navId);
    }
}
