package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.RoomCalendarDao;
import com.revature.roommaintenanceprototype.database.table.RoomCalendar;

import java.util.List;

public class RoomCalendarRepository {

    private RoomCalendarDao dao;
    private static LiveData<List<RoomCalendar>> list;

    public RoomCalendarRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.roomCalendarDao();
        list = dao.selectAll();
    }

    public static LiveData<List<RoomCalendar>> getAll(){
        return list;
    }

}
