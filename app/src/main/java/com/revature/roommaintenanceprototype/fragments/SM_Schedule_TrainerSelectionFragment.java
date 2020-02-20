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

public class SM_Schedule_TrainerSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trainer_selection, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    public void init(View view){
        RecyclerView recyclerView = FragmentHelper.initRecyclerView(view,R.id.trainer_selection_recycler, getActivity(),
                new SimpleStringAdapter((ArrayList<String>) DummyText.getTrainers() , this));
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "SM_Schedule | "+getString(R.string.title_trainer_selection) );
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        SMSchedulePersistance.setTrainer( FragmentHelper.getSelectedItem(view) );
        FragmentHelper.navigateBetweenFragments(navController,
                null,
                R.id.action_SM_Schedule_TrainerSelectionFragment_to_SM_Schedule_DelegateDateFragment);
    }

}
