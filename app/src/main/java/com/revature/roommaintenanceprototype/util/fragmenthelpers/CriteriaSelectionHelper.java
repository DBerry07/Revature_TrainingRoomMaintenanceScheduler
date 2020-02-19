package com.revature.roommaintenanceprototype.util.fragmenthelpers;

import android.content.Context;
import android.view.View;
import android.widget.Switch;

import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.OnChangeSwitchState;
import com.revature.roommaintenanceprototype.adapter.OnItemClickListener;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

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
}
