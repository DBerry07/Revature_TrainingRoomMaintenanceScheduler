package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.FragmentHelper;

public class TR_Delegate_DateFragment extends Fragment{

    private int sYear;
    private int sMonth;
    private int sDay;

    private int eYear;
    private int eMonth;
    private int eDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getContext(), "StartDate", Toast.LENGTH_LONG);
        final View rootView =
                inflater.inflate(R.layout.fragment_delegate_date, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        FragmentHelper.updateToolbarTitle( (AppCompatActivity) getActivity(), getString(R.string.title_date_selection) );
        super.onViewCreated(view, savedInstanceState);
    }

}
