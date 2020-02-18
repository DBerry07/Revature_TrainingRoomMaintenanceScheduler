package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.util.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;

public class SM_Schedule_CampusSelectionFragment extends Fragment implements View.OnClickListener{
    RecyclerView rvCampuses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_campus_selection, container, false);

        rvCampuses = (RecyclerView) rootView.findViewById(R.id.rv_campusSelection);
        rvCampuses.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.d("TESTING", ""+(new SimpleStringAdapter( (ArrayList<String>) DummyText.getCampuses())).getItemCount() );
        rvCampuses.setAdapter(new SimpleStringAdapter( (ArrayList<String>) DummyText.getCampuses()));

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "SM_Schedule | "+getString(R.string.title_campus_selection) );
        super.onViewCreated(view, savedInstanceState);
    }

    public void onClick(View view){
        switch (view.getId()){
        }
    }
}
