package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.CompletedTaskListRepository;
import com.revature.roommaintenanceprototype.database.table.CompletedTaskList;

import java.util.List;

public class CompletedTaskListViewModel extends AndroidViewModel {

    private CompletedTaskListRepository repository;
    private LiveData<List<CompletedTaskList>> list;

    public CompletedTaskListViewModel(Application application) {
        super(application);
        repository = new CompletedTaskListRepository(application);
        list = repository.getAll();
    }
}
