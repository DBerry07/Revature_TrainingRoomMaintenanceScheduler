package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.CampusRepository;
import com.revature.roommaintenanceprototype.database.table.Campus;

import java.util.List;

public class CampusViewModel extends AndroidViewModel {

    private CampusRepository repository;
    private LiveData<List<Campus>> list;

    public CampusViewModel(Application application) {
        super(application);
        repository = new CampusRepository(application);
        list = repository.getAll();
    }

}
