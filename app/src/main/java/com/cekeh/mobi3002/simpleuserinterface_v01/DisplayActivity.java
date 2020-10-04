package com.cekeh.mobi3002.simpleuserinterface_v01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        TextView display_message = findViewById(R.id.display_message);

        display_message.setText(intent.getStringExtra("string_input"));

        Log.w("MOBI3002", "DisplayActivity.onCreate()");
        Log.w("MOBI3002", "Entered: " + display_message.getText().toString());

        try{
        /* FORMAT: #RRGGBB or #AARRGGBB
           The following names are also accepted: red, blue, green, black, white, gray, cyan,
           magenta, yellow, lightgray, darkgray, grey, lightgrey, darkgrey, aqua, fuchsia,
           lime, maroon, navy, olive, purple, silver, and teal. */
            String message = display_message.getText().toString();
            int color = Color.parseColor(message);
            int inverted_color = color ^ 0x00ffffff;

            Log.w("MOBI3002", String.format(
                    "Color: %s, Parsed color: %d, Inverted color: %d",
                    message, color, inverted_color)
            );

            ((ConstraintLayout) display_message.getParent()).setBackgroundColor(color);
            display_message.setTextColor(inverted_color);
        } catch (IllegalArgumentException ignored) {}

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}