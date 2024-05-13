package com.estudo.exerciciodados;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private Spinner spinner;
    private Button btnGerar;
    private TextView tvSaida;
    private Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radio1.findViewById(R.id.radio1);
        radio1.setChecked(true);
        radio2.findViewById(R.id.radio2);
        radio3.findViewById(R.id.radio3);
        btnGerar.findViewById(R.id.btnGerar);
        spinner.findViewById(R.id.spinner);
        tvSaida.findViewById(R.id.tvSaida);

    }
    private void gerar(){
        Integer qtd = (Integer) spinner.getSelectedItem();
        int resultado = random.nextInt(qtd);
        tvSaida.setText(resultado);
    }
    private void preencherSpinner(){
        List<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.add(20);
        lista.add(100);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}