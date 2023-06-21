package com.example.drawapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DrawingView drawingView;
    private Button redButton, yellowButton, greenButton, blueButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingView = findViewById(R.id.signatureView);
        redButton = findViewById(R.id.redButton);
        yellowButton = findViewById(R.id.yellowButton);
        greenButton = findViewById(R.id.greenButton);
        blueButton = findViewById(R.id.blueButton);
        clearButton = findViewById(R.id.clearButton);

        redButton.setBackgroundColor(getResources().getColor(R.color.red));
        yellowButton.setBackgroundColor(getResources().getColor(R.color.yellow));
        greenButton.setBackgroundColor(getResources().getColor(R.color.green));
        blueButton.setBackgroundColor(getResources().getColor(R.color.blue));
        clearButton.setBackgroundColor(getResources().getColor(R.color.gray));

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setDrawingColor(getResources().getColor(R.color.red));
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setDrawingColor(getResources().getColor(R.color.yellow));
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setDrawingColor(getResources().getColor(R.color.green));
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setDrawingColor(getResources().getColor(R.color.blue));
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.clear();
            }
        });
    }
}

