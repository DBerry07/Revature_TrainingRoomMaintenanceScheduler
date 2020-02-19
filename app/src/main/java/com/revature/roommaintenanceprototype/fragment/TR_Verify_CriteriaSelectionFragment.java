package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;
import android.util.Log;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapter.OnChangeSwitchState;
import com.revature.roommaintenanceprototype.adapter.OnItemClickListener;
import com.revature.roommaintenanceprototype.util.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class TR_Verify_CriteriaSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener, OnChangeSwitchState {
    RecyclerView rvCleaningCriteria;
    NavController navController;
    Button button;
    Set<String> choosenCriteria = new HashSet<>();
    Bundle bundle;

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
        rvCleaningCriteria.setAdapter( new CriteriaAdapter( (ArrayList<String>) DummyText.getCleaningCriteria(), this,this ));

        button = (Button)rootView.findViewById(R.id.btn_criteriaSelection);
        button.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Verify | "+getString(R.string.title_cleaningCriteria_selection) );

        navController = Navigation.findNavController(view);
        bundle = new Bundle();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_criteriaSelection:
                String[] choosenCriteriaArray = new String[choosenCriteria.size()];
                choosenCriteria.toArray(choosenCriteriaArray);
                ScreenMessage.toastShortMsg(getContext(), getString(R.string.argument_tr_verify_selected_criteria));
                //bundle.putStringArray(getString(R.string.argument_tr_verify_selected_criteria).toString(),choosenCriteriaArray);
                bundle.putString(getString(R.string.argument_tr_verify_selected_room), getArguments().getString( getString(R.string.argument_tr_verify_selected_room) ));

                navController.navigate(R.id.action_TR_Verify_CriteriaSelectionFragment2_to_TR_Verify_SignatureFragment2,bundle);
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        TextView tvTitle = view.findViewById(R.id.tv_cleaningCriteria_item);
        String title = tvTitle.getText().toString();

        Switch swt = view.findViewById(R.id.swt_cleaningCriteria_item);
        boolean isChecked;

        if(swt != null){
            swt.setChecked(!swt.isChecked());
            isChecked = swt.isChecked();
            updateChosenCriteria(title, isChecked);
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
