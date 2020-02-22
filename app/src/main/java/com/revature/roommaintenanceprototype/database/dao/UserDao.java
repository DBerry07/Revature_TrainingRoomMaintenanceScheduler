package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User item);

    @Query("SELECT * FROM User")
    LiveData<List<User>> selectAll();

    @Query("SELECT email from User WHERE userRole = 0")
    LiveData<String> selectTrainerEmail();
    @Query("SELECT email from User WHERE userRole = 1")
    LiveData<List<String>> selectSiteManagerEmail();

}
