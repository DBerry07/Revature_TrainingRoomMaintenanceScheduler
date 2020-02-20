package com.revature.roommaintenanceprototype.util;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.revature.roommaintenanceprototype.R;

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

    public static void confirmLogOut(final AppCompatActivity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.logout_confirmation_message);
        builder.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finish();
            }
        });
        builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void displayCompleteTransaction(String transactionValues, AppCompatActivity activity){
        String transactionString = transactionValues;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.title_confirmation);
        builder.setMessage(transactionString);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void displayResults(String results, AppCompatActivity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.review_inputs);
        builder.setView(R.layout.confirmation);
        ((TextView) activity.findViewById(R.id.tv_results)).setText(results);
    }
}
