package com.revature.roommaintenanceprototype.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRVerifyPersistance;
import com.revature.roommaintenanceprototype.drawable.SignatureDrawable;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

public class TR_Verify_SignatureFragment extends Fragment {
    private static final String DEBUG_TAG = "TR_Verify_SignatureFragment";
    private ImageView imgSignature;
    private SignatureDrawable signatureDrawable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        FragmentHelper.includeFragmentContent(R.layout.fragment_signature, (ViewGroup) rootView,inflater);
        rootView.post(new Runnable() {
            @Override
            public void run() {
                init(rootView);
                drawSignature(imgSignature);
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
    }



    private void init(View view){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), "TR_Verify | "+getString(R.string.title_signature) );
        imgSignature = view.findViewById(R.id.img_Signature);
        FragmentHelper.initFragmentHeader(view, getString(R.string.description_tr_verify_signature),R.drawable.ic_menu_signature);
    }

    private void drawSignature(ImageView imageView){
        //Log.d("DIMEN",""+imageView.getRootView());
        int viewHeight = imageView.getHeight();
        int viewWidth = imageView.getWidth();
        Log.d("DIMEN","Before call construct");
        signatureDrawable = new SignatureDrawable(viewWidth,viewHeight);
        imageView.setImageBitmap(signatureDrawable.drawPath());
    }
}
