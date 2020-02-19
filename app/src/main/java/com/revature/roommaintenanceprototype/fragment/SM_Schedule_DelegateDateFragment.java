package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.OnSetDateListener;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.InputProcessing;

public class SM_Schedule_DelegateDateFragment extends Fragment implements View.OnClickListener{
    ImageView iconStartDate, iconEndDate;
    EditText etStartDate, etEndDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_delegate_date, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "SM_Schedule | "+getString(R.string.title_date_selection) );

        iconStartDate = (ImageView)view.findViewById(R.id.img_startDate_icon);
        iconStartDate.setOnClickListener(this);
        iconEndDate = (ImageView)view.findViewById(R.id.img_endDate_icon);
        iconEndDate.setOnClickListener(this);

        etStartDate = (EditText)view.findViewById(R.id.et_startDate);
        etEndDate = (EditText)view.findViewById(R.id.et_endDate);

        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.img_startDate_icon:
                DialogFragment startDatePicker = new DatePickerFragment(new OnSetDateListener() {
                    @Override
                    public void onSetDate(DatePicker view, int year, int month, int day) {
                        etStartDate.setText(InputProcessing.formatDate(year,month,day));
                    }
                });
                startDatePicker.show(getActivity().getSupportFragmentManager(),"StartDate");
                break;
            case R.id.img_endDate_icon:DialogFragment endDatePicker = new DatePickerFragment(new OnSetDateListener() {
                @Override
                public void onSetDate(DatePicker view, int year, int month, int day) {
                    etEndDate.setText(InputProcessing.formatDate(year,month,day));
                }
            });
                endDatePicker.show(getActivity().getSupportFragmentManager(),"EndDate");
                break;
        }
    }
}
