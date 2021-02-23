package com.example.gameofquestions.QuizPagE;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gameofquestions.NavigationDrawer;
import com.example.gameofquestions.R;

public class QuizResult extends AppCompatActivity {

    private Button button;

    TextView Comment, FinalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.cream);

        Comment = (TextView) findViewById(R.id.comment);
        FinalScore = (TextView) findViewById(R.id.fs);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("FinalScore");

        FinalScore.setText("You scored " + score + " out of " + QuestionBook.Questions.length);


        // if statement to check score and give relevant title
        if (score == 10){
         Comment.setText("Azor Ahai");
        } else if (score == 9) {
            Comment.setText("Lord of Winterfell");
         } else if (score == 8)
             Comment.setText("Noble Knight");
        else if (score < 8)
            Comment.setText("Wildling");


        button = (Button) findViewById(R.id.retry);
        button.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View v) {

                                          Intent intent = new Intent(QuizResult.this, Quiz.class);
                                          startActivity(intent);                                      }
                                  }


        );

        button = (Button) findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View v) {

                                          Intent intent = new Intent(QuizResult.this, NavigationDrawer.class);
                                          startActivity(intent);                                      }
                                  }


        );
    }
}
