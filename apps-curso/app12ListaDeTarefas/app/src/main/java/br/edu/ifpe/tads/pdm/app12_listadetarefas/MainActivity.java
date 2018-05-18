package br.edu.ifpe.tads.pdm.app12_listadetarefas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private EditText textSave;
    private Button buttonSave;
    private ListView listViewTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSave = findViewById(R.id.textSaveId);
        buttonSave = findViewById(R.id.buttonSaveId);
        listViewTasks = findViewById(R.id.listViewTasksId);

    }
}
