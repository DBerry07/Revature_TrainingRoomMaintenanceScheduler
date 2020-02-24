package com.revature.roommaintenanceprototype.controllers.workflowpersistance;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public final class SMSchedulePersistance {
    private static String campus = "";
    private static String room = "";
    private static ArrayList<String> cleaningCriteria = new ArrayList<>();
    private static String trainer = "";
    private static String startDate = "";
    private static String endDate = "";

    public static String getResults(){
        StringBuilder results = new StringBuilder();
        results.append("\n\nCAMPUS | "+campus);
        results.append("\n\n\nROOM | "+room);
        results.append("\n\n\nCLEANING CRITERIA | "+cleaningCriteria.toString());
        results.append("\n\n\nSTART DATE | "+startDate);
        results.append("\n\n\nEND DATE | "+endDate);
        results.append("\n\n");
        return results.toString();
    }

    public static String getCampus() {
        return campus;
    }

    public static void setCampus(String campus) {
        SMSchedulePersistance.campus = campus;
    }

    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        SMSchedulePersistance.room = room;
    }

    public static ArrayList<String> getCleaningCriteria() {
        return cleaningCriteria;
    }

    public static void setCleaningCriteria(ArrayList<String> cleaningCriteria) {
        SMSchedulePersistance.cleaningCriteria = cleaningCriteria;
    }

    public static String getTrainer() {
        return trainer;
    }

    public static void setTrainer(String trainer) {
        SMSchedulePersistance.trainer = trainer;
    }

    public static String getStartDate() {
        return startDate;
    }

    public static void setStartDate(String startDate) {
        SMSchedulePersistance.startDate = startDate;
    }

    public static String getEndDate() {
        return endDate;
    }

    public static void setEndDate(String endDate) {
        SMSchedulePersistance.endDate = endDate;
    }
}
