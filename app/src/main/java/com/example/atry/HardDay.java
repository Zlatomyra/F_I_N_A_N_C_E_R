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

        Button calculateButton = findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {

        double P = Double.parseDouble(inputCapital.getText().toString());
        double i = Double.parseDouble(inputPercent.getText().toString());
        double n = Double.parseDouble(inputPeriod.getText().toString());

        double result = P*Math.pow((1+i), n/365);
        resultTextView.setText("Результат: " + result);
    }
}