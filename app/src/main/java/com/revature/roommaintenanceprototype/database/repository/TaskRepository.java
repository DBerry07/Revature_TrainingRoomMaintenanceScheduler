package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.TaskDao;
import com.revature.roommaintenanceprototype.database.table.Task;

import java.util.List;

public class TaskRepository {

    private TaskDao dao;
    private static LiveData<List<Task>> list;

    public TaskRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.taskDao();
        list = dao.selectAll();
    }

    public static LiveData<List<Task>> getAll(){
        return list;
    }

}
