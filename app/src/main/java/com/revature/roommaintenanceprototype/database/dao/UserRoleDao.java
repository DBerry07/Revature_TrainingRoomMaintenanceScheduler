package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.UserRole;

import java.util.List;

@Dao
public interface UserRoleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(UserRole userRole);

    @Query("SELECT * FROM UserRole")
    LiveData<List<UserRole>> selectAll();

    @Query("SELECT * FROM UserRole WHERE id = :id")
    LiveData<List<UserRole>> select(int id);

    @Query("SELECT * FROM UserRole WHERE name = :name")
    LiveData<List<UserRole>> selectOnName(String name);

}
