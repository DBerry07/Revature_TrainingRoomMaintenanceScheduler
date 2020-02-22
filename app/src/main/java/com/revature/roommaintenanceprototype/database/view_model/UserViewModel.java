package com.revature.roommaintenanceprototype.database.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.revature.roommaintenanceprototype.database.repository.UserRepository;
import com.revature.roommaintenanceprototype.database.table.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;
    private LiveData<List<User>> list;
    private UserViewModel userViewModel;

    public UserViewModel (Application application) {
        super(application);
        repository = new UserRepository(application);
        list = repository.getAll();
    }

    public void insert(User user){
        repository.insert(user);
    }

    public LiveData<List<User>> getAll(){
        return list;
    }

    public List<String> listEmails() {
        List<User> users = null;
        List<String> emails = new ArrayList<>();
        if (list != null) {
            users = list.getValue();
            for (User each : users) {
                emails.add(each.getEmail());
            }
        }
        return emails;
    }

}
