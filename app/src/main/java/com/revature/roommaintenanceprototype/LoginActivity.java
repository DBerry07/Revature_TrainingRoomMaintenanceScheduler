package com.revature.roommaintenanceprototype;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


import com.revature.roommaintenanceprototype.animation.CustomViewAnimator;
import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.database.api.UserAPI;
import com.revature.roommaintenanceprototype.controllers.LoginController;
import com.revature.roommaintenanceprototype.database.table.User;
import com.revature.roommaintenanceprototype.util.LogStrings;
import com.revature.roommaintenanceprototype.controllers.LoginController;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.InputProcessing;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRA_TAG_USER_EMAIL = "EXTRA_TAG_USER_EMAIL";

    private Button btnLogin,btnLogin2;
    public MDatabase db;
    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        setContentView(R.layout.activity_login);
        etEmail = (EditText) findViewById(R.id.et_login_email);
        etPassword = (EditText) findViewById(R.id.et_login_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        btnLogin2 = (Button) findViewById(R.id.btn_login2);
        btnLogin2.setOnClickListener(this);
        CustomViewAnimator.animateSplashToLogin( findViewById(R.id.login_activity_container) );
    }

    @Override
    public void onClick(View view){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        switch (view.getId()){
            case R.id.btn_login:
                processLogin(email,password);
                break;
            case R.id.chk_keep_logged_in:
                break;
        }
    }

    private void processLogin(String email, String password){
        InputProcessing.InputReturn emailStatus = InputProcessing.validateEmail(email);
        if( emailStatus == InputProcessing.InputReturn.EMPTY_STRING){
            ScreenMessage.toastLongMsg(getApplicationContext(), "Email field cannot be empty");
            return;
        }else if( emailStatus == InputProcessing.InputReturn.INVALID_EMAIL ){
            ScreenMessage.toastLongMsg(getApplicationContext(), "Invalid email entry.");
            return;
        }else if( emailStatus == InputProcessing.InputReturn.OK ){
            InputProcessing.InputReturn passwordStatus = InputProcessing.validatePassword(password);
            if(  passwordStatus == InputProcessing.InputReturn.EMPTY_STRING ){
                ScreenMessage.toastLongMsg(getApplicationContext(), "Password field cannot be empty");
                return;
            }else if(passwordStatus == InputProcessing.InputReturn.TOO_SHORT){
                ScreenMessage.toastLongMsg(getApplicationContext(), "Password has to be longer than "+
                        InputProcessing.getPasswordMinLength()+" characters.");
            }else if(passwordStatus == InputProcessing.InputReturn.TOO_LONG){
                ScreenMessage.toastLongMsg(getApplicationContext(), "Password has to be shorter than "+
                        InputProcessing.getPasswordMaxLength()+" characters.");
            }else if( passwordStatus == InputProcessing.InputReturn.OK){
                ApiRequester.getInstance(this).getUsers(this, email, password);
                if( LoginController.testLoginCredentials(email, password, users) ){
                    if(email.contains("manager")){
                        launchSiteManagerActivity(email);
                    }else if(email.contains("trainer")){
                        launchTrainerActivity(email);
                    }
                }else{
                    ScreenMessage.toastLongMsg(getApplicationContext(), "Invalid login credentials.");
                }
            }
        }
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
