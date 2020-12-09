package com.uc.projectmansun.ui.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import com.uc.projectmansun.R;

public class LoginActivity extends AppCompatActivity implements TextWatcher {

    TextInputLayout emaillogin, passlogin;
    String email, pass;
    Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emaillogin = findViewById(R.id.email_login);
        passlogin = findViewById(R.id.password_login);

        emaillogin.getEditText().addTextChangedListener(this);
        passlogin.getEditText().addTextChangedListener(this);

        btn_login = findViewById(R.id.loginbtn);


    }

    public void getData(){
        email = emaillogin.getEditText().getText().toString().trim();
        pass = passlogin.getEditText().getText().toString().trim();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        getData();
        if (!email.isEmpty() && !pass.isEmpty() ){
            btn_login.setEnabled(true);
        }else{
            btn_login.setEnabled(false);
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this, "Insert Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
