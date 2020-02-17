package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MaintenanceDatabase;
import com.revature.roommaintenanceprototype.database.dao.CampusDao;
import com.revature.roommaintenanceprototype.database.dao.CompletedTaskListDao;
import com.revature.roommaintenanceprototype.database.dao.LocationDao;
import com.revature.roommaintenanceprototype.database.dao.MaintenanceChartDao;
import com.revature.roommaintenanceprototype.database.dao.RoomCalendarDao;
import com.revature.roommaintenanceprototype.database.dao.RoomDao;
import com.revature.roommaintenanceprototype.database.dao.RoomTaskListDao;
import com.revature.roommaintenanceprototype.database.dao.TaskDao;
import com.revature.roommaintenanceprototype.database.dao.UserDao;
import com.revature.roommaintenanceprototype.database.dao.UserRoleDao;
import com.revature.roommaintenanceprototype.database.tables.Campus;
import com.revature.roommaintenanceprototype.database.tables.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;

    LiveData<List<User>> userList;

    public UserRepository(Application application) {
        MaintenanceDatabase db = MaintenanceDatabase.getDatabase(application);

        userDao = db.userDao();
        userList = userDao.selectAll();
    }

    public LiveData<List<User>> getAll(){
        return userList;
    }

}
