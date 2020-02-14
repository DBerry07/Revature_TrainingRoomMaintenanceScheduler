package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MaintenanceDatabase;
import com.revature.roommaintenanceprototype.database.dao.RoomDao;
import com.revature.roommaintenanceprototype.database.dao.UserDao;
import com.revature.roommaintenanceprototype.database.tables.RoomTable;
import com.revature.roommaintenanceprototype.database.tables.User;

import java.util.List;

public class RoomRepository {

    private RoomDao roomDao;

    LiveData<List<RoomTable>> roomList;

    public RoomRepository(Application application) {
        MaintenanceDatabase db = MaintenanceDatabase.getDatabase(application);

        roomDao = db.roomDao();
        roomList = roomDao.selectAll();
    }

    public LiveData<List<RoomTable>> getAll(){
        return roomList;
    }

}
