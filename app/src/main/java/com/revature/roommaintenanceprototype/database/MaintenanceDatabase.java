package com.revature.roommaintenanceprototype.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.revature.roommaintenanceprototype.database.dao.UserDao;
import com.revature.roommaintenanceprototype.database.tables.Campus;
import com.revature.roommaintenanceprototype.database.tables.CompletedTaskList;
import com.revature.roommaintenanceprototype.database.tables.Location;
import com.revature.roommaintenanceprototype.database.tables.MaintenanceChart;
import com.revature.roommaintenanceprototype.database.tables.RoomCalendar;
import com.revature.roommaintenanceprototype.database.tables.RoomTable;
import com.revature.roommaintenanceprototype.database.tables.RoomTaskList;
import com.revature.roommaintenanceprototype.database.tables.Task;
import com.revature.roommaintenanceprototype.database.tables.User;
import com.revature.roommaintenanceprototype.database.tables.UserRole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Campus.class, CompletedTaskList.class, Location.class, MaintenanceChart.class, RoomTable.class, RoomCalendar.class, RoomTaskList.class, Task.class, User.class, UserRole.class}, version = 1, exportSchema = false)
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
