package com.revature.roommaintenanceprototype.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Location.class,
                parentColumns = "id",
                childColumns = "locationId"),
        @ForeignKey(entity = Campus.class,
                parentColumns = "id",
                childColumns = "campusId"),
        @ForeignKey(entity = RoomCalendar.class,
            parentColumns = "id",
            childColumns = "assignedTo")
})
public class Room {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "locationId")
    private int locationId;

    @NonNull
    @ColumnInfo(name = "campusId")
    private int campusId;

    @ColumnInfo(name = "assignedTo")
    private int assignedTo;

    //SETTERS
    public void setId(int id) { this.id = id; }
    public void setName(@NonNull String name) { this.name = name; }
    public void setLocationId(int locationId) { this.locationId = locationId; }
    public void setCampusId(int campusId) { this.campusId = campusId; }
    public void setAssignedTo(int assignedTo) { this.assignedTo = assignedTo; }

    //GETTERS
    public int getId() { return id; }
    @NonNull public String getName() { return name; }
    public int getLocationId() { return locationId; }
    public int getCampusId() { return campusId; }
    public int getAssignedTo() { return assignedTo; }
}
