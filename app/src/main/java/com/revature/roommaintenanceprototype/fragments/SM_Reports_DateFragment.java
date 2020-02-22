package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnSetDateListener;
import com.revature.roommaintenanceprototype.adapters.ReportsAdapter;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.DelegateDateHelper;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.InputProcessing;

public class SM_Reports_DateFragment extends Fragment implements View.OnClickListener{
    ImageView iconStartDate, iconEndDate;
    EditText etStartDate, etEndDate;
    RecyclerView recyclerView;
    ReportsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_reports, (ViewGroup) rootView,inflater);
        adapter = new ReportsAdapter(getActivity(), DummyText.getReports());
        recyclerView = FragmentHelper.initRecyclerView(rootView,R.id.rv_reports, getActivity(),
                adapter);

        ApiRequester.getInstance(getActivity()).getSiteManagerReports(getActivity(), adapter, recyclerView);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
        super.onViewCreated(view,savedInstanceState);
    }

    private void init(View view){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "SM_Reports | "+getString(R.string.title_view_reports) );

        iconStartDate = view.findViewById(R.id.img_startDate_icon);
        iconStartDate.setOnClickListener(this);
        iconEndDate = view.findViewById(R.id.img_endDate_icon);
        iconEndDate.setOnClickListener(this);

        etStartDate = (view.findViewById(R.id.et_startDate));
        etEndDate = view.findViewById(R.id.et_endDate);

        ApiRequester.getInstance(getActivity()).getSiteManagerReportsByDate(getActivity(),
                adapter, recyclerView, etStartDate.getText().toString(), etEndDate.getText().toString());

    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.img_startDate_icon:
                DelegateDateHelper.openStartDatePicker(etStartDate,getActivity().getSupportFragmentManager());
                break;
            case R.id.img_endDate_icon:
                DelegateDateHelper.openStartDatePicker(etEndDate,getActivity().getSupportFragmentManager());
                break;
        }
    }
}
