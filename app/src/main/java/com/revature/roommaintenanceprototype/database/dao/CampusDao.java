package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.Campus;

import java.util.List;

public interface CampusDao {

    @Query("SELECT * FROM Campus")
    LiveData<List<Campus>> selectAll();

    @Query("SELECT * FROM Campus WHERE id = :id")
    LiveData<Campus> select(int id);

}
