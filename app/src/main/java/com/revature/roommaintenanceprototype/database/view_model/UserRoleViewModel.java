package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.UserRoleRepository;
import com.revature.roommaintenanceprototype.database.table.UserRole;

import java.util.List;

public class UserRoleViewModel extends AndroidViewModel {

    private UserRoleRepository repository;
    private LiveData<List<UserRole>> list;

    public UserRoleViewModel(Application application) {
        super(application);
        repository = new UserRoleRepository(application);
        list = repository.getAll();
    }

}
