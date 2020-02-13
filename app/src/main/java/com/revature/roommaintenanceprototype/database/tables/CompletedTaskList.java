package com.revature.roommaintenanceprototype.database.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = MaintenanceChart.class,
            parentColumns = "id",
            childColumns = "maintenanceChartId"),
        @ForeignKey(entity = Task.class,
            parentColumns = "id",
            childColumns = "taskId")
})
public class CompletedTaskList {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "maintenanceChartId")
    private int maintenanceChartId;

    @ColumnInfo(name = "taskId")
    private int taskId;

    @ColumnInfo(name = "taskCompleted")
    private boolean taskCompleted;

    //GETTERS
    public int getId() { return id; }
    public int getMaintenanceChartId() { return maintenanceChartId; }
    public int getTaskId() { return taskId; }
    public boolean getTaskCompleted() { return taskCompleted; }

    //SETTERS
    public void setId(int id) { this.id = id; }
    public void setMaintenanceChartId(int maintenanceChartId) { this.maintenanceChartId = maintenanceChartId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }
    public void setTaskCompleted(boolean taskCompleted) { this.taskCompleted = taskCompleted; }
}
