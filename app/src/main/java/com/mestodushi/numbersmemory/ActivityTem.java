package com.mestodushi.numbersmemory;

import static com.mestodushi.numbersmemory.ActivityTraining.APP_PREFERENCES;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class ActivityTem extends AppCompatActivity {

    Button classicThemeButton, mainActivityButton, roseThemeButton,blyThemeButton, originale, button26, button10, button29, button25, button22, button28, button27;

    ConstraintLayout fonThemActivity;

    public static final String APP_PREFERENCES_THEME = "theme";
    public static final String APP_PREFERENCES_CLASSIC = "classic";
    public static final String APP_PREFERENCES_ORIGINAL = "original";
    public static final String APP_PREFERENCES_ROSE = "rose";
    public static final String APP_PREFERENCES_BLUE = "blue";

    SharedPreferences mSettings;

    String currentTheme = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem);

        classicThemeButton = findViewById(R.id.button5);
        mainActivityButton = findViewById(R.id.button4);
        roseThemeButton = findViewById(R.id.button6);
        blyThemeButton = findViewById(R.id.button8);
        originale = findViewById(R.id.button21);
        button26 = findViewById(R.id.button26);
        button10 = findViewById(R.id.button10);
        button29 = findViewById(R.id.button29);
        button25 = findViewById(R.id.button25);
        button22 = findViewById(R.id.button22);
        button28 = findViewById(R.id.button28);
        button27 = findViewById(R.id.button27);




        fonThemActivity = findViewById(R.id.fonThemActivity);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        themeCheckAndChange();

    }

    public void setClassicTheme(View view) {

        changeButtonColorsToClassic(classicThemeButton);
        changeButtonColorsToClassic(mainActivityButton);
        changeButtonColorsToClassic(roseThemeButton);
        changeButtonColorsToClassic(blyThemeButton);
        changeButtonColorsToClassic(originale);
        changeButtonColorsToClassic(button26);
        changeButtonColorsToClassic(button10);
        changeButtonColorsToClassic(button29);
        changeButtonColorsToClassic(button25);
        changeButtonColorsToClassic(button22);
        changeButtonColorsToClassic(button28);
        changeButtonColorsToClassic(button27);

        fonThemActivity.setBackgroundColor(getResources().getColor(R.color.wit2));

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_CLASSIC);
        editor.apply();


    }

    public void changeButtonColorsToClassic(Button button){
        button.setBackgroundColor(getResources().getColor(R.color.wit2));
        button.setTextColor(getResources().getColor(R.color.black));

    }

    public void setOrigTheme(View view) {
        changeButtonsColorsToOriginal(classicThemeButton);
        changeButtonsColorsToOriginal(mainActivityButton);
        changeButtonsColorsToOriginal(roseThemeButton);
        changeButtonsColorsToOriginal(blyThemeButton);
        changeButtonsColorsToOriginal(originale);
        changeButtonsColorsToOriginal(button26);
        changeButtonsColorsToOriginal(button10);
        changeButtonsColorsToOriginal(button29);
        changeButtonsColorsToOriginal(button25);
        changeButtonsColorsToOriginal(button22);
        changeButtonsColorsToOriginal(button28);
        changeButtonsColorsToOriginal(button27);

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
        changeButtonsColorsToRose(originale);
        changeButtonsColorsToRose(button26);
        changeButtonsColorsToRose(button10);
        changeButtonsColorsToRose(button29);
        changeButtonsColorsToRose(button25);
        changeButtonsColorsToRose(button22);
        changeButtonsColorsToRose(button28);
        changeButtonsColorsToRose(button27);

        fonThemActivity.setBackgroundColor(getResources().getColor(R.color.ros));

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_ROSE);
        editor.apply();

    }

    public void changeButtonsColorsToRose(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.fil2));
        button.setTextColor(getResources().getColor(R.color.wit2));

    }

    public void setBlueTheme(View view) {
        changeButtonColorsToBlue(classicThemeButton);
        changeButtonColorsToBlue(mainActivityButton);
        changeButtonColorsToBlue(roseThemeButton);
        changeButtonColorsToBlue(blyThemeButton);
        changeButtonColorsToBlue(originale);
        changeButtonColorsToBlue(button26);
        changeButtonColorsToBlue(button10);
        changeButtonColorsToBlue(button29);
        changeButtonColorsToBlue(button25);
        changeButtonColorsToBlue(button22);
        changeButtonColorsToBlue(button28);
        changeButtonColorsToBlue(button27);

        fonThemActivity.setBackgroundColor(getResources().getColor(R.color.bly));

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_BLUE);
        editor.apply();

    }

    public void changeButtonColorsToBlue(Button button){
        button.setBackgroundColor(getResources().getColor(R.color.bly2));
        button.setTextColor(getResources().getColor(R.color.wit2));

    }

    public void goToMainFromTem(View view) {

        Intent intent = new Intent(ActivityTem.this, MainActivity.class);
        startActivity(intent);

    }

    // алгоритм задержки на заданный промежуток времени
    public void timerTest() {

        TimerTask task = new TimerTask() {



            public void run() {

                // взаимодействуем с элементами пользовательского интерфейса (кнопками) только из главного потока
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        makeButtonsInvisible();
                    } // делаем кнопки нивидимыми
                });

            }


        };

        Timer timer = new Timer("Timer");

        long delay = 5000L; // задаётся в миллисикундах, 1000L это 1 секунда, так мы задали задержку на 5 секунд

        timer.schedule(task, delay);

    }

    public void makeButtonsInvisible(){

        blyThemeButton.setVisibility(View.INVISIBLE);
        button10.setVisibility(View.INVISIBLE);
        originale.setVisibility(View.INVISIBLE);

    }

    public void themeCheckAndChange(){


        if (mSettings.contains(APP_PREFERENCES_THEME)) {
            currentTheme = mSettings.getString(APP_PREFERENCES_THEME, "");
        }

        if (Objects.equals(currentTheme, APP_PREFERENCES_CLASSIC)){
            setClassicTheme(classicThemeButton);

        }
        if (Objects.equals(currentTheme, APP_PREFERENCES_ROSE)){
            setRoseTheme(roseThemeButton);

        }
        if (Objects.equals(currentTheme, APP_PREFERENCES_CLASSIC)){
            setBlueTheme(blyThemeButton);

        }


    }

    public void fromActivityTemGoToActSec(View view) {

        Intent intent = new Intent(ActivityTem.this, ActivitySeconds.class);
        startActivity(intent);

    }
}
