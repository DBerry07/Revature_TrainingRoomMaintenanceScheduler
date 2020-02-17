package com.revature.roommaintenanceprototype.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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
import com.revature.roommaintenanceprototype.database.table.Campus;
import com.revature.roommaintenanceprototype.database.table.CompletedTaskList;
import com.revature.roommaintenanceprototype.database.table.Location;
import com.revature.roommaintenanceprototype.database.table.MaintenanceChart;
import com.revature.roommaintenanceprototype.database.table.RoomCalendar;
import com.revature.roommaintenanceprototype.database.table.RoomData;
import com.revature.roommaintenanceprototype.database.table.RoomTaskList;
import com.revature.roommaintenanceprototype.database.table.Task;
import com.revature.roommaintenanceprototype.database.table.User;
import com.revature.roommaintenanceprototype.database.table.UserRole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Campus.class, CompletedTaskList.class,
Location.class, MaintenanceChart.class, RoomCalendar.class, RoomData.class,
        RoomTaskList.class, Task.class, User.class, UserRole.class}, version = 1, exportSchema = false)
public abstract class MDatabase extends RoomDatabase {

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

    private static volatile MDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MDatabase.class, "m_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
