package com.revature.roommaintenanceprototype.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.RoomSelectionAdapter;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

public class TR_Delegate_RoomSelectionFragment extends Fragment {
    Button btnRoomSelection;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_room_selection, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.room_selection_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);
        RoomSelectionAdapter adapter = new RoomSelectionAdapter(getActivity(), DummyText.getRooms());
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button btnRoomSelection = (Button) view.findViewById(R.id.btn_roomSelection);
        btnRoomSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new TR_Verify_CriteriaSelectionFragment(), FragmentStringTags.getTR_CriteriaSelectionFragmentTag())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
