package com.revature.roommaintenanceprototype.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TransactionController {
    private final String KEY_SM_SCHEDULE_TRANSCATION = "Site Manager Schedule Transaction";
        private final String KEY_SM_SCHEDULE_CAMPUS = "";
        private final String KEY_SM_SCHEDULE_ROOM = "";
        private final String KEY_SM_SCHEDULE_CRITERIA = "";
        private final String KEY_SM_SCHEDULE_TRAINER = "";
        private final String KEY_SM_SCHEDULE_STARTDATE = "";
        private final String KEY_SM_SCHEDULE_ENDDATE = "";

    private final String KEY_TR_VERIFY_TRANSCATION = "Trainer Verify Transaction";
    private final String KEY_TR_DELEGATE_TRANSCATION = "Trainer Verify Transaction";

    private static TransactionController instance;
    private Map<String,Object> allTransactions;

    private TransactionController(){
        this.allTransactions = new HashMap<>();
        /*Site Manager Schedule Transaction Inputs
            Campus:String, Room:String, CleaningCriteria:String[],
            Trainer:String, StartDate:String, EndDate:String
         */
        /*Trainer Verify Transaction Inputs
            Room:String, CleaningCriteria:Map<String,Boolean>, Signature:Bitmap
         */
        /*Trainer Delegate Transaction Inputs
            Trainer:String, Room:String, StartDate:String, EndDate:String
         */
    }

    public TransactionController getInstance(){
        if( instance == null){
            instance = new TransactionController();
        }
        return instance;
    }

    public String getAllTransactionsStringList(){
        StringBuilder string = new StringBuilder();
        Iterator itr = allTransactions.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry mapElement = (Map.Entry) itr.next();
            string.append(mapElement.getKey()+" : "+mapElement.getValue()+"\n");
        }
        return string.toString();
    }
}
