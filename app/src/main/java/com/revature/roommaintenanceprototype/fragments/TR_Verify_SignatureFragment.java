package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRVerifyPersistance;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.database.table.CompletedTaskList;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;
import java.util.List;

public class TR_Verify_SignatureFragment extends Fragment implements View.OnClickListener {
    private static final String DEBUG_TAG = "TR_Verify_SignatureFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_signature, (ViewGroup) rootView,inflater);
        ((Button) rootView.findViewById(R.id.btn_signatureVerify)).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }

    private void init(View view){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Verify | "+getString(R.string.title_signature) );
    }


    @Override
    public void onClick(View v) {
        ApiRequester.sendTrainerVerify(getActivity(), "100010101", new ArrayList<CompletedTaskList>());
    }
}
