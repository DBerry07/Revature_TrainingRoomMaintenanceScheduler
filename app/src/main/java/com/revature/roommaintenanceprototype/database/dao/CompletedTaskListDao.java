package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.CompletedTaskList;

import java.util.List;

public interface CompletedTaskListDao {

    @Query("SELECT * FROM CompletedTaskList")
    LiveData<List<CompletedTaskList>> selectAll();

    @Query("SELECT * FROM CompletedTaskList WHERE id = :id")
    LiveData<CompletedTaskList> select(int id);

    @Query("SELECT * FROM CompletedTaskList WHERE taskId = :taskId")
    LiveData<CompletedTaskList> selectOnTaskId(int taskId);

    @Query("SELECT taskCompleted FROM CompletedTaskList")
    LiveData<List<Boolean>> selectAllTaskCompleted();

}
