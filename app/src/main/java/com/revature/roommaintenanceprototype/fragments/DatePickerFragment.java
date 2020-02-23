package com.revature.roommaintenanceprototype.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import com.revature.roommaintenanceprototype.adapters.OnSetDateListener;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private OnSetDateListener setDateListener;

    public DatePickerFragment(OnSetDateListener setDateListener){
        this.setDateListener = setDateListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return new DatePickerDialog(getActivity(),this,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Log.d("Delegate", "Clicked on set date");
        setDateListener.onSetDate(view, year, month, day);
    }


}
