package com.mestodushi.numbersmemory;

import static com.mestodushi.numbersmemory.ActivityTraining.APP_PREFERENCES;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;

import java.util.ArrayList;


public class ActivitySeconds extends AppCompatActivity {

    long delay;
    String delayValue;
    TextView delayForScreen;
    SharedPreferences mSettings;
    public static final String APP_PREFERENCES_DELAY = "exposition_delay";


    Button exitButton, plusButton, minusButton, playButton;

    ConstraintLayout fonSecondActivity;

    ArrayList<Button> buttonList;// массив со всеми кнопками в активити секнд




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconds);
        delayForScreen = findViewById(R.id.textViewDelay);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        if (mSettings.contains(APP_PREFERENCES_DELAY)) {
            delay = mSettings.getLong(APP_PREFERENCES_DELAY, 1000);


           exitButton = findViewById(R.id.exitButton);
            plusButton = findViewById(R.id.onPlusButtonClick);
            minusButton = findViewById(R.id.buttonMinus);
            playButton = findViewById(R.id.playButton);



           fonSecondActivity = findViewById(R.id.fonSecondsActivity);


         // TODO: themeCheckAndChange(); - НАПИСАТЬ РЕАЛИЗАЦИЮ

            // наполняем массив кнопками
            buttonList = new ArrayList<Button>();
            buttonList.add(exitButton);
            buttonList.add(plusButton);
            buttonList.add(minusButton);
            buttonList.add(playButton);

        }


/*
        delay = 2000; // дальше задержка даётся в миллисикундах, по этому здесь 1000 = 1 секунда
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_DELAY, delay);
        editor.apply();


        */

        /*if (delay >= 1) {
            delayValue = Long.toString(delay);*/
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

    public void onMinusButtonClick(View view) { // оброботка нажатия кнопки минус

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


    public void onPlusButtonClick(View view) { // оброботка нажатия кнопки плюс

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

    public void FromActSecndsGoToActTem(View view) { // метод оброботки перехода в активити тем

        Intent intent = new Intent(ActivitySeconds.this, ActivityTem.class);
        startActivity(intent);

    }

    public void goToTrainingFromActSec(View view) { // переход в активити трэйнинг

        Intent intent = new Intent(ActivitySeconds.this, ActivityTraining.class);
        startActivity(intent);

    }





    public void setBlueTheme() {  // установка голубой темы

        //changeButtonColorsToBlue(exitButton);

        for (Button button : buttonList) {
            changeButtonColorsToBlue(button);
        }


        fonSecondActivity.setBackgroundColor(getResources().getColor(R.color.bly));


    }





    public void changeButtonColorsToBlue(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.bly2));
        button.setTextColor(getResources().getColor(R.color.wit2));


    }

    public void setClassicTheme() {

        changeButtonColorsToClassic(exitButton);

        fonSecondActivity.setBackgroundColor(getResources().getColor(R.color.wit2));
    }

    public void changeButtonColorsToClassic(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.wit2));
        button.setTextColor(getResources().getColor(R.color.black));

    }

    public void setRoseTheme() {

        changeButtonColorsToRose(exitButton);

        fonSecondActivity.setBackgroundColor(getResources().getColor(R.color.ros));
    }

    public void changeButtonColorsToRose(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.fil2));
        button.setTextColor(getResources().getColor(R.color.white));

    }



}
