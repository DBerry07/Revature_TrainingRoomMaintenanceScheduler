package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task item);

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> selectAll();

}
