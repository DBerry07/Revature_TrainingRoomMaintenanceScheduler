package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.RoomCalendarRepository;
import com.revature.roommaintenanceprototype.database.table.RoomCalendar;

import java.util.List;

public class RoomCalendarViewModel extends AndroidViewModel {

    private RoomCalendarRepository repository;
    private LiveData<List<RoomCalendar>> list;

    public RoomCalendarViewModel(Application application) {
        super(application);
        repository = new RoomCalendarRepository(application);
        list = repository.getAll();
    }

}
