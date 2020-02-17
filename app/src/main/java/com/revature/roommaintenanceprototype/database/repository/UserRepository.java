package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.UserDao;
import com.revature.roommaintenanceprototype.database.table.User;

import java.util.List;

public class UserRepository {

    private UserDao dao;
    private static LiveData<List<User>> list;

    public UserRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.userDao();
        list = dao.selectAll();
    }

    public static LiveData<List<User>> getAll(){
        return list;
    }

}
