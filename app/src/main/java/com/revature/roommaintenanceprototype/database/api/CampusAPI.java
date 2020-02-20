package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.database.table.Campus;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CampusAPI {

    private interface VolleyCallback<T>{
        void onSuccess(List<T> result);
    }

    static String campusURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllCampus";
    List<Campus> list;

    public void getCampuses(final Activity activity, final SimpleStringAdapter adapter, final RecyclerView recyclerView) {
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
                        list = JsonResponseParser.parseCampuses(response);
                        ArrayList<String> names = new ArrayList<>();
                        for (Campus each : list){
                            names.add(each.getName());
                        }

                        adapter.updateList(names);
                        recyclerView.setAdapter(adapter);
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
