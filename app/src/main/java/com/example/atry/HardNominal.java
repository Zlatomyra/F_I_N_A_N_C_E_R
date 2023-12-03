package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HardNominal extends AppCompatActivity {

    private EditText inputCapital, inputPercent, inputPeriod;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_nominal);

        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardNominal.this, HardProcent.class);
                startActivity(intent);
            }
        });

        Button financierButton = findViewById(R.id.financier);
        financierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardNominal.this, MainActivity.class);
                startActivity(intent);
            }
        });

        inputCapital = findViewById(R.id.input_capital);
        inputPercent = findViewById(R.id.input_percent);
        inputPeriod = findViewById(R.id.input_period);
        resultTextView = findViewById(R.id.result_text);
        Button resultButton = findViewById(R.id.calculate_button);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    protected double GetFractionYears(double P, double i, double n, RadioButton selectedRadioButton) {
        int m = 1;

        if (selectedRadioButton.getId() == R.id.radio_years && selectedRadioButton.isChecked()) {
            m = 1;
        } else if (selectedRadioButton.getId() == R.id.radio_kvartal && selectedRadioButton.isChecked()) {
            m = 4;
        } else if (selectedRadioButton.getId() == R.id.radio_month && selectedRadioButton.isChecked()) {
            m = 12;
        } else if (selectedRadioButton.getId() == R.id.radio_day && selectedRadioButton.isChecked()) {
            m = 365;
        }

        double S = P * Math.pow((1 + (i / 100) / m), n * m);
        return S;
    }


    private void calculateResult() {
        double P = Double.parseDouble(inputCapital.getText().toString());
        double i = Double.parseDouble(inputPercent.getText().toString());
        double n = Double.parseDouble(inputPeriod.getText().toString());

        RadioGroup radioGroup = findViewById(R.id.radio_group);
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(checkedRadioButtonId);


        double result = GetFractionYears(P, i, n, selectedRadioButton);
        resultTextView.setText("Результат: " + result);
    }
}
