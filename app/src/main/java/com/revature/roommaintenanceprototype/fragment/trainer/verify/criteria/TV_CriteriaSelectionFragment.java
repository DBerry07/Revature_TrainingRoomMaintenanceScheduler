package com.revature.roommaintenanceprototype.fragment.trainer.verify.criteria;


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
import com.revature.roommaintenanceprototype.fragment.trainer.verify.room.TV_RoomSelectionAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TV_CriteriaSelectionFragment extends Fragment {

    NavController navController;
    List<String> criteria = new ArrayList<>(Arrays.asList("Dusting", "Vacuuming", "Tables"));

    public TV_CriteriaSelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_criteria_selection, container, false);
        navController = Navigation.findNavController(this.getActivity(), R.id.fragment_mainContentContainer);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.criteria_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);
        TV_RoomSelectionAdapter adapter = new TV_RoomSelectionAdapter(getActivity(), criteria);
        recyclerView.setAdapter(adapter);

        rootView.findViewById(R.id.criteria_selection_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navController.navigate();
            }
        });

        return rootView;
    }

}
