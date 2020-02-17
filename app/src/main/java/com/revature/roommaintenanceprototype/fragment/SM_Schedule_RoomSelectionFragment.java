package com.revature.roommaintenanceprototype.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.RoomSelectionAdapter;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.helper.FragmentHelper;
import com.revature.roommaintenanceprototype.adapter.TrainerSelectionAdapter;
import com.revature.roommaintenanceprototype.database.tables.RoomTable;
import com.revature.roommaintenanceprototype.database.tables.User;
import com.revature.roommaintenanceprototype.database.view_model.RoomViewModel;
import com.revature.roommaintenanceprototype.database.view_model.UserViewModel;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

import java.util.ArrayList;
import java.util.List;

public class SM_Schedule_RoomSelectionFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_room_selection, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.room_selection_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);
        RoomSelectionAdapter adapter = new RoomSelectionAdapter(getActivity(), DummyText.getRooms());
        recyclerView.setAdapter(adapter);

        //For database
        fetchNames(recyclerView);

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
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.siteManager_option_schedule) );
        super.onViewCreated(view, savedInstanceState);
    }

    private void fetchNames(final RecyclerView recyclerView){
        RoomViewModel viewModel;
        final List<String> names = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(
                RoomViewModel.class
        );

        viewModel.getRooms().observe(getViewLifecycleOwner(), new Observer<List<RoomTable>>() {
            @Override
            //This method gets called every time the data in the User table changes...
            public void onChanged(@Nullable final List<RoomTable> list) {
                for (RoomTable each : list){
                    names.add(each.getName());
                }
                //...hence the reinitialization of the Adapter
                RoomSelectionAdapter selectionAdapter = new RoomSelectionAdapter(getActivity(), names);
                recyclerView.setAdapter(selectionAdapter);
            }
        });
    }

}
