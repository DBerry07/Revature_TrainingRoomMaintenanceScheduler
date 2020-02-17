package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.RoomTaskListRepository;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;

import java.util.List;

public class RoomTaskListViewModel extends AndroidViewModel {

    private RoomTaskListRepository repository;
    private LiveData<List<RoomTaskList>> list;

    public RoomTaskListViewModel(Application application) {
        super(application);
        repository = new RoomTaskListRepository(application);
        list = repository.getAll();
    }

}
