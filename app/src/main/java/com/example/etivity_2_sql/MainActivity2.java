// Assignment E-tivity 2 ED5042
// Oisin O'Sullivan 21304971



package com.example.etivity_2_sql;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity implements SensorEventListener {

    private TextView textView;
    private SensorManager sensorManager;;;;;;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.accel);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(MainActivity2.this,sensor,sensorManager.SENSOR_DELAY_NORMAL );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView.setText(sensorEvent.values[0]+"\n"+ sensorEvent.values[1]+"\n"+sensorEvent.values[2]+"\n");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
