package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.CriteriaAdapter;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;


public class TR_CriteriaSelectionFragment extends Fragment {
    Button btnCleaningCriteriaSelection;
    RecyclerView rvCleaningCriteria;

    public TR_CriteriaSelectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_criteria_selection, container, false);

        rvCleaningCriteria = (RecyclerView) rootView.findViewById(R.id.rv_cleaningCriteria);
        rvCleaningCriteria.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCleaningCriteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenMessage.toastShortMsg(getContext(),"Clicked on RVs");
            }
        });
        rvCleaningCriteria.setAdapter( new CriteriaAdapter( (ArrayList<String>) DummyText.getCleaningCriteria() ) );
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnCleaningCriteriaSelection = (Button) view.findViewById(R.id.btn_cleaningCriteriaSelection);
        btnCleaningCriteriaSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new TR_SignatureFragment(), FragmentStringTags.getTR_TrainerSignatureFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
}
