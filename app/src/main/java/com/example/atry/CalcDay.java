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
    private EditText inputCapital, inputPercent, inputPeriod, inputSum;
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

        Button financierButton = findViewById(R.id.financier);
        financierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalcDay.this, MainActivity.class);
                startActivity(intent);
            }
        });

        inputCapital = findViewById(R.id.input_capital);
        inputPercent = findViewById(R.id.input_percent);
        inputPeriod = findViewById(R.id.input_period);
        inputSum= findViewById(R.id.input_sum);
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
        RadioButton З60_360 = findViewById(R.id.З60_360);
        int K = 0;
        if(system == Act_Act.getId() && Act_Act.isChecked()){
            K = 365;
        }
        if(system == Act_360.getId() && Act_360.isChecked()){
            K = 360;
        }
        if(system == З60_360.getId() && З60_360.isChecked()){
            K = 360;
            t*= 30;
        }

        double S = P*(1+(i/100)*t/K);
        return Math.round(S);
    }

    private void calculateResul() {

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

    private void calculateResult(){
        double P, i, n, S;

        RadioButton Act_Act = findViewById(R.id.ACT_ACT);
        RadioButton Act_360 = findViewById(R.id.ACT_360);
        RadioButton З60_360 = findViewById(R.id.З60_360);

        RadioGroup radioGroup = findViewById(R.id.radio_group);
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(checkedRadioButtonId);

        int system = selectedRadioButton.getId();


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
        int K = 1;

        if(system == Act_Act.getId() && Act_Act.isChecked()){
            K = 365;
            if (Double.isNaN(S)) {
                result = P * (1 + (n/K) * (i / 100));
                resultTextView.setText(String.valueOf("Нарощена сума: "+Math.round(result)));

            } else if (Double.isNaN(P)) {
                result = S / (1 + n/K * (i/100));
                resultTextView.setText(String.valueOf("Капітал: "+Math.round(result)));

            } else if (Double.isNaN(i)) {
                result = (S / P -1) *(K/n) * 100;
                resultTextView.setText(String.valueOf("Відсоткова ставка: "+Math.round(result)));

            } else if (Double.isNaN(n)) {
                result = (int) (S / P -1) / (i / 100);
                resultTextView.setText(String.valueOf("Кількість років: "+result));

            } else {
                resultTextView.setText(String.valueOf("Всі поля заповнені"));
            }

        }
        if(system == Act_360.getId() && Act_360.isChecked()){
            K = 360;
            if (Double.isNaN(S)) {
                result = P * (1 + (n/K) * (i / 100));
                resultTextView.setText(String.valueOf("Нарощена сума: "+Math.round(result)));

            } else if (Double.isNaN(P)) {
                result = S / (1 + n/K * (i/100));
                resultTextView.setText(String.valueOf("Капітал: "+Math.round(result)));

            } else if (Double.isNaN(i)) {
                result = (S / P -1) *(K/n) * 100;
                resultTextView.setText(String.valueOf("Відсоткова ставка: "+Math.round(result)));

            } else if (Double.isNaN(n)) {
                result = (int) (S / P -1) / (i /100);
                resultTextView.setText(String.valueOf("Кількість років: "+result));

            } else {
                resultTextView.setText(String.valueOf("Всі поля заповнені"));
            }
        }
        if(system == З60_360.getId() && З60_360.isChecked()){
            K = 360;
            n*= 30;
            if (Double.isNaN(S)) {
                result = P * (1 + (n/K) * (i / 100));
                resultTextView.setText(String.valueOf("Нарощена сума: "+Math.round(result)));

            } else if (Double.isNaN(P)) {
                result = S / (1 + n/K * (i/100));
                resultTextView.setText(String.valueOf("Капітал: "+Math.round(result)));

            } else if (Double.isNaN(i)) {
                result = (S / P -1) *(K/n) * 100;
                resultTextView.setText(String.valueOf("Відсоткова ставка: "+Math.round(result)));

            } else if (Double.isNaN(n)) {
                result = (int) ((S / P -1)*100) / i ;
                resultTextView.setText(String.valueOf("Кількість років: "+result));

            } else {
                resultTextView.setText(String.valueOf("Всі поля заповнені"));
            }
        }

    }
}