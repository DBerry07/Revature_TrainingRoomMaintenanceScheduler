package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapters.OnChangeSwitchState;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.animation.CustomViewAnimator;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.SMSchedulePersistance;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.CriteriaSelectionHelper;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SM_Schedule_CriteriaSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener , OnChangeSwitchState {
    private RecyclerView rvCleaningCriteria;
    private NavController navController;
    private Set<String> chosenCriteria = new HashSet<>();

    public SM_Schedule_CriteriaSelectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_criteria_selection, (ViewGroup) rootView,inflater);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }
    
    public void init(View view){
        CriteriaAdapter adapter = new CriteriaAdapter( (ArrayList<String>) DummyText.getCleaningCriteria(),this,this );
        rvCleaningCriteria = FragmentHelper.initRecyclerView(view,R.id.rv_cleaningCriteria, getActivity(), adapter);

        ApiRequester.siteManagerGetTasks(getActivity(), adapter, rvCleaningCriteria);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);
        CustomViewAnimator.animateFloatingActionButtonIn(floatingActionButton);

        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.title_cleaningCriteria_selection) );
        navController = Navigation.findNavController(view);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_sm_sch_criteria),R.drawable.ic_menu_cleaningcriteria);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floatingActionButton:
                SMSchedulePersistance.setCleaningCriteria( CriteriaSelectionHelper.convertSetToList(chosenCriteria) );
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.action_SM_Schedule_CriteriaSelectionFragment_to_SM_Schedule_TrainerSelectionFragment);
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Switch swt = view.findViewById(R.id.swt_cleaningCriteria_item);
        TextView tvTitle = view.findViewById(R.id.tv_cleaningCriteria_item);
        //CriteriaSelectionHelper.updateSwitchState(swt, getContext());
        CriteriaSelectionHelper.updateChosenCriteriaList(chosenCriteria,tvTitle.getText().toString(), swt.isChecked());
    }

    @Override
    public void onSwitchChanged(String title,View view, boolean isChecked){
        CriteriaSelectionHelper.updateChosenCriteriaList(chosenCriteria,title, isChecked);
    }
}
