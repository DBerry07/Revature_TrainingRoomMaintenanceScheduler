package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.revature.roommaintenanceprototype.database.table.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class TrainerAPI {

    String trainerURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllTrainers";

    public void getTrainers(final Activity activity, final View rootView, final NavController navController, final int navId) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);

        String url = trainerURL;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<User> list = JsonResponseParser.parseTrainers(response);
                        new TrainerUpdater().updateTrainerList(list, rootView, navController, navId);
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
