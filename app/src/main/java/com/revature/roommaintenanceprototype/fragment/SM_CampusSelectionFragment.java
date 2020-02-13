package com.revature.roommaintenanceprototype.fragment;


import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;
import java.util.Arrays;

public class SM_CampusSelectionFragment extends Fragment {
    Spinner spnCampus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_campus_selection, container, false);

        spnCampus = (Spinner) rootView.findViewById(R.id.spn_campusSelection);
        if(spnCampus != null){
            spnCampus.setAdapter( new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_spinner_item, DummyText.getCampuses()) );
        }else{
            ScreenMessage.toastLongMsg(rootView.getContext(),"Error loading campuses");
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
    }
}
