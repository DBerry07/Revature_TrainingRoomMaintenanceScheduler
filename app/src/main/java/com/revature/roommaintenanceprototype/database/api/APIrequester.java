package com.revature.roommaintenanceprototype.database.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.table.Campus;

public class APIrequester {

    static RequestQueue requestQueue;
    static Activity myActivity;
    static MDatabase db;

    static String loginURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/login";
    static String campusURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllCampus";

    public static void requestLogin(Activity activity, String username, String email){
        myActivity = activity;
        requestQueue = Volley.newRequestQueue(myActivity);
        db = MDatabase.getDatabase(myActivity);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("user_email", "test@revature.com");
            jsonObject.put("user_password", "pass");
        } catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                loginURL,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("DEBUG", response.get("message").toString());
                            Log.d("DEBUG", response.get("validate").toString());
                        } catch (JSONException e){
                            e.printStackTrace();
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

    public static void populateDatabase(Activity activity){
        requestCampuses(activity);
    }

    public static void requestCampuses(Activity activity){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
        } catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                campusURL,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            parseCampusResponse(response);
                        } catch (JSONException e){
                            e.printStackTrace();
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

    public static void parseCampusResponse(JSONObject response) throws JSONException{
        JSONArray jsonArray = null;
        jsonArray = response.getJSONArray("campuses");
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Campus item = new Campus(jsonObject.getInt("id"), jsonObject.getString("name"));
            db.campusDao().insert(item);
        }
    }


}
