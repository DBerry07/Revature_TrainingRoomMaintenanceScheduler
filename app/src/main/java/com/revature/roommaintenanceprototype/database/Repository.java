package com.revature.roommaintenanceprototype.database;

import android.app.Application;

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
import com.revature.roommaintenanceprototype.database.tables.User;

public class Repository {

    private CampusDao campusDao;
    private CompletedTaskListDao completedTaskListDao;
    private LocationDao locationDao;
    private MaintenanceChartDao maintenanceChartDao;
    private RoomCalendarDao roomCalendarDao;
    private RoomDao roomDao;
    private RoomTaskListDao roomTaskListDao;
    private TaskDao taskDao;
    private UserDao userDao;
    private UserRoleDao userRoleDao;

    Repository(Application application) {
        MaintenanceDatabase db = MaintenanceDatabase.getDatabase(application);

        userDao = db.userDao();
        //mAllWords = mWordDao.getAlphabetizedWords();
    }

    void insertUser(final User user) {
        MaintenanceDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insert(user);
            }
        });
    }

}
