package com.revature.roommaintenanceprototype.database.api;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.toolbox.RequestFuture;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class GetFuture extends AsyncTask<RequestFuture<JSONObject>, Void, JSONObject> {

    JSONObject jsonObject;
    Activity myActivity;

    public void getActivity(Activity activity){
        this.myActivity = activity;
    }

    protected JSONObject doInBackground(RequestFuture<JSONObject>... futures) {
        Log.d("DEBUG", "In async Task");
        for (RequestFuture<JSONObject> each : futures) {
            try {
                jsonObject = each.get();
            } catch (ExecutionException e) {
                Log.d("DEBUG", e.toString());
            } catch (InterruptedException e) {
                Log.d("DEBUG", e.toString());
            }
            Log.d("DEBUG", "Got Response");
            JsonResponseParser.parseValidateUser(jsonObject, myActivity);
            Log.d("DEBUG", "Parser done");
        }
        return jsonObject;
    }

}
