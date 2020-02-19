package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.MaintenanceChartRepository;
import com.revature.roommaintenanceprototype.database.table.MaintenanceChart;

import java.util.List;

public class MaintenanceChartViewModel extends AndroidViewModel {

    private MaintenanceChartRepository repository;
    private LiveData<List<MaintenanceChart>> list;

    public MaintenanceChartViewModel(Application application) {
        super(application);
        repository = new MaintenanceChartRepository(application);
        list = repository.getAll();
    }

}
