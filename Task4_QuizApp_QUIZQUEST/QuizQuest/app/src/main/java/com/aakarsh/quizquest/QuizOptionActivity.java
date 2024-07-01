package com.aakarsh.quizquest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aakarsh.quizquest.other.Constants;

public class QuizOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_option);

        CardView cvJava = findViewById(R.id.cvJava);
        CardView cvCplus = findViewById(R.id.cvCplus);
        CardView cvPython = findViewById(R.id.cvPython);

        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cvPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizOptionActivity.this, PythonQuizActivity.class);
                intent.putExtra(Constants.SUBJECT,getString(R.string.python));
                startActivity(intent);
            }
        });

        cvJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizOptionActivity.this, JavaOrCplusQuizActivity.class);
                intent.putExtra(Constants.SUBJECT,getString(R.string.java));
                startActivity(intent);
            }
        });

        cvCplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizOptionActivity.this, JavaOrCplusQuizActivity.class);
                intent.putExtra(Constants.SUBJECT,getString(R.string.cplus));
                startActivity(intent);
            }
        });

    }
}