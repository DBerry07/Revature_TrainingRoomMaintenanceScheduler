package com.revature.roommaintenanceprototype.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

public class TR_RoomSelectionFragment extends Fragment {
    Button btnRoomSelection;


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
                        .replace(R.id.fragment_mainContentContainer, new TR_CriteriaSelectionFragment(), FragmentStringTags.getTR_CriteriaSelectionFragmentTag())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
