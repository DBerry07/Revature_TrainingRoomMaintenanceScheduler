package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.MaintenanceChart;

import java.util.List;

public interface MaintenanceChartDao {

    @Query("SELECT * FROM MaintenanceChart")
    LiveData<List<MaintenanceChart>> selectAll();

    @Query("SELECT * FROM MaintenanceChart WHERE id = :id")
    LiveData<MaintenanceChart> select(int id);
}
