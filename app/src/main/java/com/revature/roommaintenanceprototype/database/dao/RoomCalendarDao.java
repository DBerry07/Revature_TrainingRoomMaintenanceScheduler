package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.RoomCalendar;

import java.util.List;

@Dao
public interface RoomCalendarDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RoomCalendar item);

    @Query("SELECT * FROM RoomCalendar")
    LiveData<List<RoomCalendar>> selectAll();

}
