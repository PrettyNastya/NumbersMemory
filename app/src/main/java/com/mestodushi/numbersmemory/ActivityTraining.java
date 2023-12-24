package com.mestodushi.numbersmemory;

import static com.mestodushi.numbersmemory.ActivitySeconds.APP_PREFERENCES_DELAY;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_BLUE;
import static com.mestodushi.numbersmemory.ActivityTem.APP_PREFERENCES_ORIGINAL;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
// Dog[] pets

//     ***   ***
//   *    * *    *
//   *     *     *
//    *         *
//      *      *
//        *  *
//         *
public class ActivityTraining extends AppCompatActivity {

    int buttonTextSize = 18;
    TextView textViewShow_1, textViewShow_2, textViewShow_3, textViewShow_4, textViewShow_5;

    Button button_del, button11, button7, button9, button12, button13, button14, button17, button15, button18,  button19, exit_button;//мяу

    ArrayList<Button> buttonList;

    ArrayList<TextView> textViewList;

    //ConstraintLayout trainingConstraintLayout;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_THEME = "theme";
    public static final String APP_PREFERENCES_CLASSIC = "classic";
    public static final String APP_PREFERENCES_ROSE = "rose";

    //int exposition;

    SharedPreferences mSettings;


    String currentTheme = "";
    ConstraintLayout fonTrainingActivity;

    int randomInt_1;
    int randomInt_2;
    int randomInt_3;
    int randomInt_4;
    int randomInt_5;

    int[] randomNumbersArray;

    /*
    int inputInt_1;
    int inputInt_2;
    int inputInt_3;
    int inputInt_4;
    int inputInt_5;

     */

    int count;

    private static final String TAG = "NumbersApp_1";

    // public long delay = 2000L;
    private long currentDelay;

    int cvetFonaRabochiy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traning);

        count = 0;
        Log.i(TAG, "Переменная count инициализирована и равна " + count);
        randomNumbersArray = new int[5];


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

        // инициализируем кнопки
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

        exit_button = findViewById(R.id.button16);


        // наполняем массив кнопками
        buttonList = new ArrayList<Button>();
        buttonList.add(button11); // [0]
        buttonList.add(button7); // [1]
        buttonList.add(button9); // [2]
        buttonList.add(button12);
        buttonList.add(button13);
        buttonList.add(button14);
        buttonList.add(button17);
        buttonList.add(button15);
        buttonList.add(button18);
        buttonList.add(button19);


        // наполняем массив-лист текст-вьюшками
        textViewList = new ArrayList<TextView>();
        textViewList.add(textViewShow_1); // [0]
        textViewList.add(textViewShow_2); // [1]
        textViewList.add(textViewShow_3); // [2]
        textViewList.add(textViewShow_4); // [3]
        textViewList.add(textViewShow_5); // [4]

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        themeCheckAndChange();
        setDelay();
        newNumberSet();



    }



    // TODO:// TODO:// TODO:
    public void button_del_click(View view) { // TODO: Сделать кнопку стирания пооследнего числа
    // TODO:// TODO:// TODO:

        // здесь должна быть реализована обработка нажатия кнопки del
    }



    public void button_0_click(View view) {
        //<3
        textViewList.get(count).setText("0");
      //  Log.i(TAG, "Зашли в button_0_click");

        if (randomNumbersArray[count] != 0) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));
            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {
            count++;
          //  Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
                Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);

                newNumberSet();
            }

        }


    }

    public void button_9_click(View view) {
        textViewList.get(count).setText("9");
        if (randomNumbersArray[count] != 9) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));

            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {
            count++;
          //  Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
              //  Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);
                newNumberSet();
            }
        }


    }

    public void button_8_click(View view) {
        textViewList.get(count).setText("8");

        if (randomNumbersArray[count] != 8) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));

            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {
            count++;
          //  Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
             //   Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);
                newNumberSet();
            }
        }

    }

    public void button_7_click(View view) {
        textViewList.get(count).setText("7");
        if (randomNumbersArray[count] != 7) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));

            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {

            count++;
        //    Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
              //  Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);
                newNumberSet();
            }

        }


    }

    public void button_6_click(View view) {
        textViewList.get(count).setText("6");
        if (randomNumbersArray[count] != 6) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));

            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {
            count++;
         //   Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
             //   Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);
                newNumberSet();
            }

        }

    }

    public void button_5_click(View view) {
        textViewList.get(count).setText("5");
        if (randomNumbersArray[count] != 5) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));

            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {
            count++;
          //  Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
              //  Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);
                newNumberSet();
            }

        }

    }

    public void button_4_click(View view) {
        textViewList.get(count).setText("4");
        if (randomNumbersArray[count] != 4) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));

            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {
            count++;
        //    Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
             //   Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);
                newNumberSet();
            }

        }

    }

    public void button_3_click(View view) {
        textViewList.get(count).setText("3");
        if (randomNumbersArray[count] != 3) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));

            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {
            count++;
           // Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
           //     Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);
                newNumberSet();
            }

        }

    }

    public void button_2_click(View view) {
        textViewList.get(count).setText("2");
        if (randomNumbersArray[count] != 2) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));

            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {
            count++;
            Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
                Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);
                newNumberSet();
            }

        }


    }


    /*if (Настины оценки = все 4){
        Подарить Насте макбук
    } else {
        Подарить Насте жевачку
    }*/

    /// этот метод отвечает за фон при ошибке числа
    public void button_1_click(View view) {
        textViewList.get(count).setText("1");
        if (randomNumbersArray[count] != 1) {
            fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.red));

            disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

            newNumberSetWithDelay();
        } else {
            count++;
            Log.i(TAG, "Переменная count инкрементирована и равна " + count);

            if (count > 4) {
                count = 0;
                Log.i(TAG, "Переменная count сброшена на 0 и равна " + count);
                newNumberSet();

            }

        }

    }


    public void themeCheckAndChange() {

        Log.i(TAG, "В ActivityTraining зашли в themeCheckAndChange ");

        if (mSettings.contains(APP_PREFERENCES_THEME)) { // если существует такой ключ APP_PREFERENCES_THEME, то
            currentTheme = mSettings.getString(APP_PREFERENCES_THEME, ""); // присваиваем переменной класса currentTheme строковое значение темы (если ничего нет, то присваиваем пустоту)
        }

        // если тема классическая - реализуем её
        if (Objects.equals(currentTheme, APP_PREFERENCES_CLASSIC)) {
            Log.i(TAG, "В ActivityTraining при проверке SharedPreferences  переменная currentTheme равна " + currentTheme);
            setClassicTheme();
        }

        // если тема розовая - реализуем розовую
        if (Objects.equals(currentTheme, APP_PREFERENCES_ROSE)) {
            Log.i(TAG, "В ActivityTraining при проверке SharedPreferences  переменная currentTheme равна " + currentTheme);
            setRoseTheme();
        }

        // если тема оригинальная - реализуем оригинальную
        if (Objects.equals(currentTheme, APP_PREFERENCES_ORIGINAL)) {
            Log.i(TAG, "В ActivityTraining при проверке SharedPreferences  переменная currentTheme равна " + currentTheme);
            setOriginalTheme();
        }


        // если тема голубая - реализуем голубую
        if (Objects.equals(currentTheme, APP_PREFERENCES_BLUE)) {
            Log.i(TAG, "В ActivityTraining при проверке SharedPreferences  переменная currentTheme равна " + currentTheme);
            setBlueTheme();
        }



    }

    private void setOriginalTheme() { // TODO: Сделать реализацию оригинальной темы

        for (Button button : buttonList) {
            changeButtonsColorsToOriginale(button);
        }

        fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.wit2));
        cvetFonaRabochiy = getResources().getColor(R.color.wit2);

        /*SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_ROSE);
        editor.apply();*/


    }

    private void changeButtonsColorsToOriginale(Button button) {

        button.setBackgroundColor(getResources().getColor(R.color.purple_500));
        button.setTextColor(getResources().getColor(R.color.wit2));

    }


    public void setDelay() {

        if (mSettings.contains(APP_PREFERENCES_DELAY)) {
            currentDelay = mSettings.getLong(APP_PREFERENCES_DELAY, 1000);
        }

    }


    public void setRoseTheme() {

        Log.i(TAG, "В ActivityTraining зашли в setRoseTheme");
        for (Button button : buttonList) {
            changeButtonsColorsToRose(button);
        }

        fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.ros));
        cvetFonaRabochiy = getResources().getColor(R.color.ros);

        /*SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_ROSE);
        editor.apply();*/

    }

    public void changeButtonsColorsToRose(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.fil2));
        button.setTextColor(getResources().getColor(R.color.wit2));
    }


    public void setClassicTheme() {

        Log.i(TAG, "В ActivityTraining зашли в setClassicTheme");

        for (Button button : buttonList) {
            changeButtonColorsToClassic(button);
        }

        fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.wit2));
        cvetFonaRabochiy = getResources().getColor(R.color.wit2);

        Log.i(TAG, "В ActivityTraining внутри setClassicTheme назначили белый фон");

        /*
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_THEME, APP_PREFERENCES_CLASSIC);
        editor.apply();
        */
    }

    public void changeButtonColorsToClassic(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.wit2));
        button.setTextColor(getResources().getColor(R.color.black));

    }

    public void setBlueTheme() {

        Log.i(TAG, "В ActivityTraining зашли в setBlueTheme");
        for (Button button : buttonList) {
            changeButtonColorsToBlue(button);
        }

        changeButtonColorsToBlue(exit_button);





        fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.bly2));
        cvetFonaRabochiy = getResources().getColor(R.color.bly);


    }

    public void changeButtonColorsToBlue(Button button) {
        button.setBackgroundColor(getResources().getColor(R.color.bly2));
        button.setTextColor(getResources().getColor(R.color.white));
    }



    public void getRandomIntegers(TextView textView) {

        disableNumberButton(); // делаем не кликабельными кнопки набора числа на экране

        int sluchainoeChislo = (int) (Math.random() * (10));
        ;

        String stringRandomInt = "" + sluchainoeChislo;

        textView.setText(stringRandomInt);

        if (textView == textViewShow_1) {
            randomInt_1 = sluchainoeChislo;
            randomNumbersArray[0] = randomInt_1;
        }
        if (textView == textViewShow_2) {
            randomInt_2 = sluchainoeChislo;
            randomNumbersArray[1] = randomInt_2;
        }
        if (textView == textViewShow_3) {
            randomInt_3 = sluchainoeChislo;
            randomNumbersArray[2] = randomInt_3;
        }
        if (textView == textViewShow_4) {
            randomInt_4 = sluchainoeChislo;
            randomNumbersArray[3] = randomInt_4;
        }
        if (textView == textViewShow_5) {
            randomInt_5 = sluchainoeChislo;
            randomNumbersArray[4] = randomInt_5;
        }

    }

    // делаем не кликабельными кнопки набора числа на экране
    private void disableNumberButton() {
        for (Button button : buttonList) {
            button.setEnabled(false);
        }
    }


    // делаем кликабельными кнопки набора числа на экране
    private void enableNumberButton() {
        for (Button button : buttonList) {
            button.setEnabled(true);
        }
    }


    // алгоритм задержки на заданный промежуток времени
    public void TextViewForInputHideAndShowWithDelay() {

        TimerTask task = new TimerTask() {

            public void run() {

                // взаимодействуем с элементами пользовательского интерфейса (кнопками) только из главного потока
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {// делаем кнопки нивидимыми

                        for (TextView textView : textViewList) {
                            textView.setVisibility(View.INVISIBLE);

                            showTextView4Input();
                        }

                    }
                });

            }


        };

        Timer timer = new Timer("Timer");

        // long delay = 2000L; // задаётся в миллисикундах, 1000L это 1 секунда, так мы задали задержку на 2 секунды


        timer.schedule(task, currentDelay);

    }

    public void newNumberSetWithDelay() {

        TimerTask task = new TimerTask() {

            public void run() {

                // взаимодействуем с элементами пользовательского интерфейса (кнопками) только из главного потока
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {// делаем кнопки нивидимыми
                        newNumberSet(); // генерируем новое заданное число
                    }
                });

            }


        };

        Timer timer = new Timer("Timer");

        long delay = 1500L; // задаётся в миллисикундах, 1000L это 1 секунда, так мы задали задержку на 1.5 секунды - это фиксированная задержка после ввода с ошибкой

        timer.schedule(task, delay);

    }


    public void showTextView4Input() {


        for (TextView textView : textViewList) {

            textView.setText("*");
            textView.setVisibility(View.VISIBLE);

            enableNumberButton();

            // fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.ros)); // TODO: заменить безусловно розовый фон на соотвествующий выбранной теме цвет
            // cvetFonaRabochiy
            fonTrainingActivity.setBackgroundColor(cvetFonaRabochiy); // TODO: нужно ли это здесь? Нужно ли задавать фон всего трейнинг активити, или только окна ввода? Или цвета и вспомогательных (не отображаемых по умолчанию) вьюшек должны быть назначенв в он-криэйт или в момент назначения темы?
            //TODO: нужно ли задавать цвет текста в соответствии с актуальной темой?

        }

    }

    // генерация нового числа, скрытие поля для ввода текста и отображение его после определённой задержки
    public void newNumberSet() {

        count = 0;

        for (TextView textView : textViewList) {

            //fonTrainingActivity.setBackgroundColor(getResources().getColor(R.color.ros)); // попробуем вставить изменение фона сюда **************************************************
            fonTrainingActivity.setBackgroundColor(cvetFonaRabochiy);

            getRandomIntegers(textView);
        }

        TextViewForInputHideAndShowWithDelay();

    }

    public void goToMainActFromActTraining(View view) {
        Intent intent = new Intent(ActivityTraining.this, MainActivity.class);
        startActivity(intent);
    }

}