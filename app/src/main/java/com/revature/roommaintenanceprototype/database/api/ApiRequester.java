package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.revature.roommaintenanceprototype.LoginActivity;
import com.revature.roommaintenanceprototype.SiteManagerActivity;
import com.revature.roommaintenanceprototype.TrainerActivity;
import com.revature.roommaintenanceprototype.adapters.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapters.ReportsAdapter;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.controllers.LoginController;
import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.table.Campus;
import com.revature.roommaintenanceprototype.database.table.CompletedTaskList;
import com.revature.roommaintenanceprototype.database.table.Location;
import com.revature.roommaintenanceprototype.database.table.MaintenanceChart;
import com.revature.roommaintenanceprototype.database.table.RoomCalendar;
import com.revature.roommaintenanceprototype.database.table.RoomData;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;
import com.revature.roommaintenanceprototype.database.table.Task;
import com.revature.roommaintenanceprototype.database.table.User;
import com.revature.roommaintenanceprototype.database.table.UserRole;
import com.revature.roommaintenanceprototype.database.view_model.UserViewModel;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.revature.roommaintenanceprototype.LoginActivity.EXTRA_TAG_USER_EMAIL;

public class ApiRequester {

    static String campusURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllCampus";
    static String roomsByCalendarURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchRoomsOnCalendar";
    static String roomsByCampusAndLocationURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllRoom";
    static String trainerURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllTrainers";

    static List<Task> taskList;
    static String tasksAllURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchAllTasks";
    static String tasksByRoomURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/fetchRoomTaskList";
    static String siteManagerReports = "https://private-ccda8-maintenanceapi1.apiary-mock.com/getReportsSiteManager";
    static String trainerReportsURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/getReportsTrainer";
    static String sendTrainerVerifyURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/sendCompletedTasks";
    static String sendSiteManagerScheduleURL = "https://private-ccda8-maintenanceapi1.apiary-mock.com/sendScheduleTask";

    static String getAllUsersURL = "https://private-4a399-revaturemaintenance.apiary-mock.com/users";

    static MDatabase db;

    static List<User> users = null;


    static ApiRequester apiRequester = null;
    static RequestQueue requestQueue;

    public static ApiRequester getInstance(Activity activity)
    {
        if (apiRequester == null) { apiRequester = new ApiRequester(); }
        requestQueue = Volley.newRequestQueue(activity);
        getAllTasks();
        db = MDatabase.getDatabase(activity);
        return apiRequester;

    }

    /*public void getAllCampus(){
        String url = "";
        JSONObject request = new JSONObject();

        try {
            request.put("token", "ABC123");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                request,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<Campus> list = JsonResponseParser.parseCampus(response);
                        for (Campus each : list ){
                            db.campusDao().insert(each);
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
    }*/

    /*public void getAllUserRoles(){
        String url = "";
        JSONObject request = new JSONObject();

        try {
            request.put("token", "ABC123");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                request,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<UserRole> list = JsonResponseParser.parseUserRoles(response);
                        for (UserRole each : list ){
                            db.userRoleDao().insert(each);
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

    public void getAllCompletedTaskList(){
        String url = "";
        JSONObject request = new JSONObject();

        try {
            request.put("token", "ABC123");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                request,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<CompletedTaskList> list = JsonResponseParser.parseCompletedTaskList(response);
                        for (CompletedTaskList each : list ){
                            db.completedTaskListDao().insert(each);
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
    }*/

    public static List<User> getUsers(final ComponentActivity activity, final String email, final String password){
        JSONObject request = new JSONObject();
        String url = getAllUsersURL;

        try {
            request.put("token", "ABC123");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                request,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<User> list = JsonResponseParser.parseUsers(response);
                        if( LoginController.testLoginCredentials(email, password, list) ){
                            for (User each : list) {
                                if (each.getEmail().equals(email) && each.getUserRole() == 1) {
                                    launchSiteManagerActivity(activity, email);
                                    break;
                                } else if (each.getEmail().equals(email) && each.getUserRole() == 0) {
                                    launchTrainerActivity(activity, email);
                                    break;
                                }
                            }
                        }else {
                            ScreenMessage.toastLongMsg(activity, "Invalid login credentials.");
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
        return users;
    }

    private static void launchSiteManagerActivity(Activity activity, String email){
        Intent intent = new Intent( activity, SiteManagerActivity.class );
        intent.putExtra(EXTRA_TAG_USER_EMAIL,email);
        activity.startActivity(intent);
    }

    private static void launchTrainerActivity(Activity activity, String email){
        Intent intent = new Intent( activity, TrainerActivity.class );
        intent.putExtra(EXTRA_TAG_USER_EMAIL,email);
        activity.startActivity(intent);
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
                //taskList = JsonResponseParser.parseTasks(response);
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
                /*List<Task> tList = JsonResponseParser.parseTasks(response);
                ArrayList<String> names = new ArrayList<>();
                for (Task each : tList){
                    names.add(each.getName());
                }
                adapter.updateList(names);
                recyclerView.setAdapter(adapter);*/
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
                            names.add(each.getUsername());
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
        String url = siteManagerReports;
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
                        Map<String, Boolean> list = JsonResponseParser.parseReports(response);
                        adapter.updateList(list);
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

    public static void getSiteManagerReportsByDate(final Activity activity,
                                             final ReportsAdapter adapter,
                                             final RecyclerView recyclerView,
                                                   final String dateStart, final String dateEnd){
        String url = siteManagerReports;
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            jsonObject.put("dateStart", dateStart);
            jsonObject.put("dateEnd", dateEnd);
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
                        Map<String, Boolean> list = JsonResponseParser.parseReports(response);
                        adapter.updateList(list);
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

    public static void getTrainerReports(final Activity activity,
                                             final ReportsAdapter adapter,
                                             final RecyclerView recyclerView,
                                                int userId){
        String url = trainerReportsURL;
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
                        Map<String, Boolean> list = JsonResponseParser.parseReports(response);
                        adapter.updateList(list);
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

    public static void getTrainerReportsByDate(final Activity activity,
                                         final ReportsAdapter adapter,
                                         final RecyclerView recyclerView,
                                            int userId, String dateStart, String dateEnd){
        String url = trainerReportsURL;
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            jsonObject.put("userId", userId);
            jsonObject.put("dateStart", dateStart);
            jsonObject.put("dateEnd", dateEnd);
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
                        Map<String, Boolean> list = JsonResponseParser.parseReports(response);
                        adapter.updateList(list);
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

    public static void sendTrainerVerify(final Activity activity,
                                         String image,
                                         List<CompletedTaskList> tasksCompleted){
        String url = sendTrainerVerifyURL;
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            jsonObject.put("image", image);
            for (CompletedTaskList each : tasksCompleted){
                JSONObject task = new JSONObject();
                task.put("id", each.getId());
                task.put("maintenanceChartId", each.getMaintenanceChartId());
                task.put("taskId", each.getTaskId());
                task.put("taskCompleted", each.getTaskCompleted());
                jsonArray.put(task);
            }
            jsonObject.put("completedTasks", jsonArray);
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
                        Toast.makeText(activity, "Task Verification submitted successfully!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("DEBUG ERROR", error.toString());
                    }
                });

        requestQueue.add(jsonObjectRequest);
        Toast.makeText(activity, "Submitting...", Toast.LENGTH_SHORT).show();
    }

    public static void sendSiteManagerSchedule(final Activity activity,
                                         int campusId, int roomId, int userId,
                                         String dateStart, String dateEnd,
                                               List<RoomTaskList> roomTaskListList){
        String url = sendSiteManagerScheduleURL;
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try {
            jsonObject.put("username", "test@revature.com");
            jsonObject.put("token", "ABC123");
            jsonObject.put("campusId", campusId);
            jsonObject.put("userId", userId);
            for (RoomTaskList each : roomTaskListList){
                JSONObject task = new JSONObject();
                task.put("id", each.getId());
                task.put("roomId", each.getRoomId());
                task.put("taskId", each.getTaskId());
                task.put("dateStart", each.getDateStart());
                task.put("dateEnd", each.getDateEnd());
                jsonArray.put(task);
            }
            jsonObject.put("completedTasks", jsonArray);
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
                        Toast.makeText(activity, "Room Maintenance scheduled successfully!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("DEBUG ERROR", error.toString());
                    }
                });

        requestQueue.add(jsonObjectRequest);
        Toast.makeText(activity, "Submitting...", Toast.LENGTH_SHORT).show();
    }
}
