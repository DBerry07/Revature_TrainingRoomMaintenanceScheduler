package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.LocationRepository;
import com.revature.roommaintenanceprototype.database.table.Location;

import java.util.List;

public class LocationViewModel extends AndroidViewModel {

    private LocationRepository repository;
    private LiveData<List<Location>> list;

    public LocationViewModel(Application application) {
        super(application);
        repository = new LocationRepository(application);
        list = repository.getAll();
    }

}
