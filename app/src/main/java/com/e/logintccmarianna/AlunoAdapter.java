package com.e.logintccmarianna;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AlunoAdapter extends BaseAdapter {

    private List<Aluno> alunos;
    private Activity activity;

    public AlunoAdapter(Activity activity,List<Aluno> alunos) {
       this.activity = activity;
       this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();    }

    @Override
    public Object getItem(int position) {

        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId_aluno();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View v = activity.getLayoutInflater().inflate(R.layout.item, parent, false);
       TextView login = v.findViewById(R.id.loginList);
       TextView senha = v.findViewById(R.id.senhaList);
       Aluno a = alunos.get(position);
       login.setText(a.getEmail_aluno());
       senha.setText(a.getSenha_aluno());
       return v;
    }
}



