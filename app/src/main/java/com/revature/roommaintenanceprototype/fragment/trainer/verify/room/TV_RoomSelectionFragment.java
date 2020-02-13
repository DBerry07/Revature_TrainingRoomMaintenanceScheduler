package com.revature.roommaintenanceprototype.fragment.trainer.verify.room;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.revature.roommaintenanceprototype.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TV_RoomSelectionFragment extends Fragment {

    NavController navController;
    List<String> rooms = new ArrayList<>(Arrays.asList("NEC 101", "FTP 107", "EEG 221"));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_room_selection, container, false);
        navController = Navigation.findNavController(this.getActivity(), R.id.fragment_mainContentContainer);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.room_selection_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);

        TV_RoomSelectionAdapter adapter = new TV_RoomSelectionAdapter(getActivity(), rooms);

        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
