package com.mestodushi.numbersmemory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void Click(View view) {

        Intent intent = new Intent(ActivitySecond.this, ActivitySecond.class);
        startActivity(intent);

    }
}
