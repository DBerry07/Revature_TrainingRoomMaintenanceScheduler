package com.revature.roommaintenanceprototype.util;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ScreenMessage {

    public static void snackBarShortMsg(View view, String msg){
        Snackbar.make(view,msg,Snackbar.LENGTH_SHORT).show();
    }

    public static void snackBarLongMsg(View view, String msg){
        Snackbar.make(view,msg,Snackbar.LENGTH_LONG).show();
    }

    public static void toastShortMsg(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastLongMsg(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
