package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;
import com.revature.roommaintenanceprototype.database.table.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class TaskAPI {

    static List<Task> taskList;
    static String tasksAllURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllTasks";
    static String tasksByRoomURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchRoomTaskList";
    RequestQueue requestQueue;

    public TaskAPI(Activity activity){
        requestQueue = Volley.newRequestQueue(activity);
        getAllTasks();
    }

    public void getAllTasks(){
        String url = tasksAllURL;
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
        } catch (JSONException e){
            e.printStackTrace();
        }

        final Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                taskList = JsonResponseParser.parseTasks(response);
            }
        };
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject,
                listener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("DEBUG ERROR", error.toString());
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    public void siteManagerGetTasks(final Activity activity, final View rootView){
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        String url = tasksAllURL;
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
        } catch (JSONException e){
            e.printStackTrace();
        }

        final Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                taskList = JsonResponseParser.parseTasks(response);
                //TaskUpdater.changeSMCriteriaList(taskList, rootView);
            }
        };
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject,
                listener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("DEBUG ERROR", error.toString());
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    public void trainerGetTasks(int roomId, final Activity activity, final View rootView){
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        String url = tasksByRoomURL;
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            jsonObject.put("roomId", "0");
        } catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<RoomTaskList> rList = JsonResponseParser.parseTaskList(response);
                        //TaskUpdater.updateTRCriteriaList(rList, taskList, rootView);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("DEBUG ERROR", error.toString());
                    }
                });
        requestQueue.add(jsonObjectRequest);
        //return mResponse;
    }
}
