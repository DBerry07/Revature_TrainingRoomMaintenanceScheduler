package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.RoomTable;

import java.util.List;

@Dao
public interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RoomTable room);

    @Query("SELECT * FROM RoomTable")
    LiveData<List<RoomTable>> selectAll();

    @Query("SELECT * FROM RoomTable WHERE id = :id")
    LiveData<List<RoomTable>> select(int id);

    @Query("SELECT * FROM RoomTable WHERE name = :name")
    LiveData<List<RoomTable>> selectOnName(String name);

    @Query("SELECT * FROM RoomTable WHERE locationId = :locationId")
    LiveData<List<RoomTable>> selectOnLocationId(int locationId);

    @Query("SELECT * FROM RoomTable WHERE campusId = :campusId")
    LiveData<List<RoomTable>> selectOnCampusId(int campusId);

    @Query("SELECT * FROM RoomTable WHERE assignedTo = :roomCalendarId")
    LiveData<List<RoomTable>> selectOnAssignedTo(int roomCalendarId);

}
