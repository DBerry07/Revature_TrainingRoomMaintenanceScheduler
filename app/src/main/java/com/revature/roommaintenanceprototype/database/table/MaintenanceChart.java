package com.revature.roommaintenanceprototype.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MaintenanceChart {

    @PrimaryKey
    int id;

    String date;

    int roomId;

    int inspectedBy;

}
