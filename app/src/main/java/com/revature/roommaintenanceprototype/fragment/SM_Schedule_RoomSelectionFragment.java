package com.revature.roommaintenanceprototype.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapter.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.util.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;

public class SM_Schedule_RoomSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_room_selection, container, false);
        RecyclerView recyclerView = FragmentHelper.initRecyclerView(rootView,R.id.rv_room_selection, getActivity(),
                new SimpleStringAdapter((ArrayList<String>) DummyText.getRooms() , this));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "SM_Schedule | "+getString(R.string.title_room_selection) );
        navController = Navigation.findNavController(view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        navController.navigate(R.id.action_SM_Schedule_RoomSelectionFragment_to_SM_Schedule_CriteriaSelectionFragment);
    }

}
