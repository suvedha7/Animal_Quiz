package com.example.first_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    int qn = 0, quizno = 0;
    Button sb;
    String mans;
    RadioButton rb1, rb2, rb3;
    RadioGroup rg;
    ImageView imgv;
    Question que = new Question();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.quizno);
        imgv = findViewById(R.id.imageView);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rg = findViewById(R.id.rg);
        updateq();
        sb = findViewById(R.id.submit_btn);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (que.getQtype(qn).equals("radiobutton")) {
                    // If the current question is a radiobutton type
                    // Check the selected answer
                    if (que.getCrtans(qn).equals(mans)) {
                        displaycrt();
                    } else {
                        displaywrg();
                    }
                    // Move to the next question
                    qn++;
                }
                // Increment the quiz number
                quizno++;
                updateq();
            }
        });


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int Id) {
                // Find which radio button is selected
                if (Id == R.id.rb1) {
                    mans = rb1.getText().toString();
                } else if (Id == R.id.rb2) {
                    mans = rb2.getText().toString();
                } else if (Id == R.id.rb3) {
                    mans = rb3.getText().toString();
                }
            }
        });
    }

    public void displaycrt() {
        Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show();
    }

    public void displaywrg() {
        Toast.makeText(this, "Wrong", Toast.LENGTH_LONG).show();
    }

    public void updateq() {
        // Check if the current question index is within the range of questions
        if (qn < que.getlen()) {
            t1.setText((quizno + 1) + "/" + que.getlen());

            // Reset radio button selection
            rg.clearCheck();

            // Set radio button text
            String[] choices = que.getChoices(qn);
            rb1.setText(choices[0]);
            rb2.setText(choices[1]);
            rb3.setText(choices[2]);

            // Set the image
            String im = que.getImgs(qn);
            imgv.setImageResource(getResources().getIdentifier(im, "drawable", getPackageName()));

            // Increment the quiz number
            quizno++;
        } else {
            // If all questions have been answered
            Toast.makeText(this, "Quiz completed!", Toast.LENGTH_SHORT).show();
        }
    }

}


