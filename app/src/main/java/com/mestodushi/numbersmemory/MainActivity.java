package com.mestodushi.numbersmemory;


import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_THEME;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_CLASSIC;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_ROSE;
import static com.mestodushi.numbersmemory.ActivityTraining.APP_PREFERENCES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    SharedPreferences mSettings;
    String currentTheme = "";

    Button startButton, themeButton, aboutButton;

    ConstraintLayout fonMainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.button3);
        themeButton = findViewById(R.id.button);
        aboutButton = findViewById(R.id.button2);
        fonMainActivity = findViewById(R.id.fonMainActivity);

        themeCheckAndChange();


    }


    public void onClickGoToThem(View view) {

        Intent intent = new Intent(MainActivity.this, ActivityTem.class);
        startActivity(intent);

    }

    public void setClassicTheme() {

        changeButtonColorsToClassic(startButton);
        changeButtonColorsToClassic(themeButton);
        changeButtonColorsToClassic(aboutButton);
        fonMainActivity.setBackgroundColor(getResources().getColor(R.color.wit2));
    }

    public void setRoseTheme() {

        changeButtonColorsToRose(startButton);
        changeButtonColorsToRose(themeButton);
        changeButtonColorsToRose(aboutButton);
        fonMainActivity.setBackgroundColor(getResources().getColor(R.color.ros));
    }

    /*
    public void setClassicTheme() {

        changeButtonColorsToClassic(startButton);
        changeButtonColorsToClassic(themeButton);
        changeButtonColorsToClassic(aboutButton);
        fonMainActivity.setBackgroundColor(getResources().getColor(R.color.wit2));
    }

     */
    public void goToTrainingFromMaiCnlick(View view) {

        Intent intent = new Intent(MainActivity.this, ActivityTraining.class);
        startActivity(intent);

    }





    public void changeButtonColorsToClassic(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.wit2));
        button.setTextColor(getResources().getColor(R.color.black));

    }


    public void changeButtonColorsToRose(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.fil2));
        button.setTextColor(getResources().getColor(R.color.white));

    }




    public void themeCheckAndChange(){

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (mSettings.contains(APP_PREFERENCES_THEME)) {
            currentTheme = mSettings.getString(APP_PREFERENCES_THEME, "");
        }

        if (Objects.equals(currentTheme, APP_PREFERENCES_CLASSIC)){
            setClassicTheme();

        }
        if (Objects.equals(currentTheme, APP_PREFERENCES_ROSE)){
            setRoseTheme();

        }

        /*
        if (Objects.equals(currentTheme, APP_PREFERENCES_CLASSIC)){
            setClassicTheme();

        }

         */



    }







}