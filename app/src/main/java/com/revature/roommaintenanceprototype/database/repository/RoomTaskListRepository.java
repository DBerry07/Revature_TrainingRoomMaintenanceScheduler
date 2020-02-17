package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.RoomTaskListDao;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;

import java.util.List;

public class RoomTaskListRepository {

    private RoomTaskListDao dao;
    private static LiveData<List<RoomTaskList>> list;

    public RoomTaskListRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.roomTaskListDao();
        list = dao.selectAll();
    }

    public static LiveData<List<RoomTaskList>> getAll(){
        return list;
    }

}
