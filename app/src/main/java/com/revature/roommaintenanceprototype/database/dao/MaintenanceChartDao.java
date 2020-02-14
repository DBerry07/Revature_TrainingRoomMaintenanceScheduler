package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.MaintenanceChart;

import java.util.List;

@Dao
public interface MaintenanceChartDao {

    @Query("SELECT * FROM MaintenanceChart")
    LiveData<List<MaintenanceChart>> selectAll();

    @Query("SELECT * FROM MaintenanceChart WHERE id = :id")
    LiveData<List<MaintenanceChart>> select(int id);

    @Query("SELECT * FROM MaintenanceChart WHERE roomId = :roomId")
    LiveData<List<MaintenanceChart>> selectOnRoomId(int roomId);

    @Query("SELECT * FROM MaintenanceChart WHERE inspectedBy = :userId")
    LiveData<List<MaintenanceChart>> selectOnInspectedBy(int userId);

    @Query("SELECT * FROM MaintenanceChart WHERE roomId = :roomId AND inspectedBy = :inspectedBy")
    LiveData<List<MaintenanceChart>> selectOnRoomAndInspected(int roomId, int inspectedBy);

}
