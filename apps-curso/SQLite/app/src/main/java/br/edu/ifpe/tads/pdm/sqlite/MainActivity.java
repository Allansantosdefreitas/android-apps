package br.edu.ifpe.tads.pdm.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("DB_myApp", MODE_PRIVATE,
                    null);
            String tablePersons = "TB_persons";
            String columnName = "name";
            String columnAge = "age";

                /* Creting table :) */
            sqLiteDatabase.execSQL(
                    "CREATE TABLE IF NOT EXISTS " + tablePersons +
                            "( name VARCHAR, age INT(3) )"

            );

        /* Inserting data :) */
            sqLiteDatabase.execSQL(
                    "INSERT INTO " + tablePersons + " (name, age) " +
                            "VALUES " +
                            "('Mathew', 50)"
            );

            sqLiteDatabase.execSQL(
                    "INSERT INTO " + tablePersons + " (name, age) " +
                            "VALUES " +
                            "('Mark', 38)"
            );

            sqLiteDatabase.execSQL(
                    "INSERT INTO " + tablePersons + " (name, age) " +
                            "VALUES " +
                            "('Luke', 49)"
            );

            sqLiteDatabase.execSQL(
                    "INSERT INTO " + tablePersons + " (name, age) " +
                            "VALUES " +
                            "('John', 73)"
            );

        /* Retrieving data from table with a SQL query... */
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT name, age FROM " + tablePersons,
                    null);

        /* Get the index value from column name */
            int nameColumnIndex = cursor.getColumnIndex("name");
            int ageColumnIndex = cursor.getColumnIndex("age");

        /* Move cursor to the first of table (to first line) */
            cursor.moveToFirst();

            while (cursor != null) {

                Log.i("RESULTADO: name", cursor.getString(nameColumnIndex));
                Log.i("RESULTADO: age", cursor.getString(ageColumnIndex));

            /* To next line ;) */
                cursor.moveToNext();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
