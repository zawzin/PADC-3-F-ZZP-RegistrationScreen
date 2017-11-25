package com.example.lenovo.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Lenovo on 11/13/2017.
 */
public class Registration extends AppCompatActivity {

    private TextView btnToLogin;
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etAddress;
    private CheckBox cbLatLng;
    private RadioGroup rgRegistration;
    private RadioButton rbFemale;
    private RadioButton rbMale;
    private Button btnRegistration;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, Registration.class);
        return intent;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form);

        btnToLogin = findViewById(R.id.btn_to_login);
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoginActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_registration_password);
        etConfirmPassword = findViewById(R.id.et_registration_confirm_password);
        etAddress = findViewById(R.id.et_registration_address);
        cbLatLng = findViewById(R.id.cb_registration);
        rbFemale = findViewById(R.id.rb_female);
        rbMale = findViewById(R.id.rb_male);
        btnRegistration = findViewById(R.id.btn_registration);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
               String phone_str = etPhone.getText().toString();
                 String email = etEmail.getText().toString();
              final String password = etPassword.getText().toString();
              final  String confirmPassword = etConfirmPassword.getText().toString();
               String address = etAddress.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    etName.setError("Please enter name!");
                    return;
                }
                //int phone = Integer.parseInt(phone_str);
                if (TextUtils.isEmpty(phone_str)) {
                    etPhone.setError("Please enter phone no.!");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Please enter email!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Please enter password!");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    etConfirmPassword.setError("Please retype password!");
                    return;
                }


                if (TextUtils.isEmpty(address)) {
                    etAddress.setError("Please enter address!");
                    return;
                }

                 if (!cbLatLng.isChecked()) {
                    cbLatLng.setError("Please check!");
                return;}

                 if (!rbFemale.isChecked() && !rbMale.isChecked()){
                    rbMale.setError("Please choice gender!");
                return;}

                if(TextUtils.equals(password,confirmPassword)){
                    Intent intent = MainActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                }
                else etConfirmPassword.setError("Please retype password!");

            }
        });
    }
}
