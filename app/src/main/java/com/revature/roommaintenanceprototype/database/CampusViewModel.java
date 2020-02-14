package com.revature.roommaintenanceprototype.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.CampusRepository;
import com.revature.roommaintenanceprototype.database.tables.Campus;

import java.util.List;

public class CampusViewModel extends AndroidViewModel {

    private CampusRepository campusRepository;
    private LiveData<List<Campus>> campuses;

    public CampusViewModel(Application application){
        super(application);
        campusRepository = new CampusRepository(application);
        campuses = campusRepository.getCampuses();
    }

    public LiveData<List<Campus>> getCampuses(){
        return campuses;
    }
}
