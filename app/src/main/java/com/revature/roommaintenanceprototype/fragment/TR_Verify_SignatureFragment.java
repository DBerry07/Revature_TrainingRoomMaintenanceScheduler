package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.helper.FragmentHelper;

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
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.trainer_option_verify) );
        super.onViewCreated(view, savedInstanceState);
    }

}
