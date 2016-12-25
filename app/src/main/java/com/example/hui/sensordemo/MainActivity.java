package com.example.hui.sensordemo;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private Sensor mOrientation;
    private Sensor mlight;
    private TextView tAccelerometer;
    private TextView tOrientation;
    private TextView tlight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tAccelerometer =(TextView)this.findViewById(R.id.accelerometer);
        tOrientation=(TextView)this.findViewById(R.id.orientation);
        tlight=(TextView)this.findViewById(R.id.light);
        mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mOrientation=mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mlight=mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener((SensorEventListener) this,mAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener((SensorEventListener) this,mOrientation,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener((SensorEventListener) this,mlight,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener((SensorEventListener) this);
    }
    public void onSensoorChanged(SensorEvent event){
        float x=event.values[SensorManager.DATA_X];
        float y=event.values[SensorManager.DATA_Y];
        float z=event.values[SensorManager.DATA_Z];
        if(event.sensor.getType()==Sensor.TYPE_ORIENTATION){
            tOrientation.setText("方位："+x+","+y+","+","+z);
        }else if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            tOrientation.setText("加速度："+x+","+y+","+","+z);
        }else if(event.sensor.getType()==Sensor.TYPE_LIGHT){
            tOrientation.setText("光线："+x+","+y+","+","+z);
        }
    }
    public void onAccuracyChanged(Sensor sensor,int accuracy){

    }

}
