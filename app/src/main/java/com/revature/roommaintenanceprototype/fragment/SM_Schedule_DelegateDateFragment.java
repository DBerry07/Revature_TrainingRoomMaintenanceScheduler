package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.DelegateDateHelper;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

public class SM_Schedule_DelegateDateFragment extends Fragment implements View.OnClickListener {
    private ImageView iconStartDate, iconEndDate;
    private EditText etStartDate, etEndDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_delegate_date, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    public void init(View view) {
        FragmentHelper.updateToolbarTitle((AppCompatActivity) getActivity(), "SM_Schedule | " + getString(R.string.title_date_selection));
        iconStartDate = (ImageView) view.findViewById(R.id.img_startDate_icon);
        iconStartDate.setOnClickListener(this);
        iconEndDate = (ImageView) view.findViewById(R.id.img_endDate_icon);
        iconEndDate.setOnClickListener(this);
        etStartDate = (EditText) view.findViewById(R.id.et_startDate);
        etEndDate = (EditText) view.findViewById(R.id.et_endDate);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_startDate_icon:
                DelegateDateHelper.openStartDatePicker(etStartDate,getActivity().getSupportFragmentManager());
                break;
            case R.id.img_endDate_icon:
                DelegateDateHelper.openStartDatePicker(etEndDate,getActivity().getSupportFragmentManager());
                break;
        }
    }
}
