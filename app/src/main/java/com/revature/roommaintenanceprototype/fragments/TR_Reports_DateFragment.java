package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnSetDateListener;
import com.revature.roommaintenanceprototype.adapters.ReportsAdapter;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.DelegateDateHelper;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.InputProcessing;

public class TR_Reports_DateFragment extends Fragment implements View.OnClickListener{
    ImageView iconStartDate, iconEndDate;
    EditText etStartDate, etEndDate;
    RecyclerView recyclerView;
    DateFragmentPojo dateFragmentPojo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_reports, (ViewGroup) rootView,inflater);
        ReportsAdapter adapter = new ReportsAdapter(getActivity(), DummyText.getReports());
        recyclerView = FragmentHelper.initRecyclerView(rootView,R.id.rv_reports, getActivity(),
                adapter);

        ApiRequester.getTrainerReports(getActivity(), adapter, recyclerView, 0);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
        super.onViewCreated(view,savedInstanceState);
    }

    private void init(View view){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.title_view_reports)  );

        iconStartDate = view.findViewById(R.id.img_startDate_icon);
        iconStartDate.setOnClickListener(this);
        iconEndDate = view.findViewById(R.id.img_endDate_icon);
        iconEndDate.setOnClickListener(this);

        etStartDate = (view.findViewById(R.id.et_startDate));
        etEndDate = view.findViewById(R.id.et_endDate);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_tr_rpt_reports),R.drawable.ic_reports);
        dateFragmentPojo = new DateFragmentPojo(-1,-1,-1,-1,-1,-1);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.img_startDate_icon:
                DelegateDateHelper.openStartDatePicker(etStartDate,getActivity().getSupportFragmentManager(),dateFragmentPojo);
                break;
            case R.id.img_endDate_icon:
                DelegateDateHelper.openEndDatePicker(etEndDate,getActivity().getSupportFragmentManager(),dateFragmentPojo);
                break;
        }
    }
}
