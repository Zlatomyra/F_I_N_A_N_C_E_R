package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HardProcent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_procent);

        Button dayButton = findViewById(R.id.days);
        dayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardProcent.this, HardDay.class);
                startActivity(intent);
            }
        });

        Button yearsButton = findViewById(R.id.years);
        yearsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardProcent.this, HardYear.class);
                startActivity(intent);
            }
        });

        Button nominalButton = findViewById(R.id.nomin);
        nominalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardProcent.this, HardNominal.class);
                startActivity(intent);
            }
        });

        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardProcent.this, SimpleHardProcent.class);
                startActivity(intent);
            }
        });
        Button financierButton = findViewById(R.id.financier);
        financierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HardProcent.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}