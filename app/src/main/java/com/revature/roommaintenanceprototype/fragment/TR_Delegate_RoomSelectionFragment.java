package com.revature.roommaintenanceprototype.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.util.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;

public class TR_Delegate_RoomSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {
    RecyclerView recyclerView;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_room_selection, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_room_selection);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new SimpleStringAdapter((ArrayList<String>) DummyText.getRooms() , this));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Delegate | "+getString(R.string.title_room_selection) );

        recyclerView.setOnClickListener(this);

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
        navController.navigate(R.id.action_TR_Delegate_RoomSelectionFragment_to_TR_Delegate_DateFragment);
    }
}
