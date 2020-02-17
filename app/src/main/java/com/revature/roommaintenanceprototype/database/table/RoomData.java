package com.revature.roommaintenanceprototype.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomData {

    @PrimaryKey
    int id;

    String name;

    int locationId;

    int campusId;

    int assignedTo;

}
