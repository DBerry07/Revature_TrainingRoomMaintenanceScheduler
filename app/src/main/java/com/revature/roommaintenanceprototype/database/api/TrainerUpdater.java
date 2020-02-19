package com.revature.roommaintenanceprototype.database.api;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;
import com.revature.roommaintenanceprototype.database.table.Task;
import com.revature.roommaintenanceprototype.database.table.User;

import java.util.ArrayList;
import java.util.List;

public class TrainerUpdater {

    public static void updateTrainerList(List<User> list, View rootView){
        List<String> emails = new ArrayList<>();
        for (User each : list){
            emails.add(each.getEmail());
        }
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.trainer_selection_recycler);
        recyclerView.setAdapter(new SimpleStringAdapter((ArrayList<String>) emails));
    }

}
