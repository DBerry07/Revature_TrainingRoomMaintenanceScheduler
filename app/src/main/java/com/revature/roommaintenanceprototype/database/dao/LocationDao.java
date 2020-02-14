package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.Location;

import java.util.List;

@Dao
public interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Location location);

    @Query("SELECT * FROM Location")
    LiveData<List<Location>> selectAll();

    @Query("SELECT * FROM Location WHERE id = :id")
    LiveData<List<Location>> select(int id);

    @Query("SELECT * FROM Location WHERE name = :name")
    LiveData<List<Location>> selectOnName(String name);
}
