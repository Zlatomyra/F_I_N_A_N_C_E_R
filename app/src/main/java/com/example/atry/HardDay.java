package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HardDay extends AppCompatActivity {
    private EditText inputCapital, inputPercent, inputPeriod;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_day);

        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardDay.this, HardProcent.class);
                startActivity(intent);
            }
        });

        Button financierButton = findViewById(R.id.financier);
        financierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardDay.this, MainActivity.class);
                startActivity(intent);
            }
        });
        inputCapital = findViewById(R.id.input_capital);
        inputPercent = findViewById(R.id.input_percent);
        inputPeriod = findViewById(R.id.input_period);
        resultTextView = findViewById(R.id.result_text);


        Button calculateButton = findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        try {
            double P = Double.parseDouble(inputCapital.getText().toString());
            double i = Double.parseDouble(inputPercent.getText().toString());
            double n = Double.parseDouble(inputPeriod.getText().toString());

            int filledFields = 0;
            if (!Double.isNaN(P)) {
                filledFields++;
            }

            if (!Double.isNaN(i)) {
                filledFields++;
            }

            if (!Double.isNaN(n)) {
                filledFields++;
            }

            if (filledFields < 2) {
                resultTextView.setText("Помилка: Заповніть принаймні три поля.");
                return;
            }
            double result = P * Math.pow((1 + i/100), n/365);
            resultTextView.setText("Результат: " + result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resultTextView.setText("Помилка: Заповніть всі поля");
        }

    }
}