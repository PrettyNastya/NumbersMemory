package com.mestodushi.numbersmemory;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTraining extends AppCompatActivity {

    int buttonTextSize = 18;
    TextView textViewM_1;
    int exposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traning);
        textViewM_1 = findViewById(R.id.textViewM);
        textViewM_1.setTypeface(null, Typeface.BOLD);

        textViewM_1.setText("0");

    }

    public void button_0_click(View view) {
        textViewM_1.setText("0");

    }

    public void button_del_click(View view) {
    }

    public void button_9_click(View view) {
        textViewM_1.setText("9");
    }

    public void button_8_click(View view) {
        textViewM_1.setText("8");
    }

    public void button_7_click(View view) {
        textViewM_1.setText("7");
    }

    public void button_6_click(View view) {
        textViewM_1.setText("6");
    }

    public void button_5_click(View view) {
        textViewM_1.setText("5");
    }

    public void button_4_click(View view) {
        textViewM_1.setText("4");
    }

    public void button_3_click(View view) {
        textViewM_1.setText("3");
    }

    public void button_2_click(View view) {
        textViewM_1.setText("2");
    }

    public void button_1_click(View view) {
        textViewM_1.setText("1");
    }
}
