package com.revature.roommaintenanceprototype.database;

import android.database.sqlite.SQLiteDatabase;

public class DatabaseSetup {

    static SQLiteDatabase database;

    public static void createDatabase(){
        database = SQLiteDatabase.openOrCreateDatabase("MaintenanceDatabase", null, null);
        database.close();
    }

    public static void createUserTables(){
        database.execSQL("CREATE TABLE UserRole (Id SERIAL PRIMARY KEY, name VARCHAR(10));");
        database.execSQL("CREATE TABLE User " +
                "(Id SERIAL PRIMARY KEY, " +
                "email VARCHAR(20), " +
                "password VARCHAR(20), " +
                "userRoleId INTEGER, FOREIGN KEY(userRoleId) REFERENCES UserRole(Id));");
    }

    public static void insertUserData(){
        database.execSQL("INSERT INTO UserRole (Id, name) VALUES (0, 'Trainer'), (1, 'Site Manager');");
        database.execSQL("INSERT INTO User (Id, email, password, userroleid) VALUES " +
                "(0, 'nick@revature.com', 'nick' 0), " +
                "(1, 'mayur@revature.com', 'mayur', 0), " +
                "(2, 'uday@revature.com', 'uday', 0), " +
                "(3, 'steve@revature.com', 'steve', 1), " +
                "(4, 'kate@revature.com', 'kate', 1);");
    }
}

