package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.RoomCalendar;

import java.util.Date;
import java.util.List;

@Dao
public interface RoomCalendarDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RoomCalendar roomCalendar);

    @Query("SELECT * FROM RoomCalendar")
    LiveData<List<RoomCalendar>> selectAll();

    @Query("SELECT * FROM RoomCalendar WHERE id = :id")
    LiveData<List<RoomCalendar>> select(int id);

    @Query("SELECT * FROM RoomCalendar WHERE roomId = :roomId")
    LiveData<List<RoomCalendar>> selectOnRoomId(int roomId);

    @Query("SELECT * FROM RoomCalendar WHERE assignedTo = :assignedTo")
    LiveData<List<RoomCalendar>> selectOnAssignedTo(int assignedTo);

    @Query("SELECT * FROM RoomCalendar WHERE dateStart = :dateStart")
    LiveData<List<RoomCalendar>> selectOnDateStart(String dateStart);

    @Query("SELECT * FROM RoomCalendar WHERE dateEnd = :dateEnd")
    LiveData<List<RoomCalendar>> selectOnDateEnd(String dateEnd);

    @Query("SELECT * FROM RoomCalendar WHERE dateStart >= :dateStart AND dateEnd <= :dateEnd")
    LiveData<List<RoomCalendar>> selectOnDates(String dateStart, String dateEnd);

}
