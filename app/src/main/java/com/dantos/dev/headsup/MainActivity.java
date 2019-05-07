package com.dantos.dev.headsup;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    private long lastTimeUpdate = 0;
    private float lastYPosition;
    private float lastZPosition;
    private static final int MOVEMENT_THRESHOLD = 1800;

    private int startTimer = 5;
    private int longTimer  = 60;
    private int score      = 0;

    String topics       = "";
    int selectedTopicId = 0;

    JSONArray subjectsList;
    ArrayList<ArrayList<String>> resultHistory = new ArrayList<>();

    TextView shortCounter;
    TextView timer;
    TextView hintWord;
    ArrayList<String> currentHint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent   = getIntent();
        topics          = intent.getStringExtra("topics");
        selectedTopicId = intent.getIntExtra("selectedTopicId", 0);

        try {
            JSONArray topicsArr      = new JSONArray(topics);
            JSONObject selectedTopic = topicsArr.getJSONObject(selectedTopicId);
            
            subjectsList = new JSONArray(selectedTopic.getString("subjects"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        initView();

    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void initView() {

        shortCounter = findViewById(R.id.shortCounter);
        hintWord     = findViewById(R.id.hintWord);
        timer        = findViewById(R.id.timer);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor        = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        new CountDownTimer(6_000, 1_000) {

            @Override
            public void onTick(long millisUntilFinished) {
                shortCounter.setText(String.valueOf(startTimer));
                startTimer--;
            }

            @Override
            public void onFinish() {
                shortCounter.setVisibility(View.INVISIBLE);
                startGameTimer();
                currentHint = changeHintWord();

            }
        }.start();

    }

    private void startGameTimer() {

        new CountDownTimer(61_000, 1_000) {

            @Override
            public void onTick(long millisUntilFinished) {
                String remainingTimeText = getResources().getString(R.string.remaning_time);
                timer.setText(remainingTimeText + " " + String.valueOf(longTimer));
                longTimer--;
            }

            @Override
            public void onFinish() {

                String successfulAnswered    = "0";
                currentHint.add(1, successfulAnswered);
                resultHistory.add(currentHint);

                timer.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(getApplicationContext(), ScoreboardActivity.class);
                intent.putExtra("resultHistory", resultHistory);
                intent.putExtra("score", score);
                intent.putExtra("topics", topics);
                intent.putExtra("selectedTopicId", selectedTopicId);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

            }
        }.start();
    }

    public ArrayList<String> getRandomSubject() {

        ArrayList<String> subject  = new ArrayList<>();
        int max = subjectsList.length() - 1;
        int min = 0;
        int randomNumber;

        Random random = new Random();
        randomNumber = random.nextInt((max - min) + 1) + min;

        try {
            subject.add(0, (String) subjectsList.get(randomNumber));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return subject;
    }

    public ArrayList<String> changeHintWord() {

        ArrayList<String> subject = getRandomSubject();
        hintWord.setText(subject.get(0));

        return subject;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        Sensor sensorEvent = event.sensor;

        if (sensorEvent.getType() == Sensor.TYPE_ACCELEROMETER) {

            float yPosition  = event.values[1];
            float zPosition  = event.values[2];
            long currentTime = System.currentTimeMillis();

            if ((currentTime - lastTimeUpdate) > 195) {

                long diffTime  = (currentTime - lastTimeUpdate);
                lastTimeUpdate = currentTime;

                float speed      = yPosition + zPosition - lastYPosition - lastZPosition;
                float finalSpeed = Math.abs(speed) / diffTime * 10000;

                if (finalSpeed > MOVEMENT_THRESHOLD) {

                    ArrayList<String> hintResult = changeHintWord();
                    String successfulAnswered    = "0";

                    if (speed < 0) { //Moved forward
                        successfulAnswered = "1";
                        score += 1;
                    }

                    currentHint.add(1, successfulAnswered);
                    resultHistory.add(currentHint);

                    currentHint = changeHintWord();
                }
                lastZPosition = zPosition;
                lastYPosition = yPosition;
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

}
