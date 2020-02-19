package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.LocationDao;
import com.revature.roommaintenanceprototype.database.table.Location;

import java.util.List;

public class LocationRepository {

    private LocationDao dao;
    private static LiveData<List<Location>> list;

    public LocationRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.locationDao();
        list = dao.selectAll();
    }

    public static LiveData<List<Location>> getAll(){
        return list;
    }

}
