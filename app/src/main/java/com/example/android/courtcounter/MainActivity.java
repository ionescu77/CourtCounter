package com.example.android.courtcounter;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0; // Tracks score for Team A
    int scoreTeamB = 0; // Tracks score for Team B
    String gameTrend = "-";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT < 16) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the game trend, which team is winning.
     */
    public void displayGameTrend(int scoreA, int scoreB) {
        TextView gameTrend = (TextView) findViewById(R.id.game_trend);
        if (scoreA > scoreB) {
            gameTrend.setText(String.valueOf(">"));
        } else if (scoreA < scoreB) {
            gameTrend.setText(String.valueOf("<"));
        } else {
            gameTrend.setText(String.valueOf("-"));
        }
    }

    /**
     * Do stuff for Team A
     */

    public void add_3points(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
        displayGameTrend(scoreTeamA, scoreTeamB);
    }

    public void add_2points(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
        displayGameTrend(scoreTeamA, scoreTeamB);
    }

    public void add_1point(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        displayGameTrend(scoreTeamA, scoreTeamB);
    }

    /**
     * Do stuff for Team B
     */

    public void add_3pointsTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
        displayGameTrend(scoreTeamA, scoreTeamB);
    }

    public void add_2pointsTeamB(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
        displayGameTrend(scoreTeamA, scoreTeamB);
    }

    public void add_1pointTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        displayGameTrend(scoreTeamA, scoreTeamB);
    }

    /**
     * RESET both team A and team B scores
     */

    public void resetAllScores(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayGameTrend(scoreTeamA, scoreTeamB);
    }


}
