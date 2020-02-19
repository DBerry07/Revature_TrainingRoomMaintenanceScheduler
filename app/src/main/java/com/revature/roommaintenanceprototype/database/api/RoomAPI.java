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
import com.revature.roommaintenanceprototype.database.table.RoomData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class RoomAPI {

    static String roomsByCalendarURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchRoomsOnCalendar";
    static String roomsByCampusAndLocationURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllRoom";

    public static void fetchRoomByCalendar(int calendarId, final Activity activity, final View rootView){
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        String url = roomsByCalendarURL;
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            jsonObject.put("campusId", "0");
            jsonObject.put("locationId", "0");
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
                        List<RoomData> list = JsonResponseParser.parseRooms(response);
                        RoomUpdater.updateRoomList(list, activity, rootView);
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

    public static void getRoomByCampusAndLocation(int campusId, int locationId, final Activity activity, final View rootView){
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        String url = roomsByCampusAndLocationURL;
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            jsonObject.put("calendarId", "0");
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
                        List<RoomData> list = JsonResponseParser.parseRooms(response);
                        RoomUpdater.updateRoomList(list, activity, rootView);
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
