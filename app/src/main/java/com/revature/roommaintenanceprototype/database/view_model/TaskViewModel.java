package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.TaskRepository;
import com.revature.roommaintenanceprototype.database.table.Task;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository repository;
    private LiveData<List<Task>> list;

    public TaskViewModel(Application application) {
        super(application);
        repository = new TaskRepository(application);
        list = repository.getAll();
    }

}
