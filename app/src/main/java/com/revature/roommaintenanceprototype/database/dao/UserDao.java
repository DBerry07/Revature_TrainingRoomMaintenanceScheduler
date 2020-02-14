package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.tables.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    LiveData<List<User>> selectAll();

    /*@Query("SELECT * FROM User WHERE email = :email AND password = :password")
    LiveData<Boolean> authenticateUser(String email, String password);*/

    @Query("SELECT * FROM User WHERE email = :email")
    LiveData<List<User>> select(String email);

    /*@Query("UPDATE User SET password = :password WHERE email = :email;")
    LiveData<Boolean> updatePassword(String email, String password);*/

    @Query("SELECT * FROM User WHERE userRoleId = :userRoleId")
    LiveData<List<User>> selectOnUserRoleId(int userRoleId);

}
