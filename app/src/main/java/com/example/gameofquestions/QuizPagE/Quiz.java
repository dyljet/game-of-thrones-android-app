package com.example.gameofquestions.QuizPagE;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gameofquestions.NavigationDrawer;
import com.example.gameofquestions.R;

public class Quiz extends AppCompatActivity {


    Vibrator vibrator;

    private QuestionBook qQuestionBook = new QuestionBook();

    private TextView qScoreCurrent;
    private TextView qQuestionCurrent;
    private Button qButtonAnswer1;
    private Button qButtonAnswer2;
    private Button qButtonAnswer3;


    private String correctAns;
    private int Score = 0;
    private int QuestionNumber = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //get vibrator service
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_quiz);
        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.grey);


        qScoreCurrent = (TextView)findViewById(R.id.score);
        qQuestionCurrent = (TextView)findViewById(R.id.question);
        qButtonAnswer1 = (Button)findViewById(R.id.answer1);
        qButtonAnswer2 = (Button)findViewById(R.id.answer2);
        qButtonAnswer3 = (Button)findViewById(R.id.answer3);

        changeQuestion();

        qButtonAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (qButtonAnswer1.getText() == correctAns) {
                    //increase score by 1 if correct answer
                    Score = Score + 1;
                    changeScore(Score);

                    //Check if final question before moving to next
                    if (QuestionNumber == QuestionBook.Questions.length){
                        Intent i = new Intent(Quiz.this, QuizResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("FinalScore", Score);
                        i.putExtras(bundle);
                        Quiz.this.finish();
                        startActivity(i);

                    }else {
                        changeQuestion();

                    }
                    //toast to notify answer was correct
                    Toast.makeText(Quiz.this, "correct!", Toast.LENGTH_SHORT).show();

                } else {
                    //check if final question before moving to next
                    if (QuestionNumber == QuestionBook.Questions.length){
                        Intent i = new Intent(Quiz.this, QuizResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("FinalScore", Score);
                        i.putExtras(bundle);
                        Quiz.this.finish();
                        startActivity(i);

                    }else {
                        changeQuestion();
                    }

                    //toast to notify answer was wrong with a little vibration

                    Toast.makeText(Quiz.this, "wrong :(", Toast.LENGTH_SHORT).show();
                    vibrator.vibrate(70);





                }
            }
        });


        qButtonAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (qButtonAnswer2.getText() == correctAns) {
                    Score = Score + 1;
                    changeScore(Score);
                    if (QuestionNumber == QuestionBook.Questions.length){
                        Intent i = new Intent(Quiz.this, QuizResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("FinalScore", Score);
                        i.putExtras(bundle);
                        Quiz.this.finish();
                        startActivity(i);

                    }else {

                        changeQuestion();
                    }
                    Toast.makeText(Quiz.this, "correct!", Toast.LENGTH_SHORT).show();

                } else {
                    if (QuestionNumber == QuestionBook.Questions.length){
                        Intent i = new Intent(Quiz.this, QuizResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("FinalScore", Score);
                        i.putExtras(bundle);
                        Quiz.this.finish();
                        startActivity(i);

                    }else {
                        changeQuestion();
                    }
                    Toast.makeText(Quiz.this, "wrong :(", Toast.LENGTH_SHORT).show();
                    vibrator.vibrate(70);






                }
            }
        });


        qButtonAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (qButtonAnswer3.getText() == correctAns) {
                    Score = Score + 1;
                    changeScore(Score);
                    if (QuestionNumber == QuestionBook.Questions.length){
                        Intent i = new Intent(Quiz.this, QuizResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("FinalScore", Score);
                        i.putExtras(bundle);
                        Quiz.this.finish();
                        startActivity(i);

                    }else {
                        changeQuestion();
                    }
                    Toast.makeText(Quiz.this, "correct!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Quiz.this, "wrong :(", Toast.LENGTH_SHORT).show();
                    vibrator.vibrate(70);




                    if (QuestionNumber == QuestionBook.Questions.length){
                        Intent i = new Intent(Quiz.this, QuizResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("FinalScore", Score);
                        i.putExtras(bundle);
                        Quiz.this.finish();
                        startActivity(i);

                    }else {
                        changeQuestion();
                    }


                }


            }
        });


        //button to quit quiz

        Button button = (Button) findViewById(R.id.quit);
        button.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View v) {

                                          QuitQuiz();
                                      }
                                  }


        );


    }

    private void QuitQuiz(){
        Intent intent = new Intent(this, NavigationDrawer.class);
        startActivity(intent);

    }
    private void changeQuestion(){

        //function to change the question
        qQuestionCurrent.setText(qQuestionBook.getQuestion(QuestionNumber));
        qButtonAnswer1.setText(qQuestionBook.getAnswer1(QuestionNumber));
        qButtonAnswer2.setText(qQuestionBook.getAnswer2(QuestionNumber));
        qButtonAnswer3.setText(qQuestionBook.getAnswer3(QuestionNumber));

        correctAns= qQuestionBook.getCorrectAnswer(QuestionNumber);
        QuestionNumber++;

    }

    private void changeScore(int point) {
        //function to change the score

        qScoreCurrent.setText("" + Score);
    }
}
