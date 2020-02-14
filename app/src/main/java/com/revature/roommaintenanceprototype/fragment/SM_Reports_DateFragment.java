package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.ReportsAdapter;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.HashMap;

public class SM_Reports_DateFragment extends Fragment {


    public SM_Reports_DateFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_reports, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.reports_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);

        ReportsAdapter adapter = new ReportsAdapter(getActivity(), DummyText.getReports());
        recyclerView.setAdapter(adapter);

        return rootView;
    }



}
