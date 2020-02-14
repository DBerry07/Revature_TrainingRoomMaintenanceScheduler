package com.revature.roommaintenanceprototype.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class MaintenanceViewModel extends AndroidViewModel {

    private Repository repository;

    public MaintenanceViewModel (Application application){
        super(application);
        repository = new Repository(application);

    }
}
