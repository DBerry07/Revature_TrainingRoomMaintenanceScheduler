package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.OnSetDateListener;
import com.revature.roommaintenanceprototype.util.FragmentHelper;
import com.revature.roommaintenanceprototype.util.InputProcessing;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

public class TR_Delegate_DateFragment extends Fragment implements View.OnClickListener{
    ImageView iconStartDate, iconEndDate;
    EditText etStartDate, etEndDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getContext(), "StartDate", Toast.LENGTH_LONG);
        final View rootView =
                inflater.inflate(R.layout.fragment_delegate_date, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Delegate | "+getString(R.string.title_date_selection) );

        iconStartDate = (ImageView)view.findViewById(R.id.img_startDate_icon);
        iconStartDate.setOnClickListener(this);
        iconEndDate = (ImageView)view.findViewById(R.id.img_endDate_icon);
        iconEndDate.setOnClickListener(this);

        etStartDate = (EditText)view.findViewById(R.id.et_startDate);
        etEndDate = (EditText)view.findViewById(R.id.et_endDate);

        String results = "";
        String chosenTrainer = getArguments().getString( getString(R.string.argument_tr_delegate_selected_trainer) );
        results+=" TRAINER: "+chosenTrainer;
        String chosenRoom = getArguments().getString( getString(R.string.argument_tr_delegate_selected_room) );
        results+=" ROOM: "+chosenRoom;
        ScreenMessage.toastShortMsg(getContext(),results);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.img_startDate_icon:DialogFragment startDatePicker = new DatePickerFragment(new OnSetDateListener() {
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
