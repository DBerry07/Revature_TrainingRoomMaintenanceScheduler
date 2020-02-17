package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.User;
import com.revature.roommaintenanceprototype.database.table.UserRole;

import java.util.List;

@Dao
public interface UserRoleDao {

    @Query("SELECT * FROM UserRole")
    LiveData<List<UserRole>> selectAll();

}
