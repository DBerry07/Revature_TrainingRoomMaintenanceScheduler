package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.database.table.RoomData;

import java.util.ArrayList;
import java.util.List;

public class RoomUpdater {
    public static void updateRoomList(List<RoomData> list, Activity activity, View rootView) {
        List<String> names = new ArrayList<>();

        for (RoomData each : list) {
            names.add(each.getName());
        }

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.room_selection_recycler);
        recyclerView.setAdapter(new SimpleStringAdapter((ArrayList<String>) names));
    }

}
