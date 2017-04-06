package com.example.a11093.homework2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView _first, _second, _answer;
    private Sensor _mySensor;
    private SensorManager _myManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _myManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        _mySensor = _myManager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
        _myManager.registerListener(this, _mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        _first = (TextView) findViewById(R.id.first);
        _second = (TextView) findViewById(R.id.second);
        _answer = (TextView) findViewById(R.id.answer);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String first = "", second = "";
        int firstD = 0;
        int secondD = 0;
        int base = 0;
        if (event.values[0] != 0.0) {
            first += Math.round(event.values[0] * 100);
        } else {
            first = "0";
        }
        if (event.values[1] != 0.0) {
            second += Math.round(event.values[1] * 100);
        } else {
            second = "0";
        }
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != '-') {
                if (Integer.parseInt("" + first.charAt(i)) > base) {
                    base = Integer.parseInt("" + first.charAt(i)) + 1;
                }
            }
        }
        for (int j = 0; j < first.length(); j++) {
            if (first.charAt(j) != '-') {
                firstD += Integer.parseInt("" + first.charAt(j)) * Math.pow(base, first.length() - j - 1);
            }
        }
        if (Integer.parseInt(first) < 0) {
            firstD *= -1;
        }
        _first.setText("First Number: " + first + "\n Base: " + base + "\n NumberInDecimal: " + firstD);
        base = 0;
        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) != '-') {
                if (Integer.parseInt("" + second.charAt(i)) > base) {
                    base = Integer.parseInt("" + second.charAt(i)) + 1;
                }
            }
        }
        for (int j = 0; j < second.length(); j++) {
            if (second.charAt(j) != '-') {
                secondD += Integer.parseInt("" + second.charAt(j)) * Math.pow(base, second.length() - j - 1);
            }
        }
        if (Integer.parseInt(first) < 0) {
            secondD *= -1;
        }

        _second.setText("Second Number: " + second + "\n Base: " + base + "\n NumberInDecimal: " + secondD);
        _answer.setText("AnswerInDecimal = " + (secondD + firstD));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
