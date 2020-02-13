package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.revature.roommaintenanceprototype.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SM_CriteriaSelectionFragment extends Fragment {


    public SM_CriteriaSelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_criteria_selection, container, false);
    }

}
