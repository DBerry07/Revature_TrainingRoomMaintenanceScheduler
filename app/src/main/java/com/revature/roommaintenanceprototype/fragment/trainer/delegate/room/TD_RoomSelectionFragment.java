package com.revature.roommaintenanceprototype.fragment.trainer.delegate.room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TD_RoomSelectionFragment extends Fragment {

    NavController navController;
    List<String> rooms = new ArrayList<>(Arrays.asList("NEC 101", "FTP 107", "EEG 221"));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(R.layout.fragment_room_selection, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.room_selection_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        TD_RoomSelectionAdapter trainerSelectionAdapter = new TD_RoomSelectionAdapter(getActivity(), rooms);

        recyclerView.setAdapter(trainerSelectionAdapter);

        return rootView;
    }
}
