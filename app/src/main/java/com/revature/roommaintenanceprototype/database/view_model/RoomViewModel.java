package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.RoomRepository;
import com.revature.roommaintenanceprototype.database.repository.UserRepository;
import com.revature.roommaintenanceprototype.database.tables.RoomTable;
import com.revature.roommaintenanceprototype.database.tables.User;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {

    private RoomRepository repository;
    private LiveData<List<RoomTable>> list;

    public RoomViewModel(Application application){
        super(application);
        repository = new RoomRepository(application);
        list = repository.getAll();
    }

    public LiveData<List<RoomTable>> getCampuses(){
        return list;
    }
}
