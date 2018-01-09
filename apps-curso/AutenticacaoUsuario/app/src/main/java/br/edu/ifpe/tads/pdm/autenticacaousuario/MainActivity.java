package br.edu.ifpe.tads.pdm.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         firebaseAuth = FirebaseAuth.getInstance();

//         firebaseAuth.signOut();

        /* Login ----------------------------------------------- */
        firebaseAuth.signInWithEmailAndPassword("sabrina@gmail.com", "sabrina123")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if( task.isSuccessful() ){

//                            Toast.makeText(getApplicationContext(), "sucesso login", Toast.LENGTH_SHORT).show();
                            Log.i("signInUser", "sucesso login usuário");

                        }else{
  //                          Toast.makeText(getApplicationContext(), "falha login", Toast.LENGTH_SHORT).show();
                            Log.i("signInUser", "falha login usuário");

                        }

                    }
                });


        if( firebaseAuth.getCurrentUser() != null ){
            Toast.makeText(getApplicationContext(), "Usuário logado", Toast.LENGTH_SHORT)
                    .show();
        }else{
            Toast.makeText(getApplicationContext(), "Usuário não logado", Toast.LENGTH_SHORT)
                    .show();
        }
//         /* Cadastro -------------------------------- */
//         firebaseAuth.createUserWithEmailAndPassword("betania@gmail.com", "betania123")
//                 .addOnCompleteListener(MainActivity.this,
//                         new OnCompleteListener<AuthResult>() {
//
//                     @Override
//                     public void onComplete(@NonNull Task<AuthResult> task) {
//                         Toast.makeText(getApplicationContext(), "entrou", Toast.LENGTH_SHORT).show();
//
//                         if( task.isSuccessful() ){
//
//                             Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_SHORT).show();
//                             Log.i("createUser", "Sucesso ao cadastrar usuário");
//                         }else{
//
//                            // getException é apenas para testes
//                             Toast.makeText(getApplicationContext(), "fail " + task.getException(), Toast.LENGTH_LONG).show();
//                             Log.i("createUser", "Falha ao cadastrar usuário");
//                         }
//                     }
//                 });



    }


}
