package com.mestodushi.numbersmemory;

import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_CLASSIC;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_ROSE;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_THEME;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Objects;

public class ActivityTraining extends AppCompatActivity {

    int buttonTextSize = 18;
    TextView textViewShow_1, textViewShow_2, textViewShow_3, textViewShow_4, textViewShow_5;

    Button button_del, button11, button7, button9, button12, button13, button14, button17, button15, button18, button19;

    ArrayList<Button> buttonList;

    ArrayList<TextView> textViewList;


    ConstraintLayout trainingConstraintLayout;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_THEME = "theme";
    public static final String APP_PREFERENCES_CLASSIC = "classic";
    public static final String APP_PREFERENCES_ROSE = "rose";



    int exposition;

    SharedPreferences mSettings;

    String currentTheme = "";
    ConstraintLayout fonTrainingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traning);


        // инициализируем ссылочные перемнные элементов экрана
        fonTrainingActivity = findViewById(R.id.trainingConstraintLayout);


        textViewShow_1 = findViewById(R.id.textViewShow_1);
        textViewShow_1.setTypeface(null, Typeface.BOLD);

        textViewShow_2 = findViewById(R.id.textViewShow_2);
        textViewShow_2.setTypeface(null, Typeface.BOLD);

        textViewShow_3 = findViewById(R.id.textViewShow_3);
        textViewShow_3.setTypeface(null, Typeface.BOLD);

        textViewShow_4 = findViewById(R.id.textViewShow_4);
        textViewShow_4.setTypeface(null, Typeface.BOLD);

        textViewShow_5 = findViewById(R.id.textViewShow_5);
        textViewShow_5.setTypeface(null, Typeface.BOLD);


        button11 = findViewById(R.id.button11);
        button7 = findViewById(R.id.button7);
        button9 = findViewById(R.id.button9);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button17 = findViewById(R.id.button17);
        button15 = findViewById(R.id.button15);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);

        button_del = findViewById(R.id.button_del);


        // наполняем массив кнопками
        buttonList = new ArrayList<Button>();
        buttonList.add(button11);
        buttonList.add(button7);
        buttonList.add(button9);
        buttonList.add(button12);
        buttonList.add(button13);
        buttonList.add(button14);
        buttonList.add(button17);
        buttonList.add(button15);
        buttonList.add(button18);
        buttonList.add(button19);


        // наполняем массив текст-вьюшками
        textViewList = new ArrayList<TextView>();
        textViewList.add(textViewShow_1);
        textViewList.add(textViewShow_2);
        textViewList.add(textViewShow_3);
        textViewList.add(textViewShow_4);
        textViewList.add(textViewShow_5);




        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        themeCheckAndChange();


        textViewShow_1.setText("0");

    }

    public void button_0_click(View view) {
        textViewShow_1.setText("0");

    }

    public void button_del_click(View view) {

        int sluchainoeChislo;

        sluchainoeChislo = getRandomInteger();

        String stringRandomInt = "" +
                sluchainoeChislo;

        textViewShow_1.setText(stringRandomInt);

    }

    public void button_9_click(View view) {
        textViewShow_1.setText("9");
    }

    public void button_8_click(View view) {
        textViewShow_1.setText("8");
    }

    public void button_7_click(View view) {
        textViewShow_1.setText("7");
    }

    public void button_6_click(View view) {
        textViewShow_1.setText("6");
    }

    public void button_5_click(View view) {
        textViewShow_1.setText("5");
    }

    public void button_4_click(View view) {
        textViewShow_1.setText("4");
    }

    public void button_3_click(View view) {
        textViewShow_1.setText("3");
    }

    public void button_2_click(View view) {
        textViewShow_1.setText("2");
    }

    public void button_1_click(View view) {
        textViewShow_1.setText("1");
    }


    public void themeCheckAndChange() {


        if (mSettings.contains(APP_PREFERENCES_THEME)) {
            currentTheme = mSettings.getString(APP_PREFERENCES_THEME, "");
        }


        if (Objects.equals(currentTheme, APP_PREFERENCES_CLASSIC)){
            setClassicTheme();

        }
        if (Objects.equals(currentTheme, APP_PREFERENCES_ROSE)){
            setRoseTheme();
        }
    }

    public void setRoseTheme() {

        for (Button button : buttonList) {
            changeButtonsColorsToRose(button);
        }

        fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.ros));

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_ROSE);
        editor.apply();

    }

    public void changeButtonsColorsToRose(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.fil2));
        button.setTextColor(getResources().getColor(R.color.wit2));
    }


    public void setClassicTheme() {
        for (Button button : buttonList) {
            changeButtonColorsToClassic(button);
        }

        fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.wit2));

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_CLASSIC);
        editor.apply();
    }

    public void changeButtonColorsToClassic(Button button){
        button.setBackgroundColor(getResources().getColor(R.color.wit2));
        button.setTextColor(getResources().getColor(R.color.black));

    }

    public static int getRandomInteger(){
        int x = (int)(Math.random()*(10));
        return x;
    }



}
