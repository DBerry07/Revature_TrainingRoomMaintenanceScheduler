package com.revature.roommaintenanceprototype.database.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = {
        @ForeignKey(entity = Room.class,
                parentColumns = "id",
                childColumns = "roomId"),
        @ForeignKey(entity = User.class,
            parentColumns = "id",
            childColumns = "inspectedBy")
})
public class MaintenanceChart {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "roomId")
    private int roomId;

    @ColumnInfo(name = "inspectedBy")
    private int inspectedBy;

    //GETTERS
    public int getId() { return id; }
    public Date getDate() { return date; }
    public int getRoomId() { return roomId; }
    public int getInspectedBy() { return inspectedBy; }

    //SETTERS
    public void setId(int id) { this.id = id; }
    public void setDate(Date date) { this.date = date; }
    public void setRoomId(int roomId) { this.roomId = roomId; }
    public void setInspectedBy(int inspectedBy) { this.inspectedBy = inspectedBy; }
}
