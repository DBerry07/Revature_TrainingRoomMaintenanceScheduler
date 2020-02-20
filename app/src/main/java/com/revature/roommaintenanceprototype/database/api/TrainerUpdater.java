package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.view.View;

import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRDelegatePersistance;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;
import com.revature.roommaintenanceprototype.database.table.Task;
import com.revature.roommaintenanceprototype.database.table.User;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

import java.util.ArrayList;
import java.util.List;

public class TrainerUpdater implements View.OnClickListener, OnItemClickListener {

    NavController navController;
    int navId;

    public void updateTrainerList(List<User> list, View rootView, NavController navController, int navId){
        this.navController =  navController;
        this.navId = navId;

        List<String> emails = new ArrayList<>();
        for (User each : list){
            emails.add(each.getEmail());
        }
        RecyclerView recyclerView = rootView.findViewById(R.id.trainer_selection_recycler);
        recyclerView.setAdapter(new SimpleStringAdapter((ArrayList<String>) emails, this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    public void onItemClick(View view, int position) {
        TRDelegatePersistance.setTrainer( FragmentHelper.getSelectedItem(view) );
        FragmentHelper.navigateBetweenFragments(navController,
                null,
                navId);
    }
}
