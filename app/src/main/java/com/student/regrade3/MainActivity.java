package com.student.regrade3;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.student.regrade3.control.Regrade3Control;

import java.math.BigDecimal;



public class MainActivity extends AppCompatActivity {

    private EditText campo1;
    private EditText campo2;
    private EditText campo3;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo1 = findViewById(R.id.campo1);
        campo2 = findViewById(R.id.campo2);
        campo3 = findViewById(R.id.campo3);
        resultado = findViewById(R.id.resultado);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gerarResultado();
            }

            @Override
            public void afterTextChanged(Editable s) {}

        };

        campo1.addTextChangedListener(textWatcher);
        campo2.addTextChangedListener(textWatcher);
        campo3.addTextChangedListener(textWatcher);

    }

    @SuppressLint("SetTextI18n")
    public void gerarResultado() {

        String c1 = campo1.getText().toString();
        String c2 = campo2.getText().toString();
        String c3 = campo3.getText().toString();

        c1 = c1.replaceFirst(",", ".");
        c2 = c2.replaceFirst(",", ".");
        c3 = c3.replaceFirst(",", ".");

        try {
            BigDecimal result = Regrade3Control.calcular(c1,c2,c3);
            resultado.setText(result.toString());
            resultado.setError(null);
        } catch (Exception e) {
            resultado.setError("erro");
            resultado.setText("erro");
        }

    }

}