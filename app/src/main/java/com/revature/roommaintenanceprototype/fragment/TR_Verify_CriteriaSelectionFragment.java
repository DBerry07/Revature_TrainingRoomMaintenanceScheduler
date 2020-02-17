package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.CriteriaAdapter;
import com.revature.roommaintenanceprototype.adapter.TrainerSelectionAdapter;
import com.revature.roommaintenanceprototype.database.tables.RoomTable;
import com.revature.roommaintenanceprototype.database.tables.Task;
import com.revature.roommaintenanceprototype.database.view_model.RoomViewModel;
import com.revature.roommaintenanceprototype.database.view_model.TaskViewModel;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;
import java.util.List;


public class TR_Verify_CriteriaSelectionFragment extends Fragment {
    Button btnCleaningCriteriaSelection;
    RecyclerView rvCleaningCriteria;

    public TR_Verify_CriteriaSelectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_criteria_selection, container, false);

        rvCleaningCriteria = (RecyclerView) rootView.findViewById(R.id.rv_cleaningCriteria);
        rvCleaningCriteria.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCleaningCriteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenMessage.toastShortMsg(getContext(),"Clicked on RVs");
            }
        });
        rvCleaningCriteria.setAdapter( new CriteriaAdapter( (ArrayList<String>) DummyText.getCleaningCriteria() ) );

        //Database
        fetchNames(rvCleaningCriteria);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnCleaningCriteriaSelection = (Button) view.findViewById(R.id.btn_cleaningCriteriaSelection);
        btnCleaningCriteriaSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new TR_Verify_SignatureFragment(), FragmentStringTags.getTR_TrainerSignatureFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    private void fetchNames(final RecyclerView recyclerView){
        TaskViewModel viewModel;
        final ArrayList<String> names = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(
                TaskViewModel.class
        );

        viewModel
                //ViewModel method
                .getAll()
                .observe(getViewLifecycleOwner(), new Observer<List<Task>>() {
                    @Override
                    //This method gets called every time the data in the User table changes...
                    public void onChanged(@Nullable final List<Task> list) {
                        for (Task each : list){
                            names.add(each.getName());
                        }
                        //...hence the reinitialization of the Adapter
                        CriteriaAdapter adapter = new CriteriaAdapter(names);
                        recyclerView.setAdapter(adapter);
                    }
                });
    }
}
