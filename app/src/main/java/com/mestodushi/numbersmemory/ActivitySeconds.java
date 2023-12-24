package com.mestodushi.numbersmemory;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_BLUE;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_ORIGINAL;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_ROSE;
import static com.mestodushi.numbersmemory.ActivityTraining.APP_PREFERENCES;
import static com.mestodushi.numbersmemory.ActivityTraining.APP_PREFERENCES_CLASSIC;
import static com.mestodushi.numbersmemory.ActivityTraining.APP_PREFERENCES_THEME;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Objects;


public class ActivitySeconds extends AppCompatActivity {

    long delay;
    String delayValue;
    int cvetFonaRabochiy; //TODO: Взято из трэйнинг активити нуэно разобраться кто использует эту переменную
    TextView delayForScreen;
    String currentTheme = "";
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
        double doubleDelay = (double) delay / 1000;

        delayValue = String.valueOf(doubleDelay);


        //Источник: https://java-blog.ru/osnovy/perevod-int-string-java

        delayForScreen.setText(delayValue);
        Log.i(TAG, "В ActivitySeconds внутри onCreate вызваем themeCheckAndChange") ;
        themeCheckAndChange();


    }

    public void onMinusButtonClick(View view) { // оброботка нажатия кнопки минус

        if (delay > 500) {

            delay = delay - 100;

            SharedPreferences.Editor editor = mSettings.edit();
            editor.putLong(APP_PREFERENCES_DELAY, delay);
            editor.apply();

            //delayValue = Long.toString(delay);
            double doubleDelay = (double) delay / 1000;

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

            double doubleDelay = (double) delay / 1000;

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

            Log.i(TAG, "В ActivitySeconds внутри setBlueTheme вызвали changeButtonColorsToBlue для кнопки " + button);

        }


        fonSecondActivity.setBackgroundColor(getResources().getColor(R.color.bly));


    }


    public void changeButtonColorsToBlue(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.bly2));
        Log.i(TAG, "В ActivitySeconds внутри changeButtonColorsToBlue вызвали setBackgroundColor для кнопки " + button);
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

    private void setOriginalTheme() { // TODO: Сделать реализацию оригинальной темы

        for (Button button : buttonList) {
            changeButtonsColorsToOriginale(button);
        }

        fonSecondActivity.setBackgroundColor(getResources().getColor(R.color.wit2));
        cvetFonaRabochiy = getResources().getColor(R.color.wit2);

        /*SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_ROSE);
        editor.apply();*/


    }

    private void changeButtonsColorsToOriginale(Button button) {

        button.setBackgroundColor(getResources().getColor(R.color.purple_500));
        button.setTextColor(getResources().getColor(R.color.wit2));

    }


    public void themeCheckAndChange() {

        Log.i(TAG, "В ActivitySeconds зашли в themeCheckAndChange ");

        if (mSettings.contains(APP_PREFERENCES_THEME)) { // если существует такой ключ APP_PREFERENCES_THEME, то
            currentTheme = mSettings.getString(APP_PREFERENCES_THEME, ""); // присваиваем переменной класса currentTheme строковое значение темы (если ничего нет, то присваиваем пустоту)
        }

        // если тема классическая - реализуем её
        if (Objects.equals(currentTheme, APP_PREFERENCES_CLASSIC)) {
            Log.i(TAG, "В ActivitySeconds внутри themeCheckAndChange при проверке SharedPreferences  переменная currentTheme равна " + currentTheme);
            setClassicTheme();
        }

        // если тема розовая - реализуем розовую
        if (Objects.equals(currentTheme, APP_PREFERENCES_ROSE)) {
            Log.i(TAG, "В ActivitySeconds  внутри themeCheckAndChange при проверке SharedPreferences  переменная currentTheme равна " + currentTheme);
            setRoseTheme();
        }

        // если тема оригинальная - реализуем оригинальную
        if (Objects.equals(currentTheme, APP_PREFERENCES_ORIGINAL)) {
            Log.i(TAG, "В ActivitySeconds  внутри themeCheckAndChange при проверке SharedPreferences  переменная currentTheme равна " + currentTheme);
            setOriginalTheme();
        }


        // если тема голубая - реализуем голубую
        if (Objects.equals(currentTheme, APP_PREFERENCES_BLUE)) {
            Log.i(TAG, "В ActivitySeconds  внутри themeCheckAndChange при проверке SharedPreferences  переменная currentTheme равна " + currentTheme);
            setBlueTheme();
        }


    }


}
