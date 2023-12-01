package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.RadioGroup;

public class CalcDay extends AppCompatActivity {
    private EditText inputCapital, inputPercent, inputPeriod;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_day);


        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalcDay.this, SimpleProcent.class);
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

    protected double GetFractionYears(double P, double i, double t, int system){
        RadioButton Act_Act = findViewById(R.id.ACT_ACT);
        RadioButton Act_360 = findViewById(R.id.ACT_360);
        int K = 0;
        if(system == Act_Act.getId() && Act_Act.isChecked()){
            K = 365;
        }
        if(system == Act_360.getId() && Act_360.isChecked()){
            K = 360;
        }

        double S = P*(1+(i/100)*t/K);
        return S;
    }

    private void calculateResult() {

        double P = Double.parseDouble(inputCapital.getText().toString());
        double i = Double.parseDouble(inputPercent.getText().toString());
        double n = Double.parseDouble(inputPeriod.getText().toString());

        RadioGroup radioGroup = findViewById(R.id.radio_group);
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(checkedRadioButtonId);

        int system = selectedRadioButton.getId();

        double result = GetFractionYears(P, i, n, system );
        resultTextView.setText("Результат: " + result);
    }
}