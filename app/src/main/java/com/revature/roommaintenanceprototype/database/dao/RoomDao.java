package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.RoomData;

import java.util.List;

@Dao
public interface RoomDao {

    @Query("SELECT * FROM RoomData")
    LiveData<List<RoomData>> selectAll();

}
