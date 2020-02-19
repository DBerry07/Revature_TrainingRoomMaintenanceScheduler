package com.revature.roommaintenanceprototype.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.dao.CompletedTaskListDao;
import com.revature.roommaintenanceprototype.database.table.CompletedTaskList;

import java.util.List;

public class CompletedTaskListRepository {

    private CompletedTaskListDao dao;
    private static LiveData<List<CompletedTaskList>> list;

    public CompletedTaskListRepository(Application application){
        MDatabase db = MDatabase.getDatabase(application);
        dao = db.completedTaskListDao();
        list = dao.selectAll();
    }

    public static LiveData<List<CompletedTaskList>> getAll(){
        return list;
    }

}
