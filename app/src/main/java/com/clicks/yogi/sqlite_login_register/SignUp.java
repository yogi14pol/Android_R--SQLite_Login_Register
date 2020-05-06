package com.clicks.yogi.sqlite_login_register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText UserName, EmailId, MobileNumber, PassWord, ConfirmPassword;
    Button SignUps;
    TextView LogInPage;
    DATABASE_SOURCE DBSOURCE;
    String s1, s2, s3, s4, s5, s6 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        UserName = findViewById(R.id.User_Name_1);
        EmailId = findViewById(R.id.Email_Id);
        MobileNumber = findViewById(R.id.Mobile_Number);
        PassWord = findViewById(R.id.Pass_Word_1);
        ConfirmPassword = findViewById(R.id.Pass_Word_2);
        SignUps = findViewById(R.id.SignUps);
        LogInPage = findViewById(R.id.LogIn_here);

        // TextView
        LogInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Initialization value of Constructor ...
        DBSOURCE = new DATABASE_SOURCE(getApplicationContext());
        DBSOURCE.openDB();

        // SignUp button...
        SignUps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1 = UserName.getText().toString();
                s2 = EmailId.getText().toString();
                s3 = MobileNumber.getText().toString();
                s4 = PassWord.getText().toString();
                s5 = ConfirmPassword.getText().toString();

                if ((s1).equals(s6) | (s2).equals(s6) | (s3).equals(s6) |
                        (s4).equals(s6) | (s5).equals(s6)) {
                    Toast.makeText(SignUp.this, "Please Fill All The Details",
                            Toast.LENGTH_SHORT).show();

                } else if ((s1.length() < 4)) {
                    Toast.makeText(SignUp.this,
                            "Username should be minimum 4 character", Toast.LENGTH_SHORT).show();

                } else if ((s3.length() < 10)) {
                    Toast.makeText(SignUp.this, "Enter 10 digit Mobile number",
                            Toast.LENGTH_SHORT).show();

                } else if (!(s4.equals(s5))) {
                    Toast.makeText(SignUp.this, "Password Mismatch",
                            Toast.LENGTH_SHORT).show();

                } else if ((s4.length() < 4) | (s5.length() < 4)) {
                    Toast.makeText(SignUp.this,
                            "Password Length should be minimum 4 character", Toast.LENGTH_SHORT).show();

                } else {
                    DBSOURCE.InsertAccountDetails(s1, s2, s3, s4, s5);
                    UserName.setText("");
                    EmailId.setText("");
                    MobileNumber.setText("");
                    PassWord.setText("");
                    ConfirmPassword.setText("");

                    Toast.makeText(SignUp.this, "Now Login With Your Account",
                            Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(in);
                }
            }
        });


    }
}