package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRDelegatePersistance;
import com.revature.roommaintenanceprototype.util.ScreenMessage;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.DelegateDateHelper;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

public class TR_Delegate_DateFragment extends Fragment implements View.OnClickListener{
    private static final String DEBUG_TAG = "TR_Delegate_DateFragment";

    private ImageView iconStartDate, iconEndDate;
    private EditText etStartDate, etEndDate;
    private Button button;
    DateFragmentPojo dateFragmentPojo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_delegate_date, (ViewGroup) rootView,inflater);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    public void init(View view) {
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.title_date_selection) );
        iconStartDate = view.findViewById(R.id.img_startDate_icon);
        iconStartDate.setOnClickListener(this);
        iconEndDate = view.findViewById(R.id.img_endDate_icon);
        iconEndDate.setOnClickListener(this);
        etStartDate = view.findViewById(R.id.et_startDate);
        etEndDate = view.findViewById(R.id.et_endDate);
        button = view.findViewById(R.id.btn_delegateDate);
        button.setOnClickListener(this);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setVisibility(View.GONE);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_tr_delegate_date),R.drawable.ic_menu_date);
        dateFragmentPojo = new DateFragmentPojo(-1,-1,-1,-1,-1,-1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_startDate_icon:
                Log.d(DEBUG_TAG, "Clicked open start date icon.");
                DelegateDateHelper.openStartDatePicker(etStartDate,getActivity().getSupportFragmentManager(),dateFragmentPojo);
                break;
            case R.id.img_endDate_icon:
                DelegateDateHelper.openEndDatePicker(etEndDate,getActivity().getSupportFragmentManager(),dateFragmentPojo);
                break;
            case R.id.btn_delegateDate:
                TRDelegatePersistance.setStartDate( FragmentHelper.getSelectedDate(etStartDate) );
                TRDelegatePersistance.setEndDate( FragmentHelper.getSelectedDate(etEndDate) );
                Toast.makeText(view.getContext(), "Delegate task submitted successfully!", Toast.LENGTH_LONG).show();

                //ScreenMessage.showResultsInFragment(TRDelegatePersistance.getResults());

                NavController navController  = Navigation.findNavController(view);
                FragmentHelper.navigateBetweenFragments(navController,null,R.id.TR_Delegate_TrainerSelectionFragment);
                break;
        }
    }

}
