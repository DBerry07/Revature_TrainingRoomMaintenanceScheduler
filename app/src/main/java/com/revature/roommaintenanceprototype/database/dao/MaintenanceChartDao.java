package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.MaintenanceChart;

import java.util.List;

@Dao
public interface MaintenanceChartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MaintenanceChart item);

    @Query("SELECT * FROM MAINTENANCECHART")
    LiveData<List<MaintenanceChart>> selectAll();
}
