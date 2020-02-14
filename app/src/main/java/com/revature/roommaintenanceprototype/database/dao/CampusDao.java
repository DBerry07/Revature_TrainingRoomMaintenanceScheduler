package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.Campus;

import java.util.List;

@Dao
public interface CampusDao {

    @Query("SELECT * FROM Campus")
    LiveData<List<Campus>> selectAll();

    @Query("SELECT * FROM Campus WHERE id = :id")
    LiveData<List<Campus>> select(int id);

    @Query("SELECT * FROM Campus WHERE name = :name")
    LiveData<List<Campus>> selectOnName(String name);

}
