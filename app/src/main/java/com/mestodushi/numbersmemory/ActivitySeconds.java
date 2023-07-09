package com.mestodushi.numbersmemory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySeconds extends AppCompatActivity {


    int delay;
    String delayValue;
    TextView delayForScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconds);
        delay = 5000;


        delayValue = Integer.toString(delay / 1000);
        //Источник: https://java-blog.ru/osnovy/perevod-int-string-java

        delayForScreen = findViewById(R.id.textViewDelay);
        delayForScreen.setText(delayValue);

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


//папа мне грубит"._."