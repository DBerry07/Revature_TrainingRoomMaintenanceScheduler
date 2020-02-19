package com.revature.roommaintenanceprototype.database.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.table.Campus;
import com.revature.roommaintenanceprototype.database.api.JsonResponseParser;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;
import com.revature.roommaintenanceprototype.database.table.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class UserAPI {

    static RequestQueue requestQueue;
    static Activity myActivity;
    static MDatabase db;
    static JSONObject mResponse;
    static List<Task> tasks;
    static boolean wait;
    static List<Task> taskList;

    static String loginURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/login";
    static String userURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllUsers";

    public static void requestLogin(final Activity activity, String username, String email) {
        myActivity = activity;
        requestQueue = Volley.newRequestQueue(myActivity);
        mResponse = null;

        //db = MDatabase.getDatabase(myActivity);
        RequestFuture<JSONObject> future = RequestFuture.newFuture();

        String url = loginURL;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("user_email", "test@revature.com");
            jsonObject.put("user_password", "pass");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JsonResponseParser.parseValidateUser(response, myActivity);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("JsonERROR", error.toString());
                    }
                });

        /*requestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>(){
            @Override
            public void onRequestFinished(Request<Object> request) {
                JsonResponseParser.parseValidateUser(mResponse, myActivity);
                requestQueue.removeRequestFinishedListener(this);
            }
        });*/
        requestQueue.add(jsonObjectRequest);

    }

}
