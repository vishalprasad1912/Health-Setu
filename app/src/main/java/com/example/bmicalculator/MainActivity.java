package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llmain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtw, edthtf, edthti;
        Button btncalculate;
        TextView textresult;
        LinearLayout llmain;

        edtw = findViewById(R.id.edtw);
        edthtf = findViewById(R.id.edthtf);
        edthti = findViewById(R.id.edthti);
        btncalculate = findViewById(R.id.btncalculate);
        textresult = findViewById(R.id.textresult);
        llmain = findViewById(R.id.llmain);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtw.getText().toString());
                int htf = Integer.parseInt(edthtf.getText().toString());
                int hti = Integer.parseInt(edthti.getText().toString());

                int totalIn = htf * 12 + hti;
                double totalCm = totalIn * 2.54;
                double finalHeight = totalCm / 100;

                double bmi = wt / (finalHeight * finalHeight);
                int finalBmi = (int) bmi;

                if (bmi > 24.9) {
                    textresult.setText("BMI is:"+finalBmi+"\nYou are Overweight!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.overweight));
                } else if (bmi > 18.5 && bmi<24.9) {
                    textresult.setText("BMI is:"+finalBmi+"\nYou are Healthy.");
                    llmain.setBackgroundColor(getResources().getColor(R.color.healthy));
                } else {
                    textresult.setText("BMI is:"+finalBmi+"\nYou are Underweight!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.underweight));
                }
            }
        });
    }
};
