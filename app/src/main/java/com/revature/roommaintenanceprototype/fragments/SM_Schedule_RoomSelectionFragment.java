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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.animation.CustomViewAnimator;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.SMSchedulePersistance;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;

public class SM_Schedule_RoomSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_room_selection, (ViewGroup) rootView,inflater);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    public void init(View view){
        SimpleStringAdapter adapter = new SimpleStringAdapter((ArrayList<String>) DummyText.getRooms() , this);
        RecyclerView recyclerView = FragmentHelper.initRecyclerView(view,R.id.rv_room_selection, getActivity(), adapter);
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.title_room_selection) );

        ApiRequester.getInstance(getActivity()).getRoomByCampusAndLocation(getActivity(), 0, 0, adapter, recyclerView);

        navController = Navigation.findNavController(view);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_sm_sch_room),R.drawable.ic_menu_room);

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
                        R.id.action_SM_Schedule_RoomSelectionFragment_to_SM_Schedule_CriteriaSelectionFragment );
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        SMSchedulePersistance.setRoom( FragmentHelper.getSelectedItem(view) );
    }

}
