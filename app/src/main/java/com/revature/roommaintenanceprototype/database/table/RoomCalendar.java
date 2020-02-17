package com.revature.roommaintenanceprototype.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomCalendar {

    @PrimaryKey
    int id;

    int assignedTo;

    String dateStart;

    String dateEnd;

}
