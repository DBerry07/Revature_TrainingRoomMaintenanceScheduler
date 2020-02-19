package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.util.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;

public class TR_Delegate_TrainerSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {

    NavController navController;
    Bundle bundle;

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
        recyclerView.setAdapter(new SimpleStringAdapter((ArrayList<String>) DummyText.getTrainers() , this));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Delegate | "+getString(R.string.title_trainer_selection) );

        navController = Navigation.findNavController(view);
        bundle = new Bundle();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        if(view != null){
            ViewGroup container = (ViewGroup)view;
            if( container != null){
                TextView textView = container.findViewById(R.id.tv_string);
                if(textView != null){
                    bundle.putString(getString(R.string.argument_tr_delegate_selected_trainer),textView.getText().toString());
                    navController.navigate(R.id.action_TR_Delegate_TrainerSelectionFragment_to_TR_Delegate_RoomSelectionFragment,bundle);
                }else{
                    ScreenMessage.toastShortMsg(getContext(),"Error reading text.");
                }
            }else{
                ScreenMessage.toastShortMsg(getContext(),"Error selecting container.");
            }
        }else{
            ScreenMessage.toastShortMsg(getContext(),"Error selecting view.");
        }
    }

}
