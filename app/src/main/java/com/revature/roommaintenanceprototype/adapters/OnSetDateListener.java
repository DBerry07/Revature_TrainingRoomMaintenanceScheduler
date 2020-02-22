package com.revature.roommaintenanceprototype.adapters;

import android.widget.DatePicker;

public interface OnSetDateListener {

    public void onSetDate(DatePicker view, int startYear, int startMonth, int startDay,
                          int endYear, int endMonth, int endDay);
}
