package com.revature.roommaintenanceprototype.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CompletedTaskList {

    @PrimaryKey
    int id;

    @ColumnInfo(name = "maintenanceChartId")
    int maintenanceChartId;

    @ColumnInfo(name = "taskId")
    int taskId;

    @ColumnInfo(name = "taskCompleted")
    boolean taskCompleted;

    //Constructor
    public CompletedTaskList(int id, int maintenanceChartId, int taskId,boolean taskCompleted){
        this.id = id;
        this.maintenanceChartId = maintenanceChartId;
        this.taskId = taskId;
        this.taskCompleted = taskCompleted;
    }

    //Getters
    public int getId() {
        return id;
    }
    public int getTaskId() {
        return taskId;
    }
    public int getMaintenanceChartId() {
        return maintenanceChartId;
    }
    public boolean getTaskCompleted() {
        return taskCompleted;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setMaintenanceChartId(int maintenanceChartId) {
        this.maintenanceChartId = maintenanceChartId;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

}
