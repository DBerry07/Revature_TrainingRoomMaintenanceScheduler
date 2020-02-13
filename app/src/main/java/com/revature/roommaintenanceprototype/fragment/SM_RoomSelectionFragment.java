package com.revature.roommaintenanceprototype.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

public class SM_RoomSelectionFragment extends Fragment {
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_room_selection, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button btnRoomSelection = (Button) view.findViewById(R.id.btn_roomSelection);
        btnRoomSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new SM_CriteriaSelectionFragment(), FragmentStringTags.getSM_CriteriaSelectionFragmentTag())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
