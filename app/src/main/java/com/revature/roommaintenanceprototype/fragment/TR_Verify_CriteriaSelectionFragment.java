package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapter.OnItemClickListener;
import com.revature.roommaintenanceprototype.util.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;


public class TR_Verify_CriteriaSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {
    RecyclerView rvCleaningCriteria;
    NavController navController;
    Button button;

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
        rvCleaningCriteria.setAdapter( new CriteriaAdapter( (ArrayList<String>) DummyText.getCleaningCriteria(), this ));

        button = (Button)rootView.findViewById(R.id.btn_criteriaSelection);
        button.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Verify | "+getString(R.string.title_cleaningCriteria_selection) );

        navController = Navigation.findNavController(view);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_criteriaSelection:
                navController.navigate(R.id.action_TR_Verify_CriteriaSelectionFragment2_to_TR_Verify_SignatureFragment2);
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
}
