package com.github.antho1426.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {
    public static final String EXTRA_USER_NAME = "currentUsername";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        TextView TextViewGreeting = (TextView) findViewById(R.id.text_view_greeting);

        // Getting the intent from the MainActivity
        Intent i = getIntent();
        String username = i.getStringExtra(EXTRA_USER_NAME);

        // Setting the TextView with the value of the "currentUsername"
        // (Cf.: "Android - Set text to TextView" (https://stackoverflow.com/questions/19452269/android-set-text-to-textview))
        TextViewGreeting.setText(("Welcome to you " + username + "!").toString());
    }
}