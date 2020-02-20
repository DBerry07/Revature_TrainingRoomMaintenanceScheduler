package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.SiteManagerActivity;
import com.revature.roommaintenanceprototype.TrainerActivity;
import com.revature.roommaintenanceprototype.adapters.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.database.table.Campus;
import com.revature.roommaintenanceprototype.database.table.RoomData;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;
import com.revature.roommaintenanceprototype.database.table.Task;
import com.revature.roommaintenanceprototype.database.table.User;
import com.revature.roommaintenanceprototype.util.DummyText;

public class JsonResponseParser {

    public static void parseValidateUser(JSONObject response, Activity activity){
        Log.d("DEBUG", "Inside parser");
        String validate = "";
        String message = "";
        int userId = 99;
        int userRole = 99;
        Log.d("RESPONSE", response.toString());
        try {
            validate = response.getString("validate");
            message = response.getString("message");
            userId = response.getInt("userId");
            userRole = response.getInt("userRole");
        } catch (JSONException e){
            Log.d("DEBUG", e.toString());
        }
        if (validate.equals("true")){
            Log.d("MESSAGE", message);
            int i = activity.getIntent().getIntExtra("userRole", 123);
            Log.d("UserRole", Integer.toString(i));
            i = activity.getIntent().getIntExtra("userId", 123);
            Log.d("UserId", Integer.toString(i));
        }

        Intent intent;

        if( userRole == 1 ){
            intent = new Intent(activity.getApplicationContext(), TrainerActivity.class);
            intent.putExtra("userId", userId);
            intent.putExtra("userRole", userRole);
        }else{
            intent = new Intent(activity.getApplicationContext(), SiteManagerActivity.class);
            intent.putExtra("userId", userId);
            intent.putExtra("userRole", userRole);
        }
        activity.startActivity(intent);
    }

    public static List<Campus> parseCampuses(JSONObject response){
        List<Campus> campuses = new ArrayList<Campus>();
        JSONArray jsonArray = null;
        try {
            jsonArray = response.getJSONArray("campuses");
            Log.d("JSON", "Got initial array");
        } catch (JSONException e){
            e.printStackTrace();
        }

        for (int i = 0; i < jsonArray.length(); i++){
            try {
                JSONObject entry = jsonArray.getJSONObject(i);
                Campus c = new Campus(entry.getInt("id"), entry.getString("name"));
                campuses.add(c);
                Log.d("JSON", "Added campus to list");
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return campuses;
    }

    public static List<RoomData> parseRooms(JSONObject response){
        List<RoomData> list = new ArrayList<>();
        JSONArray jsonArray = null;
        try {
            jsonArray = response.getJSONArray("rooms");
            Log.d("JSON", "Got initial array");
        } catch (JSONException e){
            e.printStackTrace();
        }

        for (int i = 0; i < jsonArray.length(); i++){
            try {
                JSONObject entry = jsonArray.getJSONObject(i);
                RoomData c = new RoomData(entry.getInt("id"), entry.getString("name"), entry.getInt("locationId"), entry.getInt("campusId"), entry.getInt("assignedTo"));
                list.add(c);
                Log.d("JSON", "Added room to list");
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<RoomTaskList> parseTaskList(JSONObject response){
        List<RoomTaskList> list = new ArrayList<>();
        JSONArray jsonArray = null;
        try {
            jsonArray = response.getJSONArray("taskLists");
            Log.d("JSON", "Got initial array");
        } catch (JSONException e){
            e.printStackTrace();
        }

        for (int i = 0; i < jsonArray.length(); i++){
            try {
                JSONObject entry = jsonArray.getJSONObject(i);
                RoomTaskList c = new RoomTaskList(entry.getInt("id"), entry.getInt("roomId"), entry.getInt("taskId"), entry.getString("dateStart"), entry.getString("dateEnd"));
                list.add(c);
                Log.d("JSON", "Added taskList to list");
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<Task> parseTasks(JSONObject response) {
        List<Task> list = new ArrayList<>();
        JSONArray jsonArray = null;

        Log.d("Debug JSON", response.toString());
        try {
            jsonArray = response.getJSONArray("tasks");
            Log.d("JSON", "Got initial array");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject entry = jsonArray.getJSONObject(i);
                Task c = new Task(entry.getInt("id"), entry.getString("name"));
                list.add(c);
                Log.d("JSON", "Added task to list");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<User> parseTrainers(JSONObject response){
        List<User> list = new ArrayList<>();
        JSONArray jsonArray = null;

        Log.d("Debug JSON", response.toString());
        try {
            jsonArray = response.getJSONArray("trainers");
            Log.d("JSON", "Got initial array");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject entry = jsonArray.getJSONObject(i);
                User c = new User(entry.getInt("id"), entry.getInt("userRole"), entry.getString("email"));
                list.add(c);
                Log.d("JSON", "Added task to list");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
