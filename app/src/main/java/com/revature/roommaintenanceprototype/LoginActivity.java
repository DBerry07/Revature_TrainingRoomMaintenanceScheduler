package com.revature.roommaintenanceprototype;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.revature.roommaintenanceprototype.database.api.APIrequester;
import com.revature.roommaintenanceprototype.controller.LoginController;
import com.revature.roommaintenanceprototype.util.LogStrings;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin;
    EditText etEmail, etPassword;

    String email, password;

    LoginController loginController = new LoginController();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.et_login_email);
        etPassword = (EditText) findViewById(R.id.et_login_password);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();
                if( loginController.processLogin(email, password) ){
                    Intent intent = null;

                    APIrequester.requestLogin(this, email, password);

                    if( email.equals("trainer") ){
                        intent = new Intent(LoginActivity.this, TrainerActivity.class);
                    }else{
                        intent = new Intent(LoginActivity.this, SiteManagerActivity.class);
                    }
                    startActivity(intent);
                    Log.d(LogStrings.LOGIN_TAG, "Login button clicked!");
                }else{
                    ScreenMessage.toastShortMsg(getApplicationContext(),"Invalid Entry");
                }
                break;
        }
    }
}
