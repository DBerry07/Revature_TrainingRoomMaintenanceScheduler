package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.TrainerSelectionAdapter;

public class TrainerSelectionFragment extends Fragment {

    public TrainerSelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(R.layout.fragment_trainer_selection, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.trainer_selection_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        TrainerSelectionAdapter trainerSelectionAdapter = new TrainerSelectionAdapter(getContext());

        recyclerView.setAdapter(trainerSelectionAdapter);

        return rootView;
    }

}
