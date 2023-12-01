package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SimpleProcent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_procent);

        Button dayButton = findViewById(R.id.days);
        dayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleProcent.this, CalcDay.class);
                startActivity(intent);
            }
        });

        Button monthButton = findViewById(R.id.month);
        monthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleProcent.this, CalcMonth.class);
                startActivity(intent);
            }
        });

        Button yearsButton = findViewById(R.id.years);
        yearsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleProcent.this, CalcYears.class);
                startActivity(intent);
            }
        });

        Button anCreditButton = findViewById(R.id.an_credit);
        anCreditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleProcent.this, AnuityCredit.class);
                startActivity(intent);
            }
        });

        Button reinButton = findViewById(R.id.rein);
        reinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleProcent.this, Reinvestment.class);
                startActivity(intent);
            }
        });

        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleProcent.this, SimpleHardProcent.class);
                startActivity(intent);
            }
        });
        Button financierButton = findViewById(R.id.financier);
        financierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleProcent.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}