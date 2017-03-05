package com.example.android.quidditchcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int GOAL_POINTS = 10;
    static final int SNITCH_POINTS = 150;
    static final int FOUL_POINTS = 10;

    int scoreGryffindor = 0;
    int scoreSlytherin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForGryffindor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.gryffindor_score);
        scoreView.setText(String.valueOf(score));
    }

    public void goalForGryffindor(View view) {
        scoreGryffindor += GOAL_POINTS;
        displayForGryffindor(scoreGryffindor);
    }

    public void snitchForGryffindor(View view) {
        scoreGryffindor += SNITCH_POINTS;
        displayForGryffindor(scoreGryffindor);
        displayWinner("Gryffindor");
    }

    public void foulForGryffindor(View view) {
        scoreGryffindor -= FOUL_POINTS;
        displayForGryffindor(scoreGryffindor);
    }

    public void displayForSlytherin(int score) {
        TextView scoreView = (TextView) findViewById(R.id.slytherin_score);
        scoreView.setText(String.valueOf(score));
    }

    public void goalForSlytherin(View view) {
        scoreSlytherin += GOAL_POINTS;
        displayForSlytherin(scoreSlytherin);
    }

    public void snitchForSlytherin(View view) {
        scoreSlytherin += SNITCH_POINTS;
        displayForSlytherin(scoreSlytherin);
        displayWinner("Slytherin");
    }

    public void foulForSlytherin(View view) {
        scoreSlytherin -= FOUL_POINTS;
        displayForSlytherin(scoreSlytherin);
    }

    public void reset(View view) {
        scoreGryffindor = 0;
        scoreSlytherin = 0;
        displayForGryffindor(scoreGryffindor);
        displayForSlytherin(scoreSlytherin);

        TextView winnerView = (TextView) findViewById(R.id.winner);
        winnerView.setText("");

        // Enable points buttons - they could be disabled if someone won the game.
        enableButton(R.id.gryffindor_foul);
        enableButton(R.id.gryffindor_goal);
        enableButton(R.id.gryffindor_snitch);
        enableButton(R.id.slytherin_foul);
        enableButton(R.id.slytherin_goal);
        enableButton(R.id.slytherin_snitch);
    }

    private void displayWinner(String winner) {
        TextView scoreView = (TextView) findViewById(R.id.winner);
        scoreView.setText(String.format(getResources().getString(R.string.winner_message), winner));

        // Disable points buttons because the game is over.
        disableButton(R.id.gryffindor_foul);
        disableButton(R.id.gryffindor_goal);
        disableButton(R.id.gryffindor_snitch);
        disableButton(R.id.slytherin_foul);
        disableButton(R.id.slytherin_goal);
        disableButton(R.id.slytherin_snitch);
    }

    private void disableButton(int id) {
        ((Button)findViewById(id)).setEnabled(false);
    }

    private void enableButton(int id) {
        ((Button)findViewById(id)).setEnabled(true);
    }
}
