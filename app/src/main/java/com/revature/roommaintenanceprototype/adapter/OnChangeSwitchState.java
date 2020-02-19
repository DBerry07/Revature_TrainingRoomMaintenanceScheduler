package com.revature.roommaintenanceprototype.adapter;

import android.view.View;
import android.widget.Switch;

public interface OnChangeSwitchState{
    public void onSwitchChanged(String title,View view, boolean isChecked);
}
