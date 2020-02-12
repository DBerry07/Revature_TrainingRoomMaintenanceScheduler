package com.revature.roommaintenanceprototype.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.revature.roommaintenanceprototype.dao.UserDao;
import com.revature.roommaintenanceprototype.database.tables.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class MaintenanceDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static volatile MaintenanceDatabase INSTANCE;
    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MaintenanceDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MaintenanceDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MaintenanceDatabase.class,
                            "MaintenanceDatabase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
