package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.animation.CustomViewAnimator;
import com.revature.roommaintenanceprototype.drawable.SignatureDrawable;
import com.revature.roommaintenanceprototype.adapters.OnItemClickListener;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRVerifyPersistance;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.database.table.CompletedTaskList;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

import java.util.ArrayList;
import java.util.List;

public class TR_Verify_SignatureFragment extends Fragment implements View.OnClickListener {
    private static final String DEBUG_TAG = "TR_Verify_SignatureFragment";
    private FrameLayout imgSignatureContainer;
    private SignatureDrawable signatureDrawable;
    private Button btnClearSignature;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_signature, (ViewGroup) rootView,inflater);
        rootView.post(new Runnable() {
            @Override
            public void run() {
                init(rootView);
            }
        });
        ((Button) rootView.findViewById(R.id.btn_signatureVerify)).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        init(view);
        super.onViewCreated(view, savedInstanceState);
    }



    private void init(View view){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.title_signature) );
        imgSignatureContainer = view.findViewById(R.id.signatureContainer);
        signatureDrawable = new SignatureDrawable(getContext());
        imgSignatureContainer.addView(signatureDrawable);
        btnClearSignature = view.findViewById(R.id.btn_clearSignature);
        btnClearSignature.setOnClickListener(this);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_tr_verify_signature),R.drawable.ic_menu_signature);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_clearSignature:
                signatureDrawable.clearCanvas();
                break;
            case R.id.btn_signatureVerify:

                NavController navController  = Navigation.findNavController(v);
                FragmentHelper.navigateBetweenFragments(navController,null,R.id.TR_Verify_RoomSelectionFragment2);
            ApiRequester.sendTrainerVerify(getActivity(), "100010101", new ArrayList<CompletedTaskList>());
            break;
        }
    }
}
