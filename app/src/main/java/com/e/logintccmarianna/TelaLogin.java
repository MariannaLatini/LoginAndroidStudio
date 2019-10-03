package com.e.logintccmarianna;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class TelaLogin extends AppCompatActivity {

    private EditText inpLogin,inpSenha;
    private Button btnEntrar,btnCadastrar,btnListarAlunos,btnSair,btnInserirAlunos;
    private AlunoDAO dao;
    private Aluno aluno;
    private List<Aluno> alunos;
    private List<Aluno> alunosFiltrados = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telalogin);
        inpLogin = findViewById(R.id.inpLogin);
        inpSenha = findViewById(R.id.inpSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnSair = findViewById(R.id.btnSair);
        btnInserirAlunos =findViewById(R.id.btnInserirAlunos);
        btnListarAlunos= findViewById(R.id.btnListarAlunos);
        dao = new AlunoDAO(this);
        eventoClicks();
    }

    private void eventoClicks(){

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String login = inpLogin.getText().toString();
                String senha = inpSenha.getText().toString();
                 if (isCampoVazio(login)) {
                           alert("LOGIN NÃO PREENCHIDO !");
                     } else if (procuraLogin(login)) {
                             alert("LOGIN NÃO CADASTRADO !");
                         } else if (isCampoVazio(senha)) {
                                  alert("SENHA INVÁLIDA !");
                              } else if (procuraSenha(login,senha)) {
                                        alert("SENHA INVÁLIDA !");;
                                    } else {
                                           Intent i = new Intent(getApplicationContext(), LoginSucesso.class);
                                           startActivity(i);
                                           finish();
                                      }
                                        }
        });
        btnListarAlunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ListaAlunos.class);
                startActivity(i);
                finish();
            }
        });
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                alert("TELA DE CADASTRO EM CONSTRUÇÃO !");
            }
        });
        btnInserirAlunos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String login = inpLogin.getText().toString();
                String senha = inpSenha.getText().toString();
                if (isCampoVazio(login)) {
                    alert("LOGIN NÃO PREENCHIDO !");
                } else if (!procuraLogin(login)) {
                    alert("EMAIL JÁ CADASTRADO !");
                } else if (isCampoVazio(senha)) {
                    alert("SENHA NÃO PREENCHIDA !");
                }else{
                    Aluno a = new Aluno();
                    a.setEmail_aluno(login);
                    a.setSenha_aluno(senha);
                    dao.inserirLogin(a);
                    alert("ALUNO INSERIDO COM SUCESSO !");
                    Intent i = new Intent(getApplicationContext(),TelaLogin.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        btnSair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    public boolean procuraLogin(String email){
        alunos = dao.obterTodos();
        alunosFiltrados.clear();
        for(Aluno a : alunos){
            if(a.getEmail_aluno().toLowerCase().equals(email.toLowerCase())){
                alunosFiltrados.add(a);
            }
        }
        if (alunosFiltrados !=null && !alunosFiltrados.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public boolean procuraSenha(String email, String senha){
        alunos = dao.obterTodos();
        alunosFiltrados.clear();
        for(Aluno a : alunos){
            if((a.getEmail_aluno().toLowerCase().equals(email.toLowerCase())) &&
                    (a.getSenha_aluno().toLowerCase().equals(senha.toLowerCase()))){
                alunosFiltrados.add(a);
            }
        }
        if (alunosFiltrados !=null && !alunosFiltrados.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private void alert(String s){
        Toast.makeText(TelaLogin.this,s,Toast.LENGTH_LONG).show();
    }
}