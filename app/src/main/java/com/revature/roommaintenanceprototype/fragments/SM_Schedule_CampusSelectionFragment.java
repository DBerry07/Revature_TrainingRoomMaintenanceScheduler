package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.animation.CustomViewAnimator;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.SMSchedulePersistance;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.database.api.CampusAPI;
import com.revature.roommaintenanceprototype.database.table.Campus;
import com.revature.roommaintenanceprototype.util.ScreenMessage;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class SM_Schedule_CampusSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {
    private static final String DEBUG_TAG = "SM_Schedule_CampusSelectionFragment";

    private RecyclerView recyclerView;
    private NavController navController;
    String description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SimpleStringAdapter adapter = new SimpleStringAdapter((ArrayList<String>) DummyText.getCampuses() , this,SMSchedulePersistance.getCampus());
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_campus_selection, (ViewGroup) rootView,inflater);
        recyclerView = FragmentHelper.initRecyclerView(rootView,R.id.rv_campusSelection, getActivity(), adapter);

        ApiRequester.getInstance(getActivity()).getCampuses(getActivity(), adapter, recyclerView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    private void init(View view){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.title_campus_selection) );
        navController = Navigation.findNavController(view);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_sm_sch_campus),R.drawable.ic_menu_campus);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);
        CustomViewAnimator.animateFloatingActionButtonIn(floatingActionButton);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floatingActionButton:
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.action_SM_Schedule_CampusSelectionFragment_to_SM_Schedule_RoomSelectionFragment);
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        SMSchedulePersistance.setCampus( FragmentHelper.getSelectedItem(view) );
        ArrayList<View> list = ((SimpleStringAdapter)recyclerView.getAdapter()).getListOfItems();
        int itemCount = list.size();
        for(int i =0 ; i<itemCount; i++){
            FragmentHelper.removeRecyclerColor( list.get(i) );
        }
        FragmentHelper.addRecyclerColor(view);
    }
}
