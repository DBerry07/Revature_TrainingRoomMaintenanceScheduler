package com.revature.roommaintenanceprototype.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomCalendar {

    @PrimaryKey
    int id;

    @ColumnInfo(name = "assignedTo")
    int assignedTo;

    @ColumnInfo(name = "dateStart")
    String dateStart;

    @ColumnInfo(name = "dateEnd")
    String dateEnd;

    //Constructors
    public RoomCalendar(int id, int assignedTo, String dateStart, String dateEnd){
        this.id = id;
        this.assignedTo = assignedTo;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    //Getters


    public int getId() {
        return id;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getDateStart() {
        return dateStart;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }
}
