package com.example.user.firebsetest;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText emailtext;
    private EditText passwordtext;
    private TextView login;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        button = (Button) findViewById(R.id.signup);
        emailtext = (EditText) findViewById(R.id.emailaddress);
        passwordtext = (EditText) findViewById(R.id.password);
        login = (TextView) findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void registerUser() {
        String email = emailtext.getText().toString().trim();
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

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "註冊成功!", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, "註冊失敗!請再試一次!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
//
//   View.OnClickListener onClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            if (view == button) {
//                registerUser();
//
//            }
//            if(view== login){
//
//            }
//        }
//    };
}
