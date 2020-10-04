package com.cekeh.mobi3002.simpleuserinterface_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.w("MOBI3002", "MainActivity.onCreate()");
    }

    /**
     * Send message from string_input to a new DisplayActivity
     * @param view View to grab string_input from
     */
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayActivity.class);
        EditText text = findViewById(R.id.string_input);

        Log.w("MOBI3002", "MainActivity.sendMessage()");

        String message = text.getText().toString();
        if(message.isEmpty()) {
            message = "nan";
        }

        intent.putExtra("string_input", message);
        startActivity(intent);
    }
}