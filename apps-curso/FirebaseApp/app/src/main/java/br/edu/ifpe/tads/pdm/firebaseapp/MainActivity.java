package br.edu.ifpe.tads.pdm.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.edu.ifpe.tads.pdm.firebaseapp.model.Produto;
import br.edu.ifpe.tads.pdm.firebaseapp.model.Usuario;

public class MainActivity extends AppCompatActivity {


    /* Referencia o nó Raiz (root) da estrutura de dados do Firebase ;) */
    private DatabaseReference firebaseReferenciaRaiz = FirebaseDatabase.getInstance()
            .getReference();

    /* Referencia, a partir do nó raíz, os sub nós */
    private DatabaseReference usuariosReferenciaFB = firebaseReferenciaRaiz.child("usuarios");
    private  DatabaseReference produtosReferenciaFB = firebaseReferenciaRaiz.child("produtos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Navega para o nó pontos (se não existir, cria) e seta o valor dele para 200*/
        // firebasefirebaseDBReferencia.child("pontos").setValue("250");

        //usuarioDBReferencia.child("003").child("nome").setValue("Betânia Silva");


        Usuario usuario = new Usuario();
        usuario.setNome("Beco");
        usuario.setSobrenome("Silva");
        usuario.setIdade(45);
        usuario.setSexo("Masculino");

        usuariosReferenciaFB.child("002").setValue(usuario);

        Produto produto = new Produto();
        produto.setCor("Preto");
        produto.setDescricao("Notebook Inspiron");
        produto.setFabricante("DELL");

        produtosReferenciaFB.child("002").setValue(produto);
    }
}
