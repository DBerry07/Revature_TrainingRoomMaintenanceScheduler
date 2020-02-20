package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRVerifyPersistance;
import com.revature.roommaintenanceprototype.database.table.RoomData;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

import java.util.ArrayList;
import java.util.List;

public class RoomUpdater implements View.OnClickListener, OnItemClickListener {

    NavController navController;
    int navId;

    public void updateRoomList(List<RoomData> list, Activity activity, View rootView, NavController navController, int navId) {
        List<String> names = new ArrayList<>();
        this.navController = navController;
        this.navId = navId;

        for (RoomData each : list) {
            names.add(each.getName());
        }

        RecyclerView recyclerView = FragmentHelper.initRecyclerView(rootView, R.id.rv_room_selection, activity,
                new SimpleStringAdapter((ArrayList<String>) names , this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        TRVerifyPersistance.setRoom( FragmentHelper.getSelectedItem(view) );
        FragmentHelper.navigateBetweenFragments(navController,
                null, navId);
    }

}
