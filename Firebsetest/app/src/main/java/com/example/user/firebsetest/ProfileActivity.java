package com.example.user.firebsetest;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.google.firebase.auth.FirebaseAuth;
    import com.google.firebase.auth.FirebaseUser;
    import com.google.firebase.database.DatabaseReference;
    import com.google.firebase.database.FirebaseDatabase;

    public class ProfileActivity extends AppCompatActivity {

        private FirebaseAuth firebaseAuth;

        private TextView UserEmail;
        private Button buttonLogout;
        private DatabaseReference databaseReference;
        private EditText editTextUserName,editTextUserNumber;
    private Button buttonEnter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            //profile activity here
            startActivity(new Intent(ProfileActivity.this, loginActivity.class));
            ProfileActivity.this.finish();
        }
        databaseReference = FirebaseDatabase.getInstance().getReference();
        editTextUserName = (EditText) findViewById(R.id.UserName);
        editTextUserNumber = (EditText) findViewById(R.id.UserNumber);
        buttonEnter = (Button) findViewById(R.id.buttonenter);
        buttonLogout = (Button) findViewById(R.id.buttonlogout);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInformation();
            }
        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();

                startActivity(new Intent(ProfileActivity.this, loginActivity.class));
                ProfileActivity.this.finish();
            }
        });

        UserEmail.setText("歡迎" + user.getEmail() + "加入!");
    }
    private void saveUserInformation() {
        String name = editTextUserName.getText().toString().trim();
        String number = editTextUserNumber.getText().toString().trim();

        UserInformation userInformation = new UserInformation(name, number);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this, "儲存資料中...", Toast.LENGTH_LONG).show();
    }

}
