package com.example.android.hughstourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TinahelyLoopInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinahely_loop_info);

        // Set onClickListeners on ImageButtons
        // Ref: https://stackoverflow.com/questions/5812744/how-to-set-an-onclick-listener-for-an-imagebutton-in-an-alertdialog

        // Navigate back to the main Activity
        ImageButton homeImageButton = (ImageButton) findViewById(R.id.home_image_button);
        homeImageButton.setOnClickListener(v -> {
            // create a new intent to open the {@link Westlife Activity}
            Intent mainActivty = new Intent(TinahelyLoopInfoActivity.this, MainActivity.class);
            // set the new Westlife activity
            startActivity(mainActivty);
        });
    }
}
