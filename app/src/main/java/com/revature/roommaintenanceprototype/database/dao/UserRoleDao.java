package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.UserRole;

import java.util.List;

@Dao
public interface UserRoleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(UserRole item);

    @Query("SELECT * FROM UserRole")
    LiveData<List<UserRole>> selectAll();

}
