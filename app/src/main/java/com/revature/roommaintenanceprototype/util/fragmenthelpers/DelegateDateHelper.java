package com.revature.roommaintenanceprototype.util.fragmenthelpers;

import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.revature.roommaintenanceprototype.adapters.OnSetDateListener;
import com.revature.roommaintenanceprototype.fragments.DatePickerFragment;
import com.revature.roommaintenanceprototype.util.InputProcessing;

public class DelegateDateHelper {
    private static final String DEBUG_TAG = "DelegateDateHelper";

    //Need to pass start and end date here
    public static void openStartDatePicker(final EditText etStartDate, FragmentManager fragmentManager){
        createDatePicker(etStartDate,fragmentManager,"StartDate");
    }

    //Need to pass start and end date here
    public static void openEndDatePicker(final EditText etEndDate, FragmentManager fragmentManager){
        createDatePicker(etEndDate,fragmentManager,"EndDate");
    }

    private static void createDatePicker (final EditText editText, FragmentManager fragmentManager, String datePickerTag){
        if(fragmentManager != null){
            DialogFragment startDatePicker = new DatePickerFragment(new OnSetDateListener() {
                @Override
                public void onSetDate(DatePicker view, int startYear, int startMonth, int startDay,
                                      int endYear, int endMonth, int endDay) {
        //NEED TO DO VALIDATION HERE
                    month++; //Because month is zero indexed
                    editText.setText(InputProcessing.formatDate(year, month, day));
                }
            });
            startDatePicker.show(fragmentManager, datePickerTag);
        }else{
            Log.d(DEBUG_TAG,"Error opening date picker. Fragment manager is null.");
        }
    }

    private boolean validateDate(int startYear, int startMonth, int startDay,
                              int endYear, int endMonth, int endDay){
        return false;
    }
}
