package com.revature.roommaintenanceprototype.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.RoomSelectionAdapter;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.helper.FragmentHelper;
import com.revature.roommaintenanceprototype.adapter.TrainerSelectionAdapter;
import com.revature.roommaintenanceprototype.database.tables.RoomTable;
import com.revature.roommaintenanceprototype.database.view_model.RoomViewModel;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

import java.util.ArrayList;
import java.util.List;

public class TR_Verify_RoomSelectionFragment extends Fragment {
    Button btnRoomSelection;

    //Logged in trainer's user ID
    int userId = 0;


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
        fetchNames(userId, recyclerView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
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
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.trainer_option_verify) );
        super.onViewCreated(view, savedInstanceState);
    }

    private void fetchNames(int userId, final RecyclerView recyclerView){
        RoomViewModel viewModel;
        final List<String> names = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(
                RoomViewModel.class
        );

        viewModel
                //ViewModel method
                .selectOnUserId(userId)
                .observe(getViewLifecycleOwner(), new Observer<List<RoomTable>>() {
            @Override
            //This method gets called every time the data in the User table changes...
            public void onChanged(@Nullable final List<RoomTable> list) {
                for (RoomTable each : list){
                    names.add(each.getName());
                }
                //...hence the reinitialization of the Adapter
                TrainerSelectionAdapter trainerSelectionAdapter = new TrainerSelectionAdapter(getActivity(), names);
                recyclerView.setAdapter(trainerSelectionAdapter);
            }
        });
    }

}
