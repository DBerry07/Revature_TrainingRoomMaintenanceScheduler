package com.revature.roommaintenanceprototype.database.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(foreignKeys = {
        @ForeignKey(entity = RoomTable.class,
            parentColumns = "id",
            childColumns = "roomId"),
        @ForeignKey(entity = Task.class,
            parentColumns = "id",
            childColumns = "taskId")
})
public class RoomTaskList {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "roomId")
    private int roomId;

    @ColumnInfo(name = "taskId")
    private int taskId;

    @ColumnInfo(name = "dateStart")
    private String dateStart;

    @ColumnInfo(name = "dateEnd")
    private String dateEnd;

    //GETTERS
    public int getId() { return id; }
    public int getRoomId() { return roomId; }
    public int getTaskId() { return taskId; }
    public String getDateStart() { return dateStart; }
    public String getDateEnd() { return dateEnd; }

    //SETTERS
    public void setId(int id) { this.id = id; }
    public void setRoomId(int roomId) { this.roomId = roomId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }
    public void setDateStart(String dateStart) { this.dateStart = dateStart; }
    public void setDateEnd(String dateEnd) { this.dateEnd = dateEnd; }

}
