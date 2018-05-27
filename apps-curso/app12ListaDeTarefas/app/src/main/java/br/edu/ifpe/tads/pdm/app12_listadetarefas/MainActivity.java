package br.edu.ifpe.tads.pdm.app12_listadetarefas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText taskValueEL;
    private EditText taskTitleEL;
    private Button buttonSaveEL;
    private ListView listViewTasksEL;
    private SQLiteDatabase sqLiteDatabaseTasks;

    private ArrayAdapter<String> tasksArrayAdapter;
    private ArrayList<String> tasksArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {


//        taskTitleEL = findViewById(R.id.textSaveId);
            taskValueEL = findViewById(R.id.textSaveId);
            buttonSaveEL = findViewById(R.id.buttonSaveId);
            listViewTasksEL = findViewById(R.id.listViewTasksId);

            sqLiteDatabaseTasks = openOrCreateDatabase("taskDatabase", MODE_PRIVATE, null);

            sqLiteDatabaseTasks.execSQL(
                    "CREATE TABLE IF NOT EXISTS TB_tasks " +
                            "( " +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "taskTitle VARCHAR," +
                            "taskValue VARCHAR" +
                            ")"
            );

            buttonSaveEL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                /* Getting value of task */
                    String taskText = taskValueEL.getText().toString();

                    saveTask(taskText);
                }
            });

            retrieveTasks();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void saveTask(String taskValue) {

        try {

            if (taskValue.equals("")) {
                Toast.makeText(MainActivity.this, "Insert a task value, please :/",
                        Toast.LENGTH_SHORT).show();

            } else {

        /* Saving task on database */
                sqLiteDatabaseTasks.execSQL(
                        "INSERT INTO TB_tasks (taskValue) VALUES" +
                                "( " +
                                " '" + taskValue + "' " +
                                ")"
                );

                Toast.makeText(MainActivity.this, "Task saved successfully ;)",
                        Toast.LENGTH_SHORT).show();

                taskValueEL.setText("");
                retrieveTasks();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void retrieveTasks() {


        try {

            tasksArrayList = new ArrayList<String>();

            tasksArrayAdapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    tasksArrayList
            );

            listViewTasksEL.setAdapter(tasksArrayAdapter);

            Cursor cursor = sqLiteDatabaseTasks.rawQuery(
                    "SELECT taskValue FROM TB_tasks ORDER BY id DESC",
                    null
            );


            /* Getting the index (integer value) of field 'taskValue' */
            int indexTaskValue = cursor.getColumnIndex("taskValue");

            cursor.moveToFirst();

            while (cursor != null) {

                String taskValueTemp =  cursor.getString(indexTaskValue);

                tasksArrayList.add( taskValueTemp );

                Log.i("RESULT: task", taskValueTemp);

                cursor.moveToNext();
            }



        }catch ( Exception e ){
            e.printStackTrace();
        }

    }
}
