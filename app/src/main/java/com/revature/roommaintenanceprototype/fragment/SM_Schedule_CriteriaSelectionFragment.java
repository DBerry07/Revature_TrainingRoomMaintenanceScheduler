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
import com.revature.roommaintenanceprototype.helper.FragmentHelper;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;
import com.revature.roommaintenanceprototype.database.api.TaskAPI;

public class SM_Schedule_CriteriaSelectionFragment extends Fragment {
    Button btnCleaningCriteriaSelection;
    RecyclerView rvCleaningCriteria;

    public SM_Schedule_CriteriaSelectionFragment() {
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

        TaskAPI tAPI = new TaskAPI(getActivity());
        tAPI.siteManagerGetTasks(getActivity(), rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        btnCleaningCriteriaSelection = (Button) view.findViewById(R.id.btn_cleaningCriteriaSelection);
        btnCleaningCriteriaSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new SM_Schedule_TrainerSelectionFragment(), FragmentStringTags.getSM_TrainerSelectionFragmentTag())
                        .addToBackStack(null)
                        .commit();
            }
        });

        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.siteManager_option_schedule) );

        super.onViewCreated(view, savedInstanceState);
    }


}
