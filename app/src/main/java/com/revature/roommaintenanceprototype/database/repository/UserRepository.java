package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.UserDao;
import com.revature.roommaintenanceprototype.database.table.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private static LiveData<List<User>> users;

    public UserRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        users = userDao.selectAll();
    }

    public static LiveData<List<User>> getAll(){
        return users;
    }

}
