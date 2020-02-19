package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.adapter.TrainerSelectionAdapter;
import com.revature.roommaintenanceprototype.database.api.TrainerAPI;
import com.revature.roommaintenanceprototype.helper.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

import java.util.ArrayList;

public class SM_Schedule_TrainerSelectionFragment extends Fragment {


    public SM_Schedule_TrainerSelectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(R.layout.fragment_trainer_selection, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.trainer_selection_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        TrainerAPI.getTrainers(getActivity(), rootView);
        //recyclerView.setAdapter(new SimpleStringAdapter((ArrayList<String>) DummyText.getRooms()));

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Button btnCleaningCriteriaSelection = (Button) view.findViewById(R.id.btn_trainerSelection);
        btnCleaningCriteriaSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new SM_Schedule_DelegateDateFragment(), FragmentStringTags.getSM_DelegateDateFragmentTag())
                        .addToBackStack(null)
                        .commit();
            }
        });
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.siteManager_option_schedule) );
        super.onViewCreated(view, savedInstanceState);
    }

}
