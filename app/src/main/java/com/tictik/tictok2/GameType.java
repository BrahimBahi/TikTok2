package com.tictik.tictok2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tictik.tictok2.Games.Quiz;
import com.tictik.tictok2.model.Questions;

import java.util.Random;

public class GameType extends AppCompatActivity implements Quiz.OnFragmentInteractionListener {
    Button ans1, ans2, ans3, ans4;
    TextView ques, score;
    Questions mquestion = new Questions();
    String answer;
    Random r;
    private int mscore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type);
        r = new Random();


        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);
        ans4 = (Button) findViewById(R.id.ans4);
        ques = (TextView) findViewById(R.id.question);
        score = (TextView) findViewById(R.id.score);

        score.setText("Score : "+mscore);


        ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(GameType.this,MemoryGame.class);
                startActivity(i);
            }
        });


        updateQuestion(r.nextInt(mquestion.question.length));

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ans1.getText()==answer){
                    mscore++;
                    score.setText("Score : " + mscore);
                    updateQuestion(r.nextInt(mquestion.question.length));
                }
                else {
                    gameOver();
                }
            }


        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ans2.getText()==answer){
                    mscore++;
                    score.setText("Score : " + mscore);
                    updateQuestion(r.nextInt(mquestion.question.length));
                }
                else {
                    gameOver();
                }
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans3.getText()==answer){
                    mscore++;
                    score.setText("Score : " + mscore);
                    updateQuestion(r.nextInt(mquestion.question.length));
                }
                else {
                    gameOver();
                }

            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ans4.getText()==answer){
                    mscore++;
                    score.setText("Score : " + mscore);
                    updateQuestion(r.nextInt(mquestion.question.length));
                }
                else {
                    gameOver();
                }
            }
        });




    }



    private void gameOver() {
        ques.setText("Game Over");
    }

    private void updateQuestion(int i) {
        ques.setText(mquestion.getQuestion(i));
        ans1.setText(mquestion.getChoice1(i));
        ans2.setText(mquestion.getChoice2(i));
        ans3.setText(mquestion.getChoice3(i));
        ans4.setText(mquestion.getChoice4(i));
        answer = mquestion.getCorrectAns(i);
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
