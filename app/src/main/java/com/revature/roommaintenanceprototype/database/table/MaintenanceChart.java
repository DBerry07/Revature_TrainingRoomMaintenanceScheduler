package com.revature.roommaintenanceprototype.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MaintenanceChart {

    @PrimaryKey
    int id;

    @ColumnInfo(name = "date")
    String date;

    @ColumnInfo(name = "roomId")
    int roomId;

    @ColumnInfo(name = "inspectedBy")
    int inspectedBy;

    //Constructors
    public MaintenanceChart(int id, int roomId, int inspectedBy, String date) {
        this.id = id;
        this.roomId = roomId;
        this.inspectedBy = inspectedBy;
        this.date = date;
    }

    //Getters


    public int getId() {
        return id;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getInspectedBy() {
        return inspectedBy;
    }

    public String getDate() {
        return date;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setInspectedBy(int inspectedBy) {
        this.inspectedBy = inspectedBy;
    }
}
