package com.larissa.imc2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult = findViewById(R.id.textViewResult);
        TextView textViewMessage = findViewById(R.id.textViewMessage);
        ImageView imageViewEmoji = findViewById(R.id.imageViewEmoji);
        Button btnBack = findViewById(R.id.btnBack);

        // Obter o resultado do IMC da Intent
        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("BMI_RESULT", 0.0);

        // Exibir o resultado do IMC e mensagem correspondente
        textViewResult.setText(String.format("Seu IMC: %.2f", bmi));

        if (bmi < 18.5) {
            textViewMessage.setText("Você está abaixo do peso.");
            imageViewEmoji.setImageResource(R.drawable.emoji_sad);
        } else if (bmi < 24.9) {
            textViewMessage.setText("Seu peso está saudável!");
            imageViewEmoji.setImageResource(R.drawable.emoji_happy);
        } else if (bmi < 29.9) {
            textViewMessage.setText("Você está acima do peso.");
            imageViewEmoji.setImageResource(R.drawable.emoji_sad);
        } else {
            textViewMessage.setText("Você tem obesidade mórbida.");
            imageViewEmoji.setImageResource(R.drawable.emoji_very_sad);
        }

        // Adicionar clique do botão de voltar
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Fecha a ResultActivity e retorna à MainActivity
            }
        });
    }
}

