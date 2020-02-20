package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.SMSchedulePersistance;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;

public class SM_Schedule_CampusSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {
    RecyclerView recyclerView;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_campus_selection, container, false);
        recyclerView = FragmentHelper.initRecyclerView(rootView,R.id.rv_campusSelection, getActivity(),
                new SimpleStringAdapter((ArrayList<String>) DummyText.getCampuses() , this));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "SM_Schedule | "+getString(R.string.title_campus_selection) );
        navController = Navigation.findNavController(view);
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        SMSchedulePersistance.setCampus( FragmentHelper.getSelectedItem(view) );
        FragmentHelper.navigateBetweenFragments(navController,
                null,
                R.id.action_SM_Schedule_CampusSelectionFragment_to_SM_Schedule_RoomSelectionFragment);
    }
}
