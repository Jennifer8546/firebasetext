package com.example.user.firebsetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

        private TextView UserEmail;
        private Button buttonLogout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);

            firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            //profile activity here
            startActivity(new Intent(ProfileActivity.this,loginActivity.class));
            ProfileActivity.this.finish();
        }

        FirebaseUser user =firebaseAuth.getCurrentUser();

        UserEmail=(TextView)findViewById(R.id.textViewUserEmail);
        buttonLogout=(Button)findViewById(R.id.buttonlogout);
        UserEmail.setText("歡迎"+user.getEmail()+"加入!");
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();

                startActivity(new Intent(ProfileActivity.this,loginActivity.class));
                ProfileActivity.this.finish();
            }
        });
    }
}