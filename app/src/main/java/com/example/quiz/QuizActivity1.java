package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity1 extends AppCompatActivity {
    private TextView tvquestion, tvscore,tvquestionno,tvTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1,rb2,rb3;
    private Button btnNext;
    int totalQuestion=0;
    int qCounter=0;
    int score;
    ColorStateList dfRColor;
    boolean answered;
    CountDownTimer countDownTimer;
    private QuestionNumero1 CurrentQuestion;
private List<QuestionNumero1> questiolist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        questiolist=new ArrayList<>();
        tvquestion=findViewById(R.id.textQuestion);
        tvscore=findViewById(R.id.textscore);
        tvquestionno=findViewById(R.id.textQyestionNo);
        tvTimer=findViewById(R.id.textTimer);
        tvquestion=findViewById(R.id.textQuestion);



        radioGroup=findViewById(R.id.radioGroup);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        btnNext=findViewById(R.id.btnnext);
        dfRColor=rb1.getTextColors();

        addQuestion();
        totalQuestion=questiolist.size();
        showNextQuestion();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answered==false){
                    if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked()){
                        checkAnswer();
                        countDownTimer.cancel();
                    }else{
                        Toast.makeText(QuizActivity1.this,"Please Select an option",Toast.LENGTH_LONG).show();
                    }
                }else {
                    showNextQuestion();
                }
            }

            private void checkAnswer() {
                answered=true;
                RadioButton rbeSelected=findViewById(radioGroup.getCheckedRadioButtonId());
                int answerNo=radioGroup.indexOfChild(rbeSelected)+1;
                if(answerNo==CurrentQuestion.getCorrectAnsNo()){
             score++;
             tvscore.setText("Score: "+score);
                }
                rb1.setTextColor(Color.RED);
                rb2.setTextColor(Color.RED);
                rb3.setTextColor(Color.RED);
                switch (CurrentQuestion.getCorrectAnsNo()){
                    case 1:
                        rb1.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        rb2.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        rb3.setTextColor(Color.GREEN);
                        break;


                }
                if (qCounter<totalQuestion){
                    btnNext.setText("Next");
                }else{
                    btnNext.setText("Finish");
                }
            }
        });

    }

    private void showNextQuestion() {
        radioGroup.clearCheck();
        rb1.setTextColor(dfRColor);
        rb2.setTextColor(dfRColor);
        rb3.setTextColor(dfRColor);

        if(qCounter<totalQuestion){
            timer();
         CurrentQuestion=questiolist.get(qCounter);
         tvquestion.setText(CurrentQuestion.getQuetion());
         rb1.setText(CurrentQuestion.getOption1());
            rb2.setText(CurrentQuestion.getOption2());
            rb3.setText(CurrentQuestion.getOption3());
            qCounter++;
            btnNext.setText("Submit");
            tvquestionno.setText("Question: "+qCounter+"/"+totalQuestion);
            answered=false;

        }else {
            finish();
        }
    }

    private void timer() {
        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                tvTimer.setText("00:" + 1/1000);
            }

            @Override
            public void onFinish() {
              showNextQuestion();
            }
        }.start();
    }


    private void addQuestion() {
        questiolist.add(new QuestionNumero1("A is Correct?","A","B","C",1));
        questiolist.add(new QuestionNumero1("A is Correct?","A","B","C",2));
        questiolist.add(new QuestionNumero1("A is Correct?","A","B","C",3));
        questiolist.add(new QuestionNumero1("A is Correct?","A","B","C",1));
        questiolist.add(new QuestionNumero1("A is Correct?","A","B","C",2));

    }
}