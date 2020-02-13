package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

public class SM_TrainerSelectionFragment extends Fragment {


    public SM_TrainerSelectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trainer_selection, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button btnCleaningCriteriaSelection = (Button) view.findViewById(R.id.btn_trainerSelection);
        btnCleaningCriteriaSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new SM_DelegateDateFragment(), FragmentStringTags.getSM_DelegateDateFragmentTag())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
