package com.revature.roommaintenanceprototype.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyText {

    public static List<String> getCampuses() {
        List<String> temp = new ArrayList<String>();
        temp.add("USF");
        temp.add("UH");
        temp.add("TSU");
        return temp;
    }

    public static List<String> getCleaningCriteria() {
        List<String> temp = new ArrayList<String>();
        temp.add("Desks");
        temp.add("Chairs");
        temp.add("Whiteboards");
        temp.add("Tables");
        temp.add("Desks");
        temp.add("Chairs");
        temp.add("Whiteboards");
        temp.add("Tables");
        temp.add("Desks");
        temp.add("Chairs");
        temp.add("Whiteboards");
        temp.add("Tables");
        temp.add("Desks");
        temp.add("Chairs");
        temp.add("Whiteboards");
        temp.add("Tables");
        temp.add("Desks");
        temp.add("Chairs");
        temp.add("Whiteboards");
        temp.add("Tables");
        temp.add("Desks");
        temp.add("Chairs");
        temp.add("Whiteboards");
        temp.add("Tables");
        return temp;
    }

    public static List<String> getRooms() {
        List<String> temp = new ArrayList<String>();
        temp.add("NEC 101");
        temp.add("FTP 107");
        temp.add("EEG 221");
        return temp;
    }

    public static Map<String, Boolean> getReports() {
        Map<String, Boolean> temp = new HashMap<>();
        temp.put("NEC 101", true);
        temp.put("FPS 221", false);
        temp.put("RTP 336", false);
        temp.put("MMO 111", true);
        temp.put("HTT 900", false);
        return temp;
    }

    public static List<String> getTrainers() {
        List<String> temp = new ArrayList<String>();
        temp.add("Nick");
        temp.add("Mayur");
        temp.add("Uday");
        return temp;
    }
}
