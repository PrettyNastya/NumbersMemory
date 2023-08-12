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


    long delay;
    String delayValue;
    TextView delayForScreen;
    SharedPreferences mSettings;
    public static final String APP_PREFERENCES_DELAY = "exposition_delay";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconds);
        delayForScreen = findViewById(R.id.textViewDelay);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        if (mSettings.contains(APP_PREFERENCES_DELAY)) {
            delay = mSettings.getLong(APP_PREFERENCES_DELAY, 1000);
        }


/*
        delay = 2000; // дальше задержка даётся в миллисикундах, по этому здесь 1000 = 1 секунда
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_DELAY, delay);
        editor.apply();


        */

        /*if (delay >= 1) {
            // delayValue = Long.toString(delay);*/
            double doubleDelay = (double) delay/1000  ;

            delayValue = String.valueOf(doubleDelay);


            //Источник: https://java-blog.ru/osnovy/perevod-int-string-java

            delayForScreen.setText(delayValue);
        /*} else {
            delayValue = "0.5";
            delayForScreen.setText(delayValue);

        }
*/
    }

    public void onMinusButtonClick(View view) {

        if (delay > 500) {

            delay = delay - 100;

            SharedPreferences.Editor editor = mSettings.edit();
            editor.putLong(APP_PREFERENCES_DELAY, delay);
            editor.apply();

            //delayValue = Long.toString(delay);
            double doubleDelay = (double) delay/1000  ;

            delayValue = String.valueOf(doubleDelay);

            delayForScreen.setText(delayValue);
        } else {

            delay = 500;

            SharedPreferences.Editor editor = mSettings.edit();
            editor.putLong(APP_PREFERENCES_DELAY, delay);
            editor.apply();

            delayValue = "0.5";
            delayForScreen.setText(delayValue);

        }


    }


    public void onPlusButtonClick(View view) {

        if (delay < 10000) {

            delay = delay + 100;

            SharedPreferences.Editor editor = mSettings.edit();
            editor.putLong(APP_PREFERENCES_DELAY, delay);
            editor.apply();

            //delayValue = Long.toString(delay);

            double doubleDelay = (double) delay/1000  ;

            delayValue = String.valueOf(doubleDelay);
            delayForScreen.setText(delayValue);
        }
    }

    public void FromActSecndsGoToActTem(View view) {

        Intent intent = new Intent(ActivitySeconds.this, ActivityTem.class);
        startActivity(intent);

    }

    public void goToTrainingFromActSec(View view) {

        Intent intent = new Intent(ActivitySeconds.this, ActivityTraining.class);
        startActivity(intent);

    }
}
