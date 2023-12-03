package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnuityCredit extends AppCompatActivity {
    private EditText inputCapital, inputPercent, inputPeriod, inputPayment;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuity_credit);


        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnuityCredit.this, SimpleProcent.class);
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

    protected float[] GetAnnuity(float P, int n, float i, int m){
        float array[];
        array = new float[2];
        float S = P*(1+n*(i/100));
        float R = S/(n*m);
        array[0] = S;
        array[1] = R;
        return array;
    }

    private void calculateResult() {

        double P = Double.parseDouble(inputCapital.getText().toString());
        double i = Double.parseDouble(inputPercent.getText().toString());
        double n = Double.parseDouble(inputPeriod.getText().toString());
        double m = Double.parseDouble(inputPayment.getText().toString());

        float[] resultArray = GetAnnuity((float) P, (int) n, (float) i, (int) m);

        float S = resultArray[0];
        float R = resultArray[1];

        resultTextView.setText("Результат: Нарощена сума = " + S + ", Разова виплата = " + R);


    }
}