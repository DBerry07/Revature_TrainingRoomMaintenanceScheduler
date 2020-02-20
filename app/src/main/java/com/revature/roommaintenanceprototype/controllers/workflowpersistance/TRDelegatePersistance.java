package com.revature.roommaintenanceprototype.controllers.workflowpersistance;

public final class TRDelegatePersistance {
    private static final String DEBUG_TAG = "TRDelegatePersistance";

    private static String room = "";
    private static String trainer = "";
    private static String startDate = "";
    private static String endDate = "";

    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        TRDelegatePersistance.room = room;
    }

    public static String getTrainer() {
        return trainer;
    }

    public static void setTrainer(String trainer) {
        TRDelegatePersistance.trainer = trainer;
    }

    public static String getStartDate() {
        return startDate;
    }

    public static void setStartDate(String startDate) {
        TRDelegatePersistance.startDate = startDate;
    }

    public static String getEndDate() {
        return endDate;
    }

    public static void setEndDate(String endDate) {
        TRDelegatePersistance.endDate = endDate;
    }
}
