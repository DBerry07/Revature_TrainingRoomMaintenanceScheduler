package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> selectAll();

    @Query("SELECT * FROM Task WHERE id = :id")
    LiveData<List<Task>> select(int id);

    @Query("SELECT * FROM Task WHERE name = :name")
    LiveData<List<Task>> selectOnName(String name);

}
