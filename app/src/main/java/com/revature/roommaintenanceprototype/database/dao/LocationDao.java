package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.Location;

import java.util.List;

@Dao
public interface LocationDao {

    @Query("SELECT * FROM Location")
    LiveData<List<Location>> selectAll();

}
