package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.revature.roommaintenanceprototype.database.table.CompletedTaskList;
import com.revature.roommaintenanceprototype.database.table.RoomData;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class SendAPI {

    static RequestQueue requestQueue;

    public SendAPI(Activity activity){
        requestQueue = Volley.newRequestQueue(activity);
    }

    public void sendTrainerVerify(int image, CompletedTaskList completedTaskList, final Activity activity){
        String url = "https://private-ccda8-maintenanceapi1.apiary-mock.com/sendCompletedTasks";
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            jsonObject.put("image", 1001010101);
            for (int i = 0; i < 3; i++) {
                JSONObject obj = new JSONObject();
                obj.put("maintenanceChartId", i);
                obj.put("taskId", i);
                obj.put("taskCompleted", true);
                jsonArray.put(obj);
            }
            jsonObject.put("completedTasks", jsonArray);
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
                        try {
                            Toast.makeText(activity, response.get("message").toString(), Toast.LENGTH_LONG);
                        } catch (JSONException e) {
                            Log.d("DEBUG", "JSON Exception: " + e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("DEBUG ERROR", error.toString());
                    }
                });
        requestQueue.add(jsonObjectRequest);

    }

    public void sendTrainerDelegate(final Activity activity, int userId, int roomId, String dateStart, String dateEnd){

        String url = "https://private-ccda8-maintenanceapi1.apiary-mock.com/sendDelegate";
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            for (int i = 0; i < 1; i++) {
                JSONObject obj = new JSONObject();
                obj.put("userId", i);
                obj.put("roomId", i);
                obj.put("dateStart", "1-1-2000");
                obj.put("dateEnd", "2-1-2000");
                jsonArray.put(obj);
            }
            jsonObject.put("delegate", jsonArray);
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
                        try {
                            Toast.makeText(activity, response.get("message").toString(), Toast.LENGTH_LONG);
                        } catch (JSONException e) {
                            Log.d("DEBUG", "JSON Exception: " + e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("DEBUG ERROR", error.toString());
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }

    public void sendScheduleTask(final Activity activity,
                                 int campusId, int roomId, int userId,
                                 String dateStart, String dateEnd,
                                 List<RoomTaskList> roomTaskLists){
        String url = "https://private-ccda8-maintenanceapi1.apiary-mock.com/sendScheduleTask";
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            jsonObject.put("campusId", 0);
            jsonObject.put("roomId", 0);
            jsonObject.put("userId", 0);
            jsonObject.put("dateStart", "1-1-2000");
            jsonObject.put("dateEnd", "2-2-2000");
            for (int i = 0; i < 3; i++) {
                JSONObject obj = new JSONObject();
                obj.put("roomId", 0);
                obj.put("taskId", i);
                obj.put("dateStart", "1-1-2000");
                obj.put("dateEnd", "2-2-2000");
                jsonArray.put(obj);
            }
            jsonObject.put("roomTasks", jsonArray);
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
                        try {
                            Toast.makeText(activity, response.get("message").toString(), Toast.LENGTH_LONG);
                        } catch (JSONException e) {
                            Log.d("DEBUG", "JSON Exception: " + e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("DEBUG ERROR", error.toString());
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }

}
