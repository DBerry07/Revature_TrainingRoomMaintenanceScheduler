package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

public class TR_Verify_SignatureFragment extends Fragment {


    public TR_Verify_SignatureFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signature, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Verify | "+getString(R.string.title_signature) );
        String selectedRoom = getArguments().getString( getString(R.string.argument_tr_verify_selected_room) );
        String[] selectedCriteria = getArguments().getStringArray(getString(R.string.argument_tr_verify_selected_criteria));

        String results = "";
        results+=selectedRoom;

        if( selectedCriteria != null){
            results+="\n"+selectedCriteria.toString();
        }else{
            ScreenMessage.toastShortMsg(getContext(),"Criteria list is null");
        }

        ScreenMessage.toastShortMsg(getContext(),results);

        super.onViewCreated(view, savedInstanceState);
    }

}
