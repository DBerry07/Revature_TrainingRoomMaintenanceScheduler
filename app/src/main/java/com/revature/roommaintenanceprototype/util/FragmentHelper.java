package com.revature.roommaintenanceprototype.util;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;

public class FragmentHelper {

    public static void updateToolbarTitle(final AppCompatActivity activity, String title){
        if( activity != null){
            Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
            if( toolbar != null ){
                toolbar.setTitle(title);
            }else{
                ScreenMessage.toastShortMsg(activity.getApplicationContext(),"Error setting toolbar title");
            }
        }else{
            ScreenMessage.toastShortMsg(activity.getApplicationContext(),"Error cannot set title of null activity");
        }
    }


}
