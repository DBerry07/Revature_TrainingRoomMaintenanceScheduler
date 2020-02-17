package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MaintenanceDatabase;
import com.revature.roommaintenanceprototype.database.dao.RoomDao;
import com.revature.roommaintenanceprototype.database.dao.TaskDao;
import com.revature.roommaintenanceprototype.database.tables.RoomTable;
import com.revature.roommaintenanceprototype.database.tables.Task;

import java.util.List;

public class TaskRepository {

    private TaskDao dao;

    LiveData<List<Task>> list;

    public TaskRepository(Application application) {
        MaintenanceDatabase db = MaintenanceDatabase.getDatabase(application);

        dao = db.taskDao();
        list = dao.selectAll();
    }

    public LiveData<List<Task>> getAll(){
        return list;
    }

}
