package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.MaintenanceChartDao;
import com.revature.roommaintenanceprototype.database.table.MaintenanceChart;

import java.util.List;

public class MaintenanceChartRepository {

    private MaintenanceChartDao dao;
    private static LiveData<List<MaintenanceChart>> list;

    public MaintenanceChartRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.maintenanceChartDao();
        list = dao.selectAll();
    }

    public static LiveData<List<MaintenanceChart>> getAll(){
        return list;
    }
}
