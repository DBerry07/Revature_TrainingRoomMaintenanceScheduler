/*
package com.revature.roommaintenanceprototype.database.api;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;
import com.revature.roommaintenanceprototype.database.table.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskUpdater {

    public static void changeSMCriteriaList(List<Task> list, View rootView){
        List<String> names = new ArrayList<>();
        for (Task each : list){
            names.add(each.getName());
        }
        RecyclerView rvCleaningCriteria = (RecyclerView) rootView.findViewById(R.id.rv_cleaningCriteria);
        rvCleaningCriteria.setAdapter( new CriteriaAdapter( (ArrayList<String>) names) );
    }

    public static void updateTRCriteriaList(List<RoomTaskList> roomList, List<Task> taskList, View rootView){
        List<String> names = new ArrayList<>();
        for (RoomTaskList each : roomList){
            for (Task task : taskList){
                if (task.getId() == each.getTaskId()){
                    names.add(task.getName());
                    break;
                }
            }
        }

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_cleaningCriteria);
        recyclerView.setAdapter(new CriteriaAdapter((ArrayList<String>) names));
    }
}
*/
