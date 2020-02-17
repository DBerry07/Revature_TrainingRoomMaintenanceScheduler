package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.Campus;

import java.util.List;

@Dao
public interface CampusDao {

    @Query("SELECT * FROM Campus")
    LiveData<List<Campus>> selectAll();

}
