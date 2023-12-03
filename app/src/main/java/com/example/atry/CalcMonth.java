package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CalcMonth extends AppCompatActivity {
    private EditText inputCapital, inputPercent, inputPeriod, inputSum;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_month);

        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalcMonth.this, SimpleProcent.class);
                startActivity(intent);
            }
        });

        Button financierButton = findViewById(R.id.financier);
        financierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalcMonth.this, MainActivity.class);
                startActivity(intent);
            }
        });

        inputCapital = findViewById(R.id.input_capital);
        inputPercent = findViewById(R.id.input_percent);
        inputPeriod = findViewById(R.id.input_period);
        inputSum = findViewById(R.id.input_sum);
        resultTextView = findViewById(R.id.result_text);
        Button resultButton = findViewById(R.id.calculate_button);

        resultButton.setOnClickListener(new View.OnClickListener() {
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

        double result;

        if (Double.isNaN(S)) {
            result = P * (1 + (i / 100)*(n*30/360));
            resultTextView.setText(String.valueOf("Нарощена сума: "+Math.round(result)));

        } else if (Double.isNaN(P)) {
            result = S / (1 + (n*30/360) * (i/100));
            resultTextView.setText(String.valueOf("Капітал: "+Math.round(result)));

        } else if (Double.isNaN(i)) {
            result = (S/ (P-1)) * (360/n*30) * 100;
            resultTextView.setText(String.valueOf("Відсоткова ставка: "+Math.round(result)));

        } else if (Double.isNaN(n)) {
            result = (int) ((((S - P)*360)/30) / (P * (i/100)));
            resultTextView.setText(String.valueOf("Кількість років: "+result));

        } else {
            result = 0;
        }


    }
}