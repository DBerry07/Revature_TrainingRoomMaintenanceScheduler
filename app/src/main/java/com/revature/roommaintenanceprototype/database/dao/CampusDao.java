package com.revature.roommaintenanceprototype.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.revature.roommaintenanceprototype.database.table.Campus;

import java.util.List;

@Dao
public interface CampusDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Campus item);

    @Query("SELECT * FROM Campus")
    LiveData<List<Campus>> selectAll();

}
