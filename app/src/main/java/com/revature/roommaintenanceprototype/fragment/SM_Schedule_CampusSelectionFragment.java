package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

public class SM_Schedule_CampusSelectionFragment extends Fragment implements View.OnClickListener{
    Spinner spnCampus;
    Button btnCampusSelection;

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

        btnCampusSelection = (Button)rootView.findViewById(R.id.btn_campusSelection);
        if(btnCampusSelection != null){
            btnCampusSelection.setOnClickListener(this);
        }else{
            ScreenMessage.toastLongMsg(rootView.getContext(),"Error loading button action for campus selection.");
        }

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_campusSelection:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new SM_Schedule_RoomSelectionFragment(), FragmentStringTags.getSM_RoomSelectionFragmentTag())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
