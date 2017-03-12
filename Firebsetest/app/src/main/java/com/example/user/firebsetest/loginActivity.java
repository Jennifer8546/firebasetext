package com.example.user.firebsetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity  {
    private Button buttonsignin;
    private EditText emailaddresst;
    private EditText passwordtext;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                finish();
              //startActivity(new Intent(MainActivity.class));
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

 /*@Override
    public void onClick(View view) {
        if (view= buttonsignin) {
            userLogin();
        }
        if (view = signup) {
            finish();
            startActivities(new Intent(this.MainActivity.class));
        }*/

    }
}