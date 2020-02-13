package com.revature.roommaintenanceprototype.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = {
        @ForeignKey(entity = RoomTable.class,
                parentColumns = "id",
                childColumns = "roomId"),
        @ForeignKey(entity = User.class,
            parentColumns = "id",
            childColumns = "assignedTo")
})
public class RoomCalendar {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "roomId")
    private int roomId;

    @ColumnInfo(name = "assignedTo")
    private int assignedTo;

    @ColumnInfo(name = "dateStart")
    private String dateStart;

    @ColumnInfo(name = "dateEnd")
    private String dateEnd;

    //GETTERS
    public int getId() { return id; }
    public int getRoomId() { return roomId; }
    public int getAssignedTo() { return assignedTo; }
    public String getDateStart() { return dateStart; }
    public String getDateEnd() { return dateEnd; }

    //SETTERS
    public void setId(int id) { this.id = id; }
    public void setRoomId(int roomId) { this.roomId = roomId; }
    public void setAssignedTo(int assignedTo) { this.assignedTo = assignedTo; }
    public void setDateStart(String dateStart) { this.dateStart = dateStart; }
    public void setDateEnd(String dateEnd) { this.dateEnd = dateEnd; }
}
