package com.mestodushi.numbersmemory;

import static com.mestodushi.numbersmemory.ActivityTraining.APP_PREFERENCES;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;


public class ActivitySeconds extends AppCompatActivity {


    int delay;
    String delayValue;
    TextView delayForScreen;
    SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconds);
        delay = 2000; // дальше задержка даётся в миллисикундах, по этому здесь 1000 = 1 секунда

        delayValue = Integer.toString(delay / 1000);
        //Источник: https://java-blog.ru/osnovy/perevod-int-string-java

        delayForScreen = findViewById(R.id.textViewDelay);
        delayForScreen.setText(delayValue);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }

    public void onMinusButtonClick(View view) {

        delay=delay-1000;

        delayValue = Integer.toString(delay / 1000);
        delayForScreen.setText(delayValue);



    /*Intent intent = new Intent(ActivitySeconds.this, ActivitySeconds.class);
        startActivity(intent);
*/
    }


    public void onPlusButtonClick(View view) {


        delay=delay + 1000;

        delayValue = Integer.toString(delay / 1000);
        delayForScreen.setText(delayValue);



    }
}
