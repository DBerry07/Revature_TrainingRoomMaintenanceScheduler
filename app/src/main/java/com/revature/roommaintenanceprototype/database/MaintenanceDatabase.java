package com.revature.roommaintenanceprototype.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.revature.roommaintenanceprototype.database.dao.CampusDao;
import com.revature.roommaintenanceprototype.database.dao.CompletedTaskListDao;
import com.revature.roommaintenanceprototype.database.dao.LocationDao;
import com.revature.roommaintenanceprototype.database.dao.MaintenanceChartDao;
import com.revature.roommaintenanceprototype.database.dao.RoomCalendarDao;
import com.revature.roommaintenanceprototype.database.dao.RoomDao;
import com.revature.roommaintenanceprototype.database.dao.RoomTaskListDao;
import com.revature.roommaintenanceprototype.database.dao.TaskDao;
import com.revature.roommaintenanceprototype.database.dao.UserDao;
import com.revature.roommaintenanceprototype.database.dao.UserRoleDao;
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

@Database(entities = {Campus.class, CompletedTaskList.class, Location.class, MaintenanceChart.class, RoomTable.class, RoomCalendar.class, RoomTaskList.class, Task.class, User.class, UserRole.class}, version = 2, exportSchema = false)
public abstract class MaintenanceDatabase extends RoomDatabase {

    //DAOs
    public abstract CampusDao campusDao();
    public abstract CompletedTaskListDao completedTaskListDao();
    public abstract LocationDao locationDao();
    public abstract MaintenanceChartDao maintenanceChartDao();
    public abstract RoomCalendarDao roomCalendarDao();
    public abstract RoomDao roomDao();
    public abstract RoomTaskListDao roomTaskListDao();
    public abstract TaskDao taskDao();
    public abstract UserDao userDao();
    public abstract UserRoleDao userRoleDao();

    private static volatile MaintenanceDatabase INSTANCE;
    private static int NUMBER_OF_THREADS = 4;
    static final public ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MaintenanceDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MaintenanceDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MaintenanceDatabase.class,
                            "MaintenanceDatabase")
                            .addCallback(populateDatabase)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    //POPULATE DATABASE WITH THIS METHOD
    private static RoomDatabase.Callback populateDatabase = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            //CLEAR DATABASE AND INITIALIZE NEW DATA
            databaseWriteExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    {
                        CampusDao campusDao = INSTANCE.campusDao();
                        for (int i = 0; i < 5; i++) {
                            Campus campus = new Campus(i, "campus#" + i);
                            campusDao.insert(campus);
                        }
                    }
                    {
                        UserRoleDao userRoleDao = INSTANCE.userRoleDao();
                        UserRole item = new UserRole(0, "Trainer");
                        userRoleDao.insert(item);
                        item = new UserRole(1, "Site Manager");
                        userRoleDao.insert(item);
                    }
                    {
                        UserDao userDao = INSTANCE.userDao();
                        for (int i = 0; i < 20; i++){
                            User item = new User(i, "email#" + i, 0);
                            userDao.insert(item);
                        }
                    }
                    {
                        LocationDao locationDao = INSTANCE.locationDao();
                        for (int i = 0; i < 7; i++){
                            Location item = new Location(i, "location#" + i);
                            locationDao.insert(item);
                        }
                    }
                    {
                        RoomCalendarDao dao = INSTANCE.roomCalendarDao();
                        for (int i = 0; i < 10; i++){
                            RoomCalendar item = new RoomCalendar(i, i % 30, "1-1-2000", "2-2-2001");
                            dao.insert(item);
                        }
                    }
                    {
                        RoomDao roomDao = INSTANCE.roomDao();
                        for (int i = 0; i < 30; i++){
                            RoomTable item = new RoomTable(i, "room#" + i, i % 7, i % 5, i % 10);
                            roomDao.insert(item);
                        }
                    }
                }
            });
        }
    };
}
