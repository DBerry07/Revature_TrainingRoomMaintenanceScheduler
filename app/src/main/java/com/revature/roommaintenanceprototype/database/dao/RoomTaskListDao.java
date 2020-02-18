package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.RoomTaskList;

import java.util.List;

@Dao
public interface RoomTaskListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RoomTaskList item);

    @Query("SELECT * FROM RoomTaskList")
    LiveData<List<RoomTaskList>> selectAll();

}
