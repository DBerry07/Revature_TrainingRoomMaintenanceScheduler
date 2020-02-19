package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.OnSetDateListener;
import com.revature.roommaintenanceprototype.adapter.ReportsAdapter;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.InputProcessing;

public class TR_Reports_DateFragment extends Fragment implements View.OnClickListener{
    ImageView iconStartDate, iconEndDate;
    EditText etStartDate, etEndDate;

    public TR_Reports_DateFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_reports, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_reports);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);

        ReportsAdapter adapter = new ReportsAdapter(getActivity(), DummyText.getReports());
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Reports | "+getString(R.string.title_view_reports) );

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
