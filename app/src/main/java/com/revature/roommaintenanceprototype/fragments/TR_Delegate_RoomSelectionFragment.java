package com.revature.roommaintenanceprototype.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.animation.CustomViewAnimator;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRDelegatePersistance;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;

public class TR_Delegate_RoomSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {
    private static final String DEBUG_TAG = "TR_Delegate_RoomSelectionFragment";

    private NavController navController;

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

        ApiRequester.getInstance(getActivity()).fetchRoomByCalendar(getActivity(), 0, adapter, recyclerView);

        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.title_room_selection) );
        navController = Navigation.findNavController(view);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_tr_delegate_room),R.drawable.ic_menu_room);

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
                        R.id.action_TR_Delegate_RoomSelectionFragment_to_TR_Delegate_DateFragment );
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        TRDelegatePersistance.setRoom( FragmentHelper.getSelectedItem(view) );
    }
}
