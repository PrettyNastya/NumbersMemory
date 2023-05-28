package com.mestodushi.numbersmemory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySeconds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconds);
    }

    public void Click(View view) {

        Intent intent = new Intent(ActivitySeconds.this, ActivitySeconds.class);
        startActivity(intent);

    }
}
