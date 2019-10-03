package com.e.logintccmarianna;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ListaAlunos extends AppCompatActivity {
    private ListView listView;
    private Button btnVoltarLista;
    private AlunoDAO dao;
    private List<Aluno> alunos;
    private List<Aluno> alunosFiltrados = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        btnVoltarLista = findViewById(R.id.btnVoltarLista);
        listView = findViewById(R.id.login_alunos);
        listView = findViewById(R.id.senha_aluno);
        dao = new AlunoDAO(this);
        alunos = dao.obterTodos();
        alunosFiltrados.addAll(alunos);
        AlunoAdapter adaptador = new AlunoAdapter(this, alunosFiltrados);
        listView.setAdapter(adaptador);
        eventoClicks();
    }

    private void eventoClicks() {
        btnVoltarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TelaLogin.class);
                startActivity(i);
                finish();
            }
        });
    }
}



