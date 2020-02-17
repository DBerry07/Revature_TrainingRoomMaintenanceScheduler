package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.CampusDao;
import com.revature.roommaintenanceprototype.database.table.Campus;

import java.util.List;

public class CampusRepository {

    private CampusDao dao;
    private static LiveData<List<Campus>> list;

    public CampusRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.campusDao();
        list = dao.selectAll();
    }

    public static LiveData<List<Campus>> getAll(){
        return list;
    }

}
