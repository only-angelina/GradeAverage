package com.example.evalmisession_q3_2234599;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText[] nameEditTexts = new EditText[4];
    private EditText[] gradeEditTexts = new EditText[4];
    private Button calculateAverageButton;
    private TextView averageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize references to EditTexts and other UI components
        initializeUI();

        calculateAverageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
            }
        });
    }

    private void initializeUI() {
        for (int i = 0; i < 4; i++) {
            String nameEditTextId = "student" + (i + 1) + "Name";
            int nameEditTextResId = getResources().getIdentifier(nameEditTextId, "id", getPackageName());
            nameEditTexts[i] = findViewById(nameEditTextResId);

            String gradeEditTextId = "student" + (i + 1) + "Grade";
            int gradeEditTextResId = getResources().getIdentifier(gradeEditTextId, "id", getPackageName());
            gradeEditTexts[i] = findViewById(gradeEditTextResId);
        }

        calculateAverageButton = findViewById(R.id.calculateAverageButton);
        averageTextView = findViewById(R.id.averageTextView);
    }

    private void calculateAverage() {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            String gradeText = gradeEditTexts[i].getText().toString().trim();
            if (!gradeText.isEmpty()) {
                int grade = Integer.parseInt(gradeText);
                sum += grade;
                count++;
            }
        }

        if (count > 0) {
            double average = (double) sum / count;
            displayAverage(average);
        } else {
            averageTextView.setText("No grades entered.");
        }
    }

    private void displayAverage(double average) {
        averageTextView.setText("Average: " + average);
    }
}
