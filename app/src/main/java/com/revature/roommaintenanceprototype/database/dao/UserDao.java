package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    LiveData<List<User>> selectAll();
}
