package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.Location;

import java.util.List;

@Dao
public interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Location item);

    @Query("SELECT * FROM Location")
    LiveData<List<Location>> selectAll();

}
