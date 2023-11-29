package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SimpleHardProcent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_hard_procent);

        Button backButton = findViewById(R.id.previous);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleHardProcent.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button simpleButton = findViewById(R.id.simple_procent);
        simpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleHardProcent.this, SimpleProcent.class);
                startActivity(intent);
            }
        });

        Button hardButton = findViewById(R.id.hard_procent);
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleHardProcent.this, HardProcent.class);
                startActivity(intent);
            }
        });
    }
}