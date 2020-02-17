package com.revature.roommaintenanceprototype.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserRole {

    @PrimaryKey
    int id;

    String name;
}
