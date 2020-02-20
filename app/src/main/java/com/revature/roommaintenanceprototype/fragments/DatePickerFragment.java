package com.revature.roommaintenanceprototype.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import com.revature.roommaintenanceprototype.adapters.OnSetDateListener;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private Calendar c = Calendar.getInstance();
    int year, month, day;
    private OnSetDateListener setDateListener;

    public DatePickerFragment(OnSetDateListener setDateListener){
        this.setDateListener = setDateListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        this.c = Calendar.getInstance();
        this.year = c.get(Calendar.YEAR);
        this.month = c.get(Calendar.MONTH);
        this.day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        setDateListener.onSetDate(view, year, month, day);
    }

    @Override
    public String toString(){
        return year+"/"+month+"/"+day;
    }

}
