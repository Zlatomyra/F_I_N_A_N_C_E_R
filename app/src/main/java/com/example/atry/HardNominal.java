package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HardNominal extends AppCompatActivity {

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
    }
}