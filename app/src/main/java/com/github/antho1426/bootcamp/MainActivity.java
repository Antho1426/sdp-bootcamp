package com.github.antho1426.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cf.: "Get Value of a Edit Text field" (https://stackoverflow.com/questions/4531396/get-value-of-a-edit-text-field)
        Button mButton = (Button) findViewById(R.id.button_greeting_activity);
        EditText mEdit = (EditText) findViewById(R.id.edit_text_username);

        mButton.setOnClickListener(clicked -> {
            String username = mEdit.getText().toString();
            Log.v("TAG", "edit_text_username value: " + username);
            // Intent with the "username" value
            Intent i = new Intent(this, GreetingActivity.class);
            i.putExtra("currentUsername", username);
            startActivity(i);
        });
    }
}