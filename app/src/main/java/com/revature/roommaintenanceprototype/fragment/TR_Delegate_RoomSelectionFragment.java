package com.revature.roommaintenanceprototype.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapter.OnItemClickListener;
import com.revature.roommaintenanceprototype.adapter.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;

public class TR_Delegate_RoomSelectionFragment extends Fragment implements View.OnClickListener, OnItemClickListener {
    NavController navController;
    Bundle bundle;

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
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Delegate | "+getString(R.string.title_room_selection) );
        bundle = new Bundle();
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
        if(view != null){
            ViewGroup container = (ViewGroup)view;
            if( container != null){
                TextView textView = container.findViewById(R.id.tv_string);
                if(textView != null){
                    String trainerTaken = getArguments().getString( getString(R.string.argument_tr_delegate_selected_trainer) );
                    bundle.putString(getString(R.string.argument_tr_delegate_selected_trainer), trainerTaken);
                    bundle.putString(getString(R.string.argument_tr_delegate_selected_room),textView.getText().toString());
                    navController.navigate(R.id.action_TR_Delegate_RoomSelectionFragment_to_TR_Delegate_DateFragment,bundle);
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
