package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.Location;

import java.util.List;

public interface LocationDao {

    @Query("SELECT * FROM Location")
    LiveData<List<Location>> selectAll();

    @Query("SELECT * FROM Location WHERE id = :id")
    LiveData<Location> select(int id);
}
