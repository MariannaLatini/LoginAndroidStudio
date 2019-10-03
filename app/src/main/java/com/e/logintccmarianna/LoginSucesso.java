package com.e.logintccmarianna;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LoginSucesso extends AppCompatActivity {
    private Button btnSairLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsucesso);
        btnSairLogIn = (Button) findViewById(R.id.btnSairLogIn);
        eventoClicks();
    }
    private void eventoClicks(){
        btnSairLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TelaLogin.class);
                startActivity(i);
                finish();
            }
        });
    }
}




















