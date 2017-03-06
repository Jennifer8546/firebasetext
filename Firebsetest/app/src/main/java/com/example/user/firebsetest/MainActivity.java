package com.example.user.firebsetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText emailtext;
    private EditText passwordtext;
    private TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=  (Button) findViewById(R.id.signup);
        emailtext =(EditText)findViewById(R.id.emailaddress);
        passwordtext=(EditText)findViewById(R.id.password);
        login=(TextView) findViewById(R.id.login);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
