package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.CompletedTaskList;

import java.util.List;

@Dao
public interface CompletedTaskListDao {

    @Query("SELECT * FROM CompletedTaskList")
    LiveData<List<CompletedTaskList>> selectAll();

}
