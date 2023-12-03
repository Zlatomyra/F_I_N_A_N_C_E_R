package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcYears extends AppCompatActivity {
    private EditText inputCapital, inputPercent, inputPeriod, inputSum;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_years);

        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalcYears.this, SimpleProcent.class);
                startActivity(intent);
            }
        });

        Button financierButton = findViewById(R.id.financier);
        financierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalcYears.this, MainActivity.class);
                startActivity(intent);
            }
        });

        inputCapital = findViewById(R.id.input_capital);
        inputPercent = findViewById(R.id.input_percent);
        inputPeriod = findViewById(R.id.input_period);
        inputSum = findViewById(R.id.input_sum);
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
        double P, i, n, S;

        try {
            P = Double.parseDouble(inputCapital.getText().toString());
        } catch (NumberFormatException e) {
            P = Double.NaN;
        }

        try {
            i = Double.parseDouble(inputPercent.getText().toString());
        } catch (NumberFormatException e) {
            i = Double.NaN;
        }

        try {
            n = Double.parseDouble(inputPeriod.getText().toString());
        } catch (NumberFormatException e) {
            n = Double.NaN;
        }

        try {
            S = Double.parseDouble(inputSum.getText().toString());
        } catch (NumberFormatException e) {
            S = Double.NaN;
        }

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

        if (!Double.isNaN(S)) {
            filledFields++;
        }

        if (filledFields < 3) {
            resultTextView.setText("Помилка: Заповніть принаймні три поля.");
            return;
        }
        double result;

        if (Double.isNaN(S)) {
            result = P * (1 + n * (i / 100));
            resultTextView.setText(String.valueOf("Нарощена сума: "+Math.round(result)));

        } else if (Double.isNaN(P)) {
            result = S / (1 + n * (i/100));
            resultTextView.setText(String.valueOf("Капітал: "+Math.round(result)));

        } else if (Double.isNaN(i)) {
            result = (S - P) / (P * n) * 100;
            resultTextView.setText(String.valueOf("Відсоткова ставка: "+Math.round(result)));

        } else if (Double.isNaN(n)) {
            result = (int) ((S - P) / (P * (i/100)));
            resultTextView.setText(String.valueOf("Кількість років: "+result));

        } else {
            result = 0;
        }


    }
}