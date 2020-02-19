package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.database.table.Campus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CampusUpdater {

    public static void updateSiteManagerCampus(List<Campus> list, View rootView){
        List<String> names = new ArrayList<>();
        for (Campus each : list) {
            names.add(each.getName());
            Log.d("JSON", names.toString());
        }

        RecyclerView rvCampusSelection = (RecyclerView) rootView.findViewById(R.id.rv_campusSelection);
        rvCampusSelection.setAdapter(new SimpleStringAdapter( (ArrayList<String>) names));

    }
}
