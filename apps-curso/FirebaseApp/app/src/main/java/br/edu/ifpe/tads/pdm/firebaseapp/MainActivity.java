package br.edu.ifpe.tads.pdm.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.edu.ifpe.tads.pdm.firebaseapp.model.Produto;
import br.edu.ifpe.tads.pdm.firebaseapp.model.Usuario;

public class MainActivity extends AppCompatActivity {


    /* Referencia o nó Raiz (root) da estrutura de dados do Firebase ;) */
    private DatabaseReference firebaseReferenciaRaiz = FirebaseDatabase.getInstance()
            .getReference();

    /* Referencia, a partir do nó raíz, os sub nós */
    private DatabaseReference usuariosReferenciaFB = firebaseReferenciaRaiz.child("usuarios");
    private  DatabaseReference produtosReferenciaFB = firebaseReferenciaRaiz.child("produtos")
            .child("002");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Navega para o nó pontos (se não existir, cria) e seta o valor dele para 200*/
        // firebasefirebaseDBReferencia.child("pontos").setValue("250");

        //usuarioDBReferencia.child("003").child("nome").setValue("Betânia Silva");

//
//        Usuario usuario = new Usuario();
//        usuario.setNome("Cássio");
//        usuario.setSobrenome("Silva");
//        usuario.setIdade(24);
//        usuario.setSexo("Masculino");
//
//        usuariosReferenciaFB.child("002").setValue(usuario);
//
//
//        Produto produto = new Produto();
//        produto.setCor("Grafite");
//        produto.setDescricao("Moto G5 Plus");
//        produto.setFabricante("Motorola");
//
//        produtosReferenciaFB.child("002").setValue(produto);

        usuariosReferenciaFB.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
