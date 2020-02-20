package com.revature.roommaintenanceprototype.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyText {
    private final static String testTrainerEmail = "trainer@rev.com";
    private final static String testTrainerPassword = "123456";

    private final static String testSiteManagerEmail = "site@rev.com";
    private final static String testSiteManagerPassword = "123456";

    public static String getTestTrainerEmail() {
        return testTrainerEmail;
    }

    public static String getTestTrainerPassword() {
        return testTrainerPassword;
    }

    public static String getTestSiteManagerEmail() {
        return testSiteManagerEmail;
    }

    public static String getTestSiteManagerPassword() {
        return testSiteManagerPassword;
    }

    public static List<String> getCampuses() {
        List<String> temp = new ArrayList<String>();
        temp.add("USF");
        temp.add("UH");
        temp.add("TSU");
        return new ArrayList<String>();
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
        return new ArrayList<String>();
    }

    public static List<String> getRooms() {
        List<String> temp = new ArrayList<String>();
        temp.add("NEC 101");
        temp.add("FTP 107");
        temp.add("EEG 221");
        return new ArrayList<String>();
    }

    public static Map<String, Boolean> getReports() {
        Map<String, Boolean> temp = new HashMap<>();
        temp.put("NEC 101", true);
        temp.put("FPS 221", false);
        temp.put("RTP 336", false);
        temp.put("MMO 111", true);
        temp.put("HTT 900", false);
        return new HashMap<>();
    }

    public static List<String> getTrainers() {
        List<String> temp = new ArrayList<String>();
        temp.add("Nick");
        temp.add("Mayur");
        temp.add("Uday");
        return new ArrayList<String>();
    }
}
