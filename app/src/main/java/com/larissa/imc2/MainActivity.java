package com.larissa.imc2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndShowResult();
            }
        });
    }

    private void calculateAndShowResult() {
        // Obter peso e altura do usuário
        double weight = Double.parseDouble(editTextWeight.getText().toString());
        double height = Double.parseDouble(editTextHeight.getText().toString());

        // Calcular o IMC
        double bmi = weight / (height * height);

        // Criar Intent para a tela de resultados
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);

        // Passar o resultado do IMC para a próxima tela
        intent.putExtra("BMI_RESULT", bmi);

        // Iniciar a próxima tela
        startActivity(intent);
    }
}
