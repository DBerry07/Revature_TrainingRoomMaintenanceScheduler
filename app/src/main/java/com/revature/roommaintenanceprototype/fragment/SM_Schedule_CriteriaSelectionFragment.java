package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapter.OnChangeSwitchState;
import com.revature.roommaintenanceprototype.adapter.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.util.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SM_Schedule_CriteriaSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener , OnChangeSwitchState {
    RecyclerView rvCleaningCriteria;
    NavController navController;
    Button button;
    Set<String> choosenCriteria = new HashSet<>();

    public SM_Schedule_CriteriaSelectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_criteria_selection, container, false);
        rvCleaningCriteria = FragmentHelper.initRecyclerView(rootView,R.id.rv_cleaningCriteria, getActivity(),
                new CriteriaAdapter( (ArrayList<String>) DummyText.getCleaningCriteria(),this,this ));
        button = (Button)rootView.findViewById(R.id.btn_criteriaSelection);
        button.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "SM_Schedule | "+getString(R.string.title_cleaningCriteria_selection) );
        navController = Navigation.findNavController(view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_criteriaSelection:
                navController.navigate(R.id.action_SM_Schedule_CriteriaSelectionFragment_to_SM_Schedule_TrainerSelectionFragment);
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Switch swt = view.findViewById(R.id.swt_cleaningCriteria_item);
        if(swt != null){
            swt.setChecked(!swt.isChecked());
        }else{
            ScreenMessage.toastShortMsg(getContext(), "Switch is null");
        }
    }

    @Override
    public void onSwitchChanged(String title,View view, boolean isChecked){
        updateChosenCriteria(title, isChecked);
    }

    private void updateChosenCriteria(String title, boolean isChecked){
        if( isChecked){
            choosenCriteria.add(title);
        }else{
            choosenCriteria.remove(title);
        }
    }

}
