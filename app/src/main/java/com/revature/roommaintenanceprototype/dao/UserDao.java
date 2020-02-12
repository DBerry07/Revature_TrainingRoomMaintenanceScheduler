package com.revature.roommaintenanceprototype.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

public interface UserDao {

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    LiveData<Boolean> authenticateUser(String email, String password);

    @Query("UPDATE User SET password = :password WHERE email = :email;")
    LiveData<Boolean> updatePassword(String email, String password);

    @Query("SELECT userRoleId FROM User WHERE email = :email AND password = :password")
    LiveData<Integer> trainerOrSiteManager(String email, String password);

}
