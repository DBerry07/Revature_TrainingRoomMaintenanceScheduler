package com.revature.roommaintenanceprototype.fragment.trainer.delegate.trainer;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.revature.roommaintenanceprototype.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TD_TrainerSelectionFragment extends Fragment {

    NavController navController;
    List<String> trainers = new ArrayList<>(Arrays.asList("Nick", "Mayur", "Uday"));

    public TD_TrainerSelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(R.layout.fragment_room_selection, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.room_selection_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        TD_TrainerSelectionAdapter trainerSelectionAdapter = new TD_TrainerSelectionAdapter(getActivity(), trainers);

        recyclerView.setAdapter(trainerSelectionAdapter);

        return rootView;
    }

}
