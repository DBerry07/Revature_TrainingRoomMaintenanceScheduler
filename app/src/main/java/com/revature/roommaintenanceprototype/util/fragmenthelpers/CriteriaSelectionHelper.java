package com.revature.roommaintenanceprototype.util.fragmenthelpers;

import android.content.Context;
import android.widget.Switch;

import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;
import java.util.Set;

public class CriteriaSelectionHelper{

    public static void updateChosenCriteriaList(Set<String> chosenCriteria, String title, boolean isChecked){
        if( isChecked){
            chosenCriteria.add(title);
        }else{
            chosenCriteria.remove(title);
        }
    }

    public static void updateSwitchState(Switch swt, Context context){
        if(swt != null){
            swt.setChecked(!swt.isChecked());
        }else{
            ScreenMessage.toastShortMsg(context, "Switch is null");
        }
    }

    public static ArrayList<String> convertSetToList(Set<String> criteriaSet){
        ArrayList<String> criteriaList = new ArrayList<>();
        criteriaList.addAll(criteriaSet);
        return criteriaList;
    }
}
