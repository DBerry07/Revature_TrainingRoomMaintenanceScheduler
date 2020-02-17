package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.RoomDao;
import com.revature.roommaintenanceprototype.database.table.RoomData;

import java.util.List;

public class RoomRepository {

    private RoomDao dao;
    private static LiveData<List<RoomData>> list;

    public RoomRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.roomDao();
        list = dao.selectAll();
    }

    public static LiveData<List<RoomData>> getAll(){
        return list;
    }

}
