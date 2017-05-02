package com.example.wennlab.test;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;

public class MainActivity extends AppCompatActivity {
    EditText etPassword;
    EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      etPassword=(EditText)findViewById(R.id.etPassword);
        etUserName=(EditText)findViewById(R.id.etUserName);

        }

    public void buget(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("Users").child("UserName").setValue(etUserName.getText().toString());
        myRef.child("Users").child("Password").setValue(etPassword.getText().toString());
       // myRef.child("Users").child(etUserName.getText().toString()).child("Username").setValue(etUserName.getText().toString());
        //myRef.child("Users").child(etUserName.getText().toString()).child("Password").setValue(etPassword.getText().toString());



        // Read from the database
   /*  myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
               /* String value = dataSnapshot.getValue(String.class);
                etUserName.setText(value);
                etPassword.setText(value);*/

            }

         //   @Override
        //    public void onCancelled(DatabaseError error) {
                // Failed to read value
         //   }
       // });
    }