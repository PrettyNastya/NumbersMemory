package com.mestodushi.numbersmemory;

import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_BLUE;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_CLASSIC;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_ROSE;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_THEME;
import static com.mestodushi.numbersmemory.ActivityTraining.APP_PREFERENCES;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Objects;

public class ActivitiAbout extends AppCompatActivity {

    SharedPreferences mSettings;
    String currentTheme = "";

    Button MenuButton;

    ConstraintLayout fonAboutActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiti_about);

        MenuButton = findViewById(R.id.button23);
        fonAboutActivity = findViewById(R.id.fonAboutActivity);


        themeCheckAndChange();

    }

    public void goToMainFromActAbout(View view) {

        Intent intent = new Intent(ActivitiAbout.this, MainActivity.class);
        startActivity(intent);

    }

    public void setClassicTheme() {

        changeButtonColorsToClassic(MenuButton);

        fonAboutActivity.setBackgroundColor(getResources().getColor(R.color.wit2));
    }

    public void setRoseTheme() {

        changeButtonColorsToRose(MenuButton);

        fonAboutActivity.setBackgroundColor(getResources().getColor(R.color.ros));
    }


    public void setBlueTheme() {

        changeButtonColorsToBlue(MenuButton);

        fonAboutActivity.setBackgroundColor(getResources().getColor(R.color.bly));


    }

    public void changeButtonColorsToBlue(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.bly2));
        button.setTextColor(getResources().getColor(R.color.wit2));


    }


    public void changeButtonColorsToClassic(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.wit2));
        button.setTextColor(getResources().getColor(R.color.black));

    }


    public void changeButtonColorsToRose(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.fil2));
        button.setTextColor(getResources().getColor(R.color.white));

    }


    public void themeCheckAndChange() {

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (mSettings.contains(APP_PREFERENCES_THEME)) {
            currentTheme = mSettings.getString(APP_PREFERENCES_THEME, "");
        }

        if (Objects.equals(currentTheme, APP_PREFERENCES_CLASSIC)) {
            setClassicTheme();

        }
        if (Objects.equals(currentTheme, APP_PREFERENCES_ROSE)) {
            setRoseTheme();

        }


        if (Objects.equals(currentTheme, APP_PREFERENCES_BLUE)) {
            setBlueTheme();

        }

    }
}