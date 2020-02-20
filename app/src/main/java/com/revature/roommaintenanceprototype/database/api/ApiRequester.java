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
import com.revature.roommaintenanceprototype.adapters.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapters.ReportsAdapter;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.database.table.Campus;
import com.revature.roommaintenanceprototype.database.table.RoomData;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;
import com.revature.roommaintenanceprototype.database.table.Task;
import com.revature.roommaintenanceprototype.database.table.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ApiRequester {

    static String campusURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllCampus";
    static String roomsByCalendarURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchRoomsOnCalendar";
    static String roomsByCampusAndLocationURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllRoom";
    static String trainerURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllTrainers";

    static List<Task> taskList;
    static String tasksAllURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllTasks";
    static String tasksByRoomURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchRoomTaskList";

    static ApiRequester apiRequester = null;
    static RequestQueue requestQueue;

    public static ApiRequester getInstance(Activity activity)
    {
        if (apiRequester == null) { apiRequester = new ApiRequester(); }
        requestQueue = Volley.newRequestQueue(activity);
        getAllTasks();
        return apiRequester;
    }

    public static void getCampuses(final Activity activity, final SimpleStringAdapter adapter, final RecyclerView recyclerView) {
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

    public static void fetchRoomByCalendar(Activity activity, int calendarId,
                                           final SimpleStringAdapter adapter,
                                           final RecyclerView recyclerView){
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
                        ArrayList<String> names = new ArrayList<>();
                        for (RoomData each : list){
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

    public static void getRoomByCampusAndLocation(Activity activity, int campusId, int locationId,
                                                  final SimpleStringAdapter adapter,
                                                  final RecyclerView recyclerView){
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
                        ArrayList<String> names = new ArrayList<>();
                        for (RoomData each : list){
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

    public static void getAllTasks(){
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

    public static void siteManagerGetTasks(final Activity activity,
                                    final CriteriaAdapter adapter,
                                    final RecyclerView recyclerView){
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
                List<Task> tList = JsonResponseParser.parseTasks(response);
                ArrayList<String> names = new ArrayList<>();
                for (Task each : tList){
                    names.add(each.getName());
                }
                adapter.updateList(names);
                recyclerView.setAdapter(adapter);
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

    public static void trainerGetTasks(final int roomId, final Activity activity,
                                final CriteriaAdapter adapter,
                                final RecyclerView recyclerView){
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
                        List<String> names = new ArrayList<>();
                        for (RoomTaskList each : rList){
                            for (Task task : taskList){
                                if (task.getId() == each.getTaskId()){
                                    names.add(task.getName());
                                    break;
                                }
                            }
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

    public static void getTrainers(final Activity activity,
                            final SimpleStringAdapter adapter,
                            final RecyclerView recyclerView) {
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
                        ArrayList<String> names = new ArrayList<>();
                        for (User each : list){
                            names.add(each.getEmail());
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

    public static void getSiteManagerReports(final Activity activity,
                                             final ReportsAdapter adapter,
                                             final RecyclerView recyclerView){
        String url = "";
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
                        ArrayList<String> names = new ArrayList<>();
                        for (User each : list){
                            names.add(each.getEmail());
                        }
                        //adapter.updateList(names);
                        recyclerView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("DEBUG ERROR", error.toString());
                    }
                });
    }

}
