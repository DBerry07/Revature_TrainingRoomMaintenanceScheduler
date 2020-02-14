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

import java.util.ArrayList;
import java.util.List;

public class CampusRepository {

    private CampusDao campusDao;

    LiveData<List<Campus>> campusList;

    public CampusRepository(Application application) {
        MaintenanceDatabase db = MaintenanceDatabase.getDatabase(application);

        campusDao = db.campusDao();
        campusList = campusDao.selectAll();
    }

    public LiveData<List<Campus>> getCampuses(){
        return campusList;
    }

}
