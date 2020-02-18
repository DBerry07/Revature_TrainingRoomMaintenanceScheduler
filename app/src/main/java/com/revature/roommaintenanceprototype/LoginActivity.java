package com.revature.roommaintenanceprototype;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.revature.roommaintenanceprototype.database.api.APIrequester;
import com.revature.roommaintenanceprototype.controller.LoginController;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.InputProcessing;
import com.revature.roommaintenanceprototype.util.LogStrings;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRA_TAG_USER_EMAIL = "EXTRA_TAG_USER_EMAIL";

    Button btnLogin;
    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.et_login_email);
        etPassword = (EditText) findViewById(R.id.et_login_password);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }


    private void launchSiteManagerActivity(String email){
        Intent intent = new Intent( this, SiteManagerActivity.class );
        intent.putExtra(EXTRA_TAG_USER_EMAIL,email);
        startActivity(intent);
    }

    private void launchTrainerActivity(String email){
        Intent intent = new Intent( this, TrainerActivity.class );
        intent.putExtra(EXTRA_TAG_USER_EMAIL,email);
        startActivity(intent);
    }
}
