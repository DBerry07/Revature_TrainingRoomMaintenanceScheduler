package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.SMSchedulePersistance;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.DelegateDateHelper;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

public class SM_Schedule_DelegateDateFragment extends Fragment implements View.OnClickListener {
    private static final String DEBUG_TAG = "SM_Schedule_DelegateDateFragment";

    private ImageView iconStartDate, iconEndDate;
    private EditText etStartDate, etEndDate;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_delegate_date, (ViewGroup) rootView,inflater);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    public void init(View view) {
        FragmentHelper.updateToolbarTitle((AppCompatActivity) getActivity(), getString(R.string.title_date_selection));
        iconStartDate = view.findViewById(R.id.img_startDate_icon);
        iconStartDate.setOnClickListener(this);
        iconEndDate = view.findViewById(R.id.img_endDate_icon);
        iconEndDate.setOnClickListener(this);
        etStartDate = view.findViewById(R.id.et_startDate);
        etEndDate = view.findViewById(R.id.et_endDate);
        button = view.findViewById(R.id.btn_delegateDate);
        button.setOnClickListener(this);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_sm_sch_date),R.drawable.ic_menu_date);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_startDate_icon:
                DelegateDateHelper.openStartDatePicker(etStartDate,getActivity().getSupportFragmentManager());
                break;
            case R.id.img_endDate_icon:
                DelegateDateHelper.openEndDatePicker(etEndDate,getActivity().getSupportFragmentManager());
                break;
            case R.id.btn_delegateDate:
                SMSchedulePersistance.setStartDate( FragmentHelper.getSelectedDate(etStartDate) );
                SMSchedulePersistance.setEndDate( FragmentHelper.getSelectedDate(etEndDate) );
                break;
        }
    }
}
