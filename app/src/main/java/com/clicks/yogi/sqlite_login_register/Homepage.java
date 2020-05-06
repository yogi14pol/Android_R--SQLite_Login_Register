package com.clicks.yogi.sqlite_login_register;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Toast.makeText(Homepage.this, "Add your functionality",
                Toast.LENGTH_SHORT).show();

    }
}