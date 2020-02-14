package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.CompletedTaskList;

import java.util.List;

@Dao
public interface CompletedTaskListDao {

    @Query("SELECT * FROM CompletedTaskList")
    LiveData<List<CompletedTaskList>> selectAll();

    @Query("SELECT * FROM CompletedTaskList WHERE id = :id")
    LiveData<List<CompletedTaskList>> select(int id);

    @Query("SELECT * FROM CompletedTaskList WHERE maintenanceChartId = :maintenanceChartId")
    LiveData<List<CompletedTaskList>> selectOnMaintenanceChartId(int maintenanceChartId);

    @Query("SELECT * FROM CompletedTaskList WHERE taskId = :taskId")
    LiveData<CompletedTaskList> selectOnTaskId(int taskId);

    @Query("SELECT * FROM CompletedTaskList WHERE taskCompleted = :taskCompleted")
    LiveData<List<Boolean>> selectOnTaskCompleted(boolean taskCompleted);

}
