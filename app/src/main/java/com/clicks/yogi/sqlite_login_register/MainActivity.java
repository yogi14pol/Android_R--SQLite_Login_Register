package com.clicks.yogi.sqlite_login_register;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button Log_In;
    EditText User_Name, Pass_Word;
    TextView ClcikHere;
    DATABASE_SOURCE DBS;
    String L1, L2, L3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log_In = findViewById(R.id.Log_In);
        User_Name = findViewById(R.id.User_Name);
        Pass_Word = findViewById(R.id.Pass_Word);
        ClcikHere = findViewById(R.id.Click_here);

        ClcikHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        DBS = new DATABASE_SOURCE(getApplicationContext());
        DBS.openDB();

        Log_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1 = User_Name.getText().toString();
                L2 = Pass_Word.getText().toString();
                String UNAME, PWD;

                // DATABASE_SOURCE CLASS METHOD CALLED
                Cursor cursor = DBS.SOURCELOGIN_METHOD();
                cursor.moveToFirst();

                try {
                    boolean present = true;
                    do {
                        UNAME = cursor.getString(cursor.getColumnIndex
                                (MyTableData.DETAILS.USERNAME));
                        PWD = cursor.getString(cursor.getColumnIndex
                                (MyTableData.DETAILS.PASSWORD));

                        if (L1.equals(UNAME) && L2.equals(PWD)) {
                            User_Name.setText("");
                            Pass_Word.setText("");
                            present = false;

                            Intent intent = new Intent(getApplicationContext(), Homepage.class);
                            startActivity(intent);
                        }

                    } while (cursor.moveToNext());

                    if (present) {
                        Toast.makeText(getApplicationContext(), "no account present",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}