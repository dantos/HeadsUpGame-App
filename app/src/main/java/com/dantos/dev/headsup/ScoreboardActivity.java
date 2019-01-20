package com.dantos.dev.headsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.dantos.dev.headsup.Adapters.ScoreAdapter;

import java.util.ArrayList;

public class ScoreboardActivity extends AppCompatActivity {

    ListView resultList;
    TextView scoreText;
    Button tryAgainBtn;
    Button changeTopicBtn;

    String topics = "";
    int selectedTopicId = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        initView();

        Intent intent = getIntent();
        topics          = intent.getStringExtra("topics");
        selectedTopicId = intent.getIntExtra("selectedTopicId", 0);
        score           = intent.getIntExtra("score", 0);

        scoreText.setText(String.valueOf(score));

        ArrayList<ArrayList<String>> resultHistory = (ArrayList<ArrayList<String>>) intent.getSerializableExtra("resultHistory");

        resultList.setAdapter(new ScoreAdapter(this, resultHistory));


    }

    private void initView(){
        scoreText      = findViewById(R.id.txtVScoredAmount);
        tryAgainBtn    = findViewById(R.id.tryAgainBtn);
        changeTopicBtn = findViewById(R.id.txtChangeTopicBtn);
        resultList     = findViewById(R.id.resultList);


        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { restartGame();}
        });

        changeTopicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { changeGameTopic();}
        });
    }


    public void changeGameTopic() {
        Intent intent = new Intent(getApplicationContext(), TopicSelectorActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void restartGame() {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("topics", topics);
        intent.putExtra("selectedTopicId", selectedTopicId);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();

    }
}
