package com.revature.roommaintenanceprototype.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRDelegatePersistance;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.database.api.TrainerAPI;
import com.revature.roommaintenanceprototype.database.table.User;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;
import java.util.List;

public class TR_Delegate_TrainerSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_trainer_selection, (ViewGroup) rootView,inflater);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    public void init(View view){
        SimpleStringAdapter adapter = new SimpleStringAdapter((ArrayList<String>) DummyText.getTrainers() , this);
        RecyclerView recyclerView = FragmentHelper.initRecyclerView(view,R.id.trainer_selection_recycler, getActivity(), adapter);

        ApiRequester.getInstance(getActivity()).getTrainers(getActivity(), adapter, recyclerView);

        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Delegate | "+getString(R.string.title_trainer_selection) );
        navController = Navigation.findNavController(view);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_tr_delegate_trainer),R.drawable.ic_menu_trainer);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        TRDelegatePersistance.setTrainer( FragmentHelper.getSelectedItem(view) );
        FragmentHelper.navigateBetweenFragments(navController,
                null,
                R.id.action_TR_Delegate_TrainerSelectionFragment_to_TR_Delegate_RoomSelectionFragment);
    }

    public void updateTrainerList(List<User> list, Activity activity, View rootView){
        List<String> emails = new ArrayList<>();
        for (User each : list){
            emails.add(each.getEmail());
        }
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.trainer_selection_recycler);
        recyclerView.setAdapter(new SimpleStringAdapter((ArrayList<String>) emails, this));
    }

}
