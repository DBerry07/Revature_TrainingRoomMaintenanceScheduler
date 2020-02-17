package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.CampusRepository;
import com.revature.roommaintenanceprototype.database.repository.UserRepository;
import com.revature.roommaintenanceprototype.database.tables.Campus;
import com.revature.roommaintenanceprototype.database.tables.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;
    private LiveData<List<User>> list;

    public UserViewModel(Application application){
        super(application);
        repository = new UserRepository(application);
        list = repository.getAll();
    }

    public LiveData<List<User>> getCampuses(){
        return list;
    }
}
