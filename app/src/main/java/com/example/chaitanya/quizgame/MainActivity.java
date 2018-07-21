package com.example.chaitanya.quizgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    TextView question;
    Button truebtn,falsebtn;
    Questions mQuestions;
    int questionlrngth;
    ArrayList<Item>questionlist;
    int currentQuestion=0;
    boolean winner=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question=(TextView)findViewById(R.id.question);
        truebtn=(Button)findViewById(R.id.truebtn);
        falsebtn=(Button)findViewById(R.id.falsebtn);
        mQuestions=new Questions();
        questionlrngth=mQuestions.mQuestions.length;
        questionlist=new ArrayList<>();
        for (int i=0;i<questionlrngth;i++){
            questionlist.add(new Item(mQuestions.getQuestions(i),mQuestions.getAnswer(i)));
            }
        Collections.shuffle(questionlist);
        setQuestions(currentQuestion);
        truebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (checkQuestion(currentQuestion)) {
                   currentQuestion++;
                   if (currentQuestion < questionlrngth) {
                       setQuestions(currentQuestion);
                   } else {
                       winner = true;
                       endGame();
                   }
               }else {
                    endGame();
                   }

            }
        });
        falsebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkQuestion(currentQuestion)) {
                    currentQuestion++;
                    if (currentQuestion < questionlrngth) {
                        setQuestions(currentQuestion);
                    } else {
                        winner = true;
                        endGame();
                    }
                }else {
                    endGame();
                }
            }
        });
    }

    private void setQuestions(int number) {
        question.setText(questionlist.get(number).getQuestion());
    }
    private boolean checkQuestion(int number){
        String answer=questionlist.get(number).getAnswer();
        return  answer.equals("true");
    }
    private void endGame(){
        if (winner){
            Toast.makeText(this, "Game is  Over!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(this, "You Loss!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
