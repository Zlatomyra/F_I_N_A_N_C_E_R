package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Reinvestment extends AppCompatActivity {
    private EditText inputCapital, inputPercent, inputPeriod, inputPayment;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reinvestment);

        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reinvestment.this, SimpleProcent.class);
                startActivity(intent);
            }
        });

        Button financierButton = findViewById(R.id.financier);
        financierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reinvestment.this, MainActivity.class);
                startActivity(intent);
            }
        });

        inputCapital = findViewById(R.id.input_capital);
        inputPercent = findViewById(R.id.input_percent);
        inputPeriod = findViewById(R.id.input_period);
        inputPayment = findViewById(R.id.input_payment);
        resultTextView = findViewById(R.id.result_text);

        Button calculateButton = findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

    }

    protected float GetCapitalization(float P, int n, float i, int number) {
        float S = (float) (P * Math.pow((1 + n * i), number));
        return S;
    }

    private void calculateResult() {

        double P = Double.parseDouble(inputCapital.getText().toString());
        double i = Double.parseDouble(inputPercent.getText().toString());
        double n = Double.parseDouble(inputPeriod.getText().toString());
        double number = Double.parseDouble(inputPayment.getText().toString());

        float result = GetCapitalization((float) P, (int) n, (float) i, (int) number);

        resultTextView.setText("Результат:" + result );


    }
}