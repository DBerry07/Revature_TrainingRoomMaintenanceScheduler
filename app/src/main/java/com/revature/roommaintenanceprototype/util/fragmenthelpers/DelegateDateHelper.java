package com.revature.roommaintenanceprototype.util.fragmenthelpers;

import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.revature.roommaintenanceprototype.adapter.OnSetDateListener;
import com.revature.roommaintenanceprototype.fragment.DatePickerFragment;
import com.revature.roommaintenanceprototype.util.InputProcessing;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

public class DelegateDateHelper {
    private static final String DEBUG_TAG = "DelegateDateHelper";

    public static void openStartDatePicker(final EditText etStartDate, FragmentManager fragmentManager){
        createDatePicker(etStartDate,fragmentManager,"StartDate");
    }

    public static void openEndDatePicker(final EditText etEndDate, FragmentManager fragmentManager){
        createDatePicker(etEndDate,fragmentManager,"EndDate");
    }

    private static void createDatePicker (final EditText editText, FragmentManager fragmentManager, String datePickerTag){
        if(fragmentManager != null){
            DialogFragment startDatePicker = new DatePickerFragment(new OnSetDateListener() {
                @Override
                public void onSetDate(DatePicker view, int year, int month, int day) {
                    editText.setText(InputProcessing.formatDate(year, month, day));
                }
            });
            startDatePicker.show(fragmentManager, datePickerTag);
        }else{
            Log.d(DEBUG_TAG,"Error opening date picker. Fragment manager is null.");
        }
    }
}
