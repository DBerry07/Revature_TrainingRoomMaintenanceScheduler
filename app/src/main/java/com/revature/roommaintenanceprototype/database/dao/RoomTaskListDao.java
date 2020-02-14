package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.RoomTaskList;

import java.util.Date;
import java.util.List;

@Dao
public interface RoomTaskListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RoomTaskList roomTaskList);

    @Query("SELECT * FROM RoomTaskList")
    LiveData<List<RoomTaskList>> selectAll();

    @Query("SELECT * FROM RoomTaskList WHERE id = :id")
    LiveData<List<RoomTaskList>> select(int id);

    @Query("SELECT * FROM RoomTaskList WHERE roomId = :roomId")
    LiveData<List<RoomTaskList>> selectOnRoomId(int roomId);

    @Query("SELECT * FROM RoomTaskList WHERE taskId = :taskId")
    LiveData<List<RoomTaskList>> selectOnTaskId(int taskId);

    @Query("SELECT * FROM RoomTaskList WHERE dateStart = :dateStart")
    LiveData<List<RoomTaskList>> selectOnDateStart(Date dateStart);

    @Query("SELECT * FROM RoomTaskList WHERE dateEnd = :dateEnd")
    LiveData<List<RoomTaskList>> selectOnDateEnd(Date dateEnd);

    @Query("SELECT * FROM RoomTaskList WHERE dateStart >= :dateStart AND dateEnd <= :dateEnd")
    LiveData<List<RoomTaskList>> selectOnDates(Date dateStart, Date dateEnd);

}
