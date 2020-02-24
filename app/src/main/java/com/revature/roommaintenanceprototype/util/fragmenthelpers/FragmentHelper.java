package com.revature.roommaintenanceprototype.util.fragmenthelpers;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.adapters.SimpleStringAdapter;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRVerifyPersistance;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;

public class FragmentHelper {
    private static final String DEBUG_TAG = "FragmentHelper";

    public static void updateToolbarTitle(final AppCompatActivity activity, String title) {
        if (activity != null) {
            Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
            if (toolbar != null) {
                toolbar.setTitle(title);
            } else {
                ScreenMessage.toastShortMsg(activity.getApplicationContext(), "Error setting toolbar title");
            }
        } else {
            ScreenMessage.toastShortMsg(activity.getApplicationContext(), "Error cannot set title of null activity");
        }
    }

    public static void includeFragmentContent(int fragmentLayoutID, ViewGroup parentLayout, LayoutInflater layoutInflater){
        View fragmentView = layoutInflater.inflate(fragmentLayoutID,(ViewGroup)parentLayout.findViewById(R.id.fragmentPlaceholder));
    }

    public static RecyclerView initRecyclerView(View rootView, int recyclerID, Activity activity, RecyclerView.Adapter recyclerAdapter) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(recyclerID);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((rootView.getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        return  recyclerView;
    }

    public static void navigateBetweenFragments(NavController navController, Bundle bundle, int actionID){
        if(bundle != null){
            navController.navigate(actionID, bundle);
        }else{
            navController.navigate(actionID);
        }
    }

    public static String getSelectedItem(View view){
        TextView tvItemTitle = view.findViewById(R.id.tv_string);
        return tvItemTitle.getText().toString();
    }

    public static String getSelectedDate(EditText editText){
        if(editText != null){
            Log.d(DEBUG_TAG,editText.getText().toString());
            return editText.getText().toString();
        }else{
            Log.d(DEBUG_TAG,"EditText is null");
            return null;
        }
    }

    public static void initFragmentHeader(View rootView, String description, int iconID){
        TextView textView = rootView.findViewById(R.id.tv_descriptionHeader);
        textView.setText(description);

        ImageView imgIcon = rootView.findViewById(R.id.img_iconHeader);
        imgIcon.setImageResource(iconID);
    }

    public static void addRecyclerColor(View container){
        if(container != null){
            container.findViewById(R.id.card_simple_string).setBackgroundColor( container.getResources().getColor(R.color.primeDark2) );
            ((TextView)container.findViewById(R.id.tv_string)).setTextColor( container.getResources().getColor(android.R.color.white) );
        }
    }

    public static void removeRecyclerColor(View container){
        if(container != null){
            container.findViewById(R.id.card_simple_string).setBackgroundColor( container.getResources().getColor(android.R.color.white) );
            ((TextView)container.findViewById(R.id.tv_string)).setTextColor( container.getResources().getColor(R.color.black) );
        }
    }

    public static void restoreSimpleTextChoice(View view, String selectedItem){
        Log.d(DEBUG_TAG,"Trying to store item");
        TextView title = view.findViewById(R.id.tv_string);
        String titleString = title.getText().toString();
        Log.d(DEBUG_TAG,"CURRENT_TITLE: "+titleString+" | SELECTED_ITEM: "+selectedItem);
        if( titleString.equals(selectedItem )){
            addRecyclerColor(view);
        }
    }
}
