package com.revature.roommaintenanceprototype.util.fragmenthelpers;

import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.revature.roommaintenanceprototype.adapters.OnSetDateListener;
import com.revature.roommaintenanceprototype.fragments.DateFragmentPojo;
import com.revature.roommaintenanceprototype.fragments.DatePickerFragment;
import com.revature.roommaintenanceprototype.util.InputProcessing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DelegateDateHelper {
    private static final String DEBUG_TAG = "DelegateDateHelper";
    private static final String startTag = "StartDate";
    private static final String endTag = "EndDate";

    //Need to pass start and end date here
    public static void openStartDatePicker(final EditText etStartDate, FragmentManager fragmentManager, DateFragmentPojo dateFragmentPojo) {
        Log.d(DEBUG_TAG, "Called function to start date picker");
        createDatePicker(etStartDate, fragmentManager, startTag, dateFragmentPojo);
    }

    //Need to pass start and end date here
    public static void openEndDatePicker(final EditText etEndDate, FragmentManager fragmentManager,DateFragmentPojo dateFragmentPojo) {
        createDatePicker(etEndDate, fragmentManager, endTag, dateFragmentPojo);
    }

    private static void createDatePicker(final EditText editText, FragmentManager fragmentManager, final String datePickerTag, final DateFragmentPojo dateFragmentPojo) {
        if (fragmentManager != null) {
            Log.d(DEBUG_TAG, "Fragment manager is not null.");
            DialogFragment datePickerFragment = new DatePickerFragment(new OnSetDateListener() {
                @Override
                public void onSetDate(DatePicker view, int year, int month, int day) {
                    Log.d(DEBUG_TAG, "Attempting to set date.");
                    if (datePickerTag.equals(startTag)) {
                        if (validateDate(year, month, day,
                                dateFragmentPojo.getEndYear(), dateFragmentPojo.getEndMonth(), dateFragmentPojo.getEndDay())) {
                            Log.d(DEBUG_TAG, "Valid date selected.");
                            updateDatePojo(dateFragmentPojo, view,startTag);
                            Log.d(DEBUG_TAG, "Setting start date.");
                            editText.setText(InputProcessing.formatDate(dateFragmentPojo.getStartDay(), dateFragmentPojo.getStartMonth(), dateFragmentPojo.getStartYear()));
                        } else {
                            Log.d(DEBUG_TAG, "Invalid date set in date picker.");
                        }
                    }else{
                        if (validateDate(dateFragmentPojo.getStartYear(), dateFragmentPojo.getStartMonth(), dateFragmentPojo.getStartDay(),
                                year, month, day)) {
                            Log.d(DEBUG_TAG, "Valid date selected.");
                            Log.d(DEBUG_TAG, "Setting end date.");
                            editText.setText(InputProcessing.formatDate(dateFragmentPojo.getEndDay(), dateFragmentPojo.getEndMonth(), dateFragmentPojo.getEndYear()));
                            updateDatePojo(dateFragmentPojo, view,endTag);
                        } else {
                            Log.d(DEBUG_TAG, "Invalid date set in date picker.");
                        }
                    }
                }
            });
            datePickerFragment.show(fragmentManager, datePickerTag);
        } else {
            Log.d(DEBUG_TAG, "Error opening date picker. Fragment manager is null.");
        }
    }

    private static boolean validateDate(int startYear, int startMonth, int startDay,
                                        int endYear, int endMonth, int endDay) {
        return true;
        //NEED TO IMPLEMENT
        /*
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if( Arrays.asList(startYear,startMonth,startDay,endYear,endMonth,endDay).contains(-1) ){
            Log.d(DEBUG_TAG, "One of the values for date is not set yet. Cannot complete validation.");
            return true;
        }
        try {
            Date startDate = simpleDateFormat.parse(startYear+"-"+startMonth+"-"+startDay);
            Date endDate = simpleDateFormat.parse(endYear+"-"+endMonth+"-"+endDay);

            if(startDate.compareTo(endDate) > 0){
                Log.d(DEBUG_TAG, "INVALID: start date occurs after end date");
                return false;
            }
        } catch (ParseException e) {
            Log.d(DEBUG_TAG,"Invalid date format.");
        }
        return true;
        */
    }

    private static void updateDatePojo(DateFragmentPojo dateFragmentPojo, DatePicker datePicker, String tag){
        if(tag.equals(startTag)){
            dateFragmentPojo.setStartDay( datePicker.getDayOfMonth() );
            dateFragmentPojo.setStartMonth( datePicker.getMonth() );
            dateFragmentPojo.setStartYear( datePicker.getYear() );
        }else{
            dateFragmentPojo.setEndDay( datePicker.getDayOfMonth() );
            dateFragmentPojo.setEndMonth( datePicker.getMonth() );
            dateFragmentPojo.setEndYear( datePicker.getYear() );
        }
    }
}
