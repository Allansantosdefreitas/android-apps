package br.edu.ifpe.tads.pdm.app10_preferenciascor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroupId;
    private RadioButton radioButtonSelecionadoId;
    private Button botaoSalvarId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupId = findViewById(R.id.radioGroupId);
        botaoSalvarId = findViewById(R.id.botaoSalvarId);

        botaoSalvarId.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                /* Continua ........................ */
            }
        });
    }
}
