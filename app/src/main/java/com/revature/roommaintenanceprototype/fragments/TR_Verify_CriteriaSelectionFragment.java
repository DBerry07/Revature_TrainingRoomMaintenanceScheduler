package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapters.OnChangeSwitchState;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRVerifyPersistance;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.CriteriaSelectionHelper;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class TR_Verify_CriteriaSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener, OnChangeSwitchState {
    RecyclerView rvCleaningCriteria;
    NavController navController;
    Button button;
    Set<String> chosenCriteria = new HashSet<>();
    Bundle bundle;

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
        rvCleaningCriteria = FragmentHelper.initRecyclerView(view,R.id.rv_cleaningCriteria, getActivity(),
                new CriteriaAdapter( (ArrayList<String>) DummyText.getCleaningCriteria(),this,this ));
        button = (Button)view.findViewById(R.id.btn_criteriaSelection);
        button.setOnClickListener(this);
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Verify | "+getString(R.string.title_cleaningCriteria_selection) );
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_criteriaSelection:
                TRVerifyPersistance.setCleaningCriteria( CriteriaSelectionHelper.convertSetToList(chosenCriteria) );
                FragmentHelper.navigateBetweenFragments(navController,
                        null,
                        R.id.action_TR_Verify_CriteriaSelectionFragment2_to_TR_Verify_SignatureFragment2);
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Switch swt = view.findViewById(R.id.swt_cleaningCriteria_item);
        TextView tvTitle = view.findViewById(R.id.tv_cleaningCriteria_item);
        CriteriaSelectionHelper.updateSwitchState(swt, getContext());
        CriteriaSelectionHelper.updateChosenCriteriaList(chosenCriteria,tvTitle.getText().toString(), swt.isChecked());
    }

    @Override
    public void onSwitchChanged(String title,View view, boolean isChecked){
        CriteriaSelectionHelper.updateChosenCriteriaList(chosenCriteria,title, isChecked);
    }
}
