package com.revature.roommaintenanceprototype.controllers.workflowpersistance;

import android.graphics.Bitmap;

import java.util.ArrayList;

public final class TRVerifyPersistance {
    private static String room = "";
    private static ArrayList<String> cleaningCriteria = new ArrayList<>();
    private static Bitmap signature;

    public static String getResults(){
        StringBuilder results = new StringBuilder();
        results.append("\n");
        results.append("\n\nROOM | "+room);
        results.append("\nCLEANING CRITERIA | "+cleaningCriteria.toString());
        results.append("\nSIGNATURE | ");
        return results.toString();
    }
    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        TRVerifyPersistance.room = room;
    }

    public static ArrayList<String> getCleaningCriteria() {
        return cleaningCriteria;
    }

    public static void setCleaningCriteria(ArrayList<String> cleaningCriteria) {
        TRVerifyPersistance.cleaningCriteria = cleaningCriteria;
    }

    public static Bitmap getSignature() {
        return signature;
    }

    public static void setSignature(Bitmap signature) {
        TRVerifyPersistance.signature = signature;
    }
}
