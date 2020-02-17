package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.helper.FragmentHelper;
import com.revature.roommaintenanceprototype.database.view_model.CampusViewModel;
import com.revature.roommaintenanceprototype.database.tables.Campus;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;
import java.util.List;

public class SM_Schedule_CampusSelectionFragment extends Fragment implements View.OnClickListener{
    Button btnCampusSelection;
    RecyclerView rvCampuses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_campus_selection, container, false);

        fetchCampusList(rootView);

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

        rvCampuses = (RecyclerView) rootView.findViewById(R.id.rv_campusSelection);
        rvCampuses.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.d("TESTING", ""+(new SimpleStringAdapter( (ArrayList<String>) DummyText.getCampuses())).getItemCount() );
        rvCampuses.setAdapter(new SimpleStringAdapter( (ArrayList<String>) DummyText.getCampuses()));

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.siteManager_option_schedule) );
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

    private List<String> fetchCampusList(final View rootView){
        CampusViewModel campusViewModel;
        final List<String> names = new ArrayList<>();
        campusViewModel = new ViewModelProvider(this).get(CampusViewModel.class);

        campusViewModel.getCampuses().observe(getViewLifecycleOwner(), new Observer<List<Campus>>() {
            @Override
            public void onChanged(@Nullable final List<Campus> campi) {
                for (Campus each : campi){
                    names.add(each.getName());
                }

                spnCampus.setAdapter( new ArrayAdapter<String>(rootView.getContext(),
                        android.R.layout.simple_spinner_item,
                        names) );
            }
        });

        return names;

    }
}
