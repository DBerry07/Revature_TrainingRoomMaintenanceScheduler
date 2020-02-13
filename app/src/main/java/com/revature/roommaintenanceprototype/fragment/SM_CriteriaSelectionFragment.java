package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

public class SM_CriteriaSelectionFragment extends Fragment {


    public SM_CriteriaSelectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_criteria_selection, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button btnCleaningCriteriaSelection = (Button) view.findViewById(R.id.btn_cleaningCriteriaSelection);
        btnCleaningCriteriaSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new SM_TrainerSelectionFragment(), FragmentStringTags.getSM_TrainerSelectionFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }


}
