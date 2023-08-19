package com.mestodushi.numbersmemory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitiAbout extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_about);

    }

    public void goToMainFromActAbout(View view) {

        Intent intent = new Intent(ActivitiAbout.this, MainActivity.class);
        startActivity(intent);

    }

}