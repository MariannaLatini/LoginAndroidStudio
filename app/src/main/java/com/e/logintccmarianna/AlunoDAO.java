package com.e.logintccmarianna;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.e.logintccmarianna.Conexao;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public AlunoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public List<Aluno> obterTodos(){
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = banco.query("aluno", new String[]{"id_aluno", "email_aluno","senha_aluno"},null,null,null,null,null);

        while(cursor.moveToNext()){
            Aluno a = new Aluno();
            a.setId_aluno(cursor.getInt(0));
            a.setEmail_aluno(cursor.getString(1));
            a.setSenha_aluno(cursor.getString(2));
            alunos.add(a);
        }
            return alunos;
    }
    public long inserirLogin (Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("email_aluno", aluno.getEmail_aluno());
        values.put("senha_aluno", aluno.getSenha_aluno());
        return banco.insert("aluno",null,values);

    }

}
