package com.revature.roommaintenanceprototype.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomData {

    @PrimaryKey
    int id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "locationId")
    int locationId;

    @ColumnInfo(name = "campusId")
    int campusId;

    @ColumnInfo(name = "assignedTo")
    int assignedTo;

    //Constructors
    public RoomData(int id, String name, int locationId, int campusId, int assignedTo){
        this.id = id;
        this.name = name;
        this.locationId = locationId;
        this.campusId = campusId;
        this.assignedTo = assignedTo;
    }

    //Getters

    public int getAssignedTo() {
        return assignedTo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCampusId() {
        return campusId;
    }

    public int getLocationId() {
        return locationId;
    }

    //Setters

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
