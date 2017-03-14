package com.example.user.firebsetest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity  {
    private Button buttonsignin;
    private EditText emailaddresst;
    private EditText passwordtext;
    private TextView signup;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            //profile activity here
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
            finish();
        }
        buttonsignin = (Button) findViewById(R.id.buttonsignin);
        emailaddresst = (EditText) findViewById(R.id.emailaddress);
        passwordtext = (EditText) findViewById(R.id.password);
        signup = (TextView) findViewById(R.id.signup);


        buttonsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void userLogin() {
        String email = emailaddresst.getText().toString().trim();
        String password = passwordtext.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //email是空的
            Toast.makeText(this, "請輸入信箱", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //密碼是空的
            Toast.makeText(this, "請輸入密碼", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("註冊用戶中...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    finish();
                }
            }
        });

  /*  @Override
    public void onClick(View v) {

    }*/
    }
}