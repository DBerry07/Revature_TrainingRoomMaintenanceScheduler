package com.revature.roommaintenanceprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.revature.roommaintenanceprototype.animation.CustomViewAnimator;
import com.revature.roommaintenanceprototype.database.MDatabase;
import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.controllers.LoginController;
import com.revature.roommaintenanceprototype.database.table.User;
import com.revature.roommaintenanceprototype.util.InputProcessing;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_TAG_USER_EMAIL = "EXTRA_TAG_USER_EMAIL";

    private Button btnLogin, btnLogin2;
    public MDatabase db;
    private EditText etEmail, etPassword;
    private TextView tvInvalidEmailMessage, tvInvalidPasswordMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.activity_login);
        etEmail = (EditText) findViewById(R.id.et_login_email);
        etEmail.setOnClickListener(this);
        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                CustomViewAnimator.hideInvalidMessage(tvInvalidEmailMessage);
            }
        });
        etPassword = (EditText) findViewById(R.id.et_login_password);
        etPassword.setOnClickListener(this);
        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                CustomViewAnimator.hideInvalidMessage(tvInvalidPasswordMessage);
            }
        });

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        CustomViewAnimator.animateSplashToLogin(findViewById(R.id.login_activity_container));

        tvInvalidEmailMessage = findViewById(R.id.tv_invalid_email_msg);
        tvInvalidPasswordMessage = findViewById(R.id.tv_invalid_password_msg);
    }

    @Override
    public void onClick(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        switch (view.getId()) {
            case R.id.et_login_email:
                CustomViewAnimator.hideInvalidMessage(tvInvalidEmailMessage);
                break;
            case R.id.et_login_password:
                CustomViewAnimator.hideInvalidMessage(tvInvalidPasswordMessage);
                break;
            case R.id.btn_login:
                processLogin(email, password);
                break;
            case R.id.chk_keep_logged_in:
                break;
        }
    }

    /*
    public void login(View view){
        String email = etEmail.getText().toString();
        switch (view.getId()) {
            case R.id.btn_loginTrainer:
                launchTrainerActivity(email);
                break;
            case R.id.btn_loginSiteManager:
                launchSiteManagerActivity(email);
                break;
        }
    }
*/

    private void processLogin(String email, String password) {
        InputProcessing.InputReturn emailStatus = InputProcessing.validateEmail(email);
        if (emailStatus == InputProcessing.InputReturn.EMPTY_STRING) {
            CustomViewAnimator.showInvalidMessage(tvInvalidEmailMessage, "Email field cannot be empty");
            return;
        } else if (emailStatus == InputProcessing.InputReturn.INVALID_EMAIL) {
            CustomViewAnimator.showInvalidMessage(tvInvalidEmailMessage, "Invalid email entry.");
            return;
        } else if (emailStatus == InputProcessing.InputReturn.OK) {
            InputProcessing.InputReturn passwordStatus = InputProcessing.validatePassword(password);
            if (passwordStatus == InputProcessing.InputReturn.EMPTY_STRING) {
                CustomViewAnimator.showInvalidMessage(tvInvalidPasswordMessage, "Password field cannot be empty");
                return;
            } else if (passwordStatus == InputProcessing.InputReturn.TOO_SHORT) {
                CustomViewAnimator.showInvalidMessage(tvInvalidPasswordMessage, "Password has to be longer than " +
                        InputProcessing.getPasswordMinLength() + " characters.");
            } else if (passwordStatus == InputProcessing.InputReturn.TOO_LONG) {
                CustomViewAnimator.showInvalidMessage(tvInvalidPasswordMessage, "Password has to be shorter than " +
                        InputProcessing.getPasswordMaxLength() + " characters.");
            } else if (passwordStatus == InputProcessing.InputReturn.OK) {
                ApiRequester.getInstance(this).getUsers(this, email, password);
                /*
                List<User> users = Arrays.asList();
                if( LoginController.testLoginCredentials(email, password, users) ){
                    if(email.contains("manager")){
                        launchSiteManagerActivity(email);
                    }else if(email.contains("trainer")){
                        launchTrainerActivity(email);
                    }
                }else{
                    ScreenMessage.toastLongMsg(getApplicationContext(), "Invalid login credentials.");
                }
                */
            }
        }
    }

    private void launchSiteManagerActivity(String email) {
        Intent intent = new Intent(this, SiteManagerActivity.class);
        intent.putExtra(EXTRA_TAG_USER_EMAIL, email);
        startActivity(intent);
    }

    private void launchTrainerActivity(String email) {
        Intent intent = new Intent(this, TrainerActivity.class);
        intent.putExtra(EXTRA_TAG_USER_EMAIL, email);
        startActivity(intent);
    }
}
