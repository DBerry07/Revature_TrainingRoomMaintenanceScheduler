package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.TrainerSelectionAdapter;
import com.revature.roommaintenanceprototype.helper.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

public class TR_Delegate_TrainerSelectionFragment extends Fragment {


    public TR_Delegate_TrainerSelectionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(R.layout.fragment_trainer_selection, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.trainer_selection_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        TrainerSelectionAdapter trainerSelectionAdapter = new TrainerSelectionAdapter(getActivity(), DummyText.getTrainers());
        recyclerView.setAdapter(trainerSelectionAdapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Button btnCleaningCriteriaSelection = (Button) view.findViewById(R.id.btn_trainerSelection);
        btnCleaningCriteriaSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new TR_Delegate_RoomSelectionFragment(), FragmentStringTags.getTR_RoomSelectionFragmentTag())
                        .addToBackStack(null)
                        .commit();
            }
        });
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.trainer_option_delegate) );
        super.onViewCreated(view, savedInstanceState);
    }

}
