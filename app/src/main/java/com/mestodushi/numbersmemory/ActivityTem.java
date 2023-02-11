package com.mestodushi.numbersmemory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class ActivityTem extends AppCompatActivity {

    Button classicThemeButton, mainActivityButton, roseThemeButton,blyThemeButton, button21, button26, button10, button29, button25, button22, button28;

    ConstraintLayout fonThemActivity;

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_THEME = "theme";
    public static final String APP_PREFERENCES_CLASSIC = "classic";
    public static final String APP_PREFERENCES_ORIGINAL = "original";
    public static final String APP_PREFERENCES_ROSE = "rose";
    public static final String APP_PREFERENCES_FIOL = "fiol";

    SharedPreferences mSettings;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem);

        classicThemeButton = findViewById(R.id.button5);
        mainActivityButton = findViewById(R.id.button4);
        roseThemeButton = findViewById(R.id.button6);
        blyThemeButton = findViewById(R.id.button8);
        button21 = findViewById(R.id.button21);
        button26 = findViewById(R.id.button26);
        button10 = findViewById(R.id.button10);
        button29 = findViewById(R.id.button29);
        button25 = findViewById(R.id.button25);
        button22 = findViewById(R.id.button22);
        button28 = findViewById(R.id.button28);

        fonThemActivity = findViewById(R.id.fonThemActivity);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }

    public void setClassicTheme(View view) {

        changeButtonColors(classicThemeButton);
        changeButtonColors(mainActivityButton);
        changeButtonColors(roseThemeButton);
        changeButtonColors(blyThemeButton);
        changeButtonColors(button21);
        changeButtonColors(button26);
        changeButtonColors(button10);
        changeButtonColors(button29);
        changeButtonColors(button25);
        changeButtonColors(button22);
        changeButtonColors(button28);

        fonThemActivity.setBackgroundColor(getResources().getColor(R.color.wit2));

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_CLASSIC);
        editor.apply();


    }

    public void changeButtonColors(Button button){
        button.setBackgroundColor(getResources().getColor(R.color.wit2));
        button.setTextColor(getResources().getColor(R.color.black));

    }

    public void setOrigTheme(View view) {
        changeButtonsColorsToOriginal(classicThemeButton);
        changeButtonsColorsToOriginal(mainActivityButton);
        changeButtonsColorsToOriginal(roseThemeButton);
        changeButtonsColorsToOriginal(blyThemeButton);
        changeButtonsColorsToOriginal(button21);
        changeButtonsColorsToOriginal(button26);
        changeButtonsColorsToOriginal(button10);
        changeButtonsColorsToOriginal(button29);
        changeButtonsColorsToOriginal(button25);
        changeButtonsColorsToOriginal(button22);
        changeButtonsColorsToOriginal(button28);

        fonThemActivity.setBackgroundColor(getResources().getColor(R.color.wit2));

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_ORIGINAL);
        editor.apply();

    }



    public void changeButtonsColorsToOriginal(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.purple_700));
        button.setTextColor(getResources().getColor(R.color.wit2));

    }


    public void setRoseTheme(View view) {
        changeButtonsColorsToRose(classicThemeButton);
        changeButtonsColorsToRose(mainActivityButton);
        changeButtonsColorsToRose(roseThemeButton);
        changeButtonsColorsToRose(blyThemeButton);
        changeButtonsColorsToRose(button21);
        changeButtonsColorsToRose(button26);
        changeButtonsColorsToRose(button10);
        changeButtonsColorsToRose(button29);
        changeButtonsColorsToRose(button25);
        changeButtonsColorsToRose(button22);
        changeButtonsColorsToRose(button28);

        fonThemActivity.setBackgroundColor(getResources().getColor(R.color.ros));
    }
    public void changeButtonsColorsToRose(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.fil2));
        button.setTextColor(getResources().getColor(R.color.wit2));


    }


    public void goToMainFromTem(View view) {

        Intent intent = new Intent(ActivityTem.this, MainActivity.class);
        startActivity(intent);

    }
}
