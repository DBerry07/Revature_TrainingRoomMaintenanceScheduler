package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.UserRoleDao;
import com.revature.roommaintenanceprototype.database.table.UserRole;

import java.util.List;

public class UserRoleRepository {

    private UserRoleDao dao;
    private static LiveData<List<UserRole>> list;

    public UserRoleRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.userRoleDao();
        list = dao.selectAll();
    }

    public static LiveData<List<UserRole>> getAll(){
        return list;
    }

}
