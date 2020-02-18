package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.CompletedTaskList;

import java.util.List;

@Dao
public interface CompletedTaskListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CompletedTaskList item);

    @Query("SELECT * FROM CompletedTaskList")
    LiveData<List<CompletedTaskList>> selectAll();

}
