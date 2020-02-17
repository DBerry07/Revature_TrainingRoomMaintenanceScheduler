package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.MaintenanceChart;

import java.util.List;

@Dao
public interface MaintenanceChartDao {

    @Query("SELECT * FROM MAINTENANCECHART")
    LiveData<List<MaintenanceChart>> selectAll();
}
