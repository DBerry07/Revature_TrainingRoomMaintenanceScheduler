package com.revature.roommaintenanceprototype.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomTaskList {

    @PrimaryKey
    int id;

    int roomId;

    int taskId;

    String dateStart;

    String dateEnd;

}
