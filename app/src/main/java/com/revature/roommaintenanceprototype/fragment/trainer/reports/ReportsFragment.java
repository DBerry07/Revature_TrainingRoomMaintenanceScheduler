package com.revature.roommaintenanceprototype.fragment.trainer.reports;


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
import com.revature.roommaintenanceprototype.fragment.trainer.verify.criteria.TV_CriteriaSelectionAdapter;
import com.revature.roommaintenanceprototype.fragment.trainer.verify.room.TV_RoomSelectionAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportsFragment extends Fragment {

    NavController navController;
    Map<String, Boolean> roomStatus;

    public ReportsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_reports, container, false);

        roomStatus = new HashMap<>();
        roomStatus.put("NEC 101", true);
        roomStatus.put("FPS 221", false);
        roomStatus.put("RTP 336", false);
        roomStatus.put("MMO 111", true);
        roomStatus.put("HTT 900", false);

        navController = Navigation.findNavController(this.getActivity(), R.id.fragment_mainContentContainer);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.reports_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);

        ReportsAdapter adapter = new ReportsAdapter(getActivity(), roomStatus);

        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
