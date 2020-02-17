package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.revature.roommaintenanceprototype.database.repository.UserRepository;
import com.revature.roommaintenanceprototype.database.table.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<List<User>> users;

    public UserViewModel (Application application) {
        super(application);
        userRepository = new UserRepository(application);
        users = UserRepository.getAll();
    }

}
