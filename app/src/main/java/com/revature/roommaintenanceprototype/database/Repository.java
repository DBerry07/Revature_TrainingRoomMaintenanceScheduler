package com.revature.roommaintenanceprototype.database;

import android.app.Application;

import com.revature.roommaintenanceprototype.database.dao.UserDao;

public class Repository {

    private UserDao userDao;

    Repository(Application application) {
        MaintenanceDatabase db = MaintenanceDatabase.getDatabase(application);
        userDao = db.userDao();
        //mAllWords = mWordDao.getAlphabetizedWords();
    }

    /*void insertUser(final User user) {
        MaintenanceDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }*/

}
