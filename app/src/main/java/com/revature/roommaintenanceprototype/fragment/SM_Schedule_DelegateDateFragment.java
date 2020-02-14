package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.helper.FragmentHelper;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;

public class SM_Schedule_DelegateDateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_delegate_date, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.siteManager_option_schedule) );
        super.onViewCreated(view, savedInstanceState);
    }
}
