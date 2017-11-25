package com.example.lenovo.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lenovo on 11/5/2017.
 */

public class LoginActivity extends AppCompatActivity {


    private  static final String CORRECT_EMAIL = "abc@gmail.com";
    private  static  final String CORRECT_PASSWORD = "Abcdefg";//constant attribute form

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgotPassword;
    private TextView btnNewSellerRegsister;
     public static Intent newIntent(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPassword = findViewById(R.id.et_password);
        btnForgotPassword = findViewById(R.id.btn_forget_password);
        btnNewSellerRegsister = findViewById(R.id.btn_new_seller_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailOrPhone = etEmailOrPhone.getText().toString();
                String password = etPassword.getText().toString();

                if(TextUtils.isEmpty(emailOrPhone)){
                    etEmailOrPhone.setError("Email or phone cannot be empty.");
                    return;//no line is not execute below.
                }
                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password cannot be empty.");
                    return;
                }

                if(TextUtils.equals(emailOrPhone,CORRECT_EMAIL) && TextUtils.equals(password,CORRECT_PASSWORD)) {

//                    Toast.makeText(v.getContext(),
//                            "Login Success!",
//                            Toast.LENGTH_LONG).show();
                       Intent intent = MainActivity.newIntent(getApplicationContext());
                       startActivity(intent);
                }
                else
                    Snackbar.make(v, "Incorrect email or password. Please try  again.", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Action", null).show();
            }
        });
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "\"Forgot password\" is coming soon.", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null).show();
            }
        });
        btnNewSellerRegsister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(v, "Registration Screen is coming soon.", Snackbar.LENGTH_INDEFINITE)
//                        .setAction("Action", null).show();
                Intent intent = Registration.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }
}
