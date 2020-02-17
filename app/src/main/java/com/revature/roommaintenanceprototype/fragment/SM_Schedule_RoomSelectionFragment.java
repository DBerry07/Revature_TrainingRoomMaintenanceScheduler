package com.revature.roommaintenanceprototype.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.util.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

import java.util.ArrayList;

public class SM_Schedule_RoomSelectionFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_room_selection, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.room_selection_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new SimpleStringAdapter( (ArrayList<String>) DummyText.getRooms()));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Button btnRoomSelection = (Button) view.findViewById(R.id.btn_roomSelection);
        btnRoomSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new SM_Schedule_CriteriaSelectionFragment(), FragmentStringTags.getSM_CriteriaSelectionFragmentTag())
                        .addToBackStack(null)
                        .commit();
            }
        });
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.title_room_selection) );
        super.onViewCreated(view, savedInstanceState);
    }

}
