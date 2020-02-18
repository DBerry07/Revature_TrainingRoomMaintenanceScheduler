package com.revature.roommaintenanceprototype.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomTaskList {

    @PrimaryKey
    int id;

    @ColumnInfo(name = "roomId")
    int roomId;

    @ColumnInfo(name = "taskId")
    int taskId;

    @ColumnInfo(name = "dateStart")
    String dateStart;

    @ColumnInfo(name = "dateEnd")
    String dateEnd;

    //Constructors
    public RoomTaskList(int id,int roomId, int taskId, String dateStart, String dateEnd){
        this.id = id;
        this.roomId = roomId;
        this.taskId = taskId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getTaskId() {
        return taskId;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}

