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
import com.revature.roommaintenanceprototype.database.table.Campus;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class CampusAPI {

    static String campusURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllCampus";

    public static void getCampuses(final Activity activity, final View rootView) {
        RequestQueue requestQueue = Volley.newRequestQueue(activity);

        String url = campusURL;
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
                        List<Campus> list = JsonResponseParser.parseCampuses(response);
                        CampusUpdater.updateSiteManagerCampus(list, rootView);
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
