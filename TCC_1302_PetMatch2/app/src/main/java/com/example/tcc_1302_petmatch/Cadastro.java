package com.example.tcc_1302_petmatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tcc_1302_petmatch.Model.CadastroUsuario;
import com.example.tcc_1302_petmatch.databinding.ActivityCadastroBinding;
import com.example.tcc_1302_petmatch.databinding.ActivityMainBinding;

public class Cadastro extends AppCompatActivity {

    // DECLARAÇÃO DO BINDING
    private ActivityCadastroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // FUNÇÃO QUE REDIRECIONA PARA A TELA DE CADASTRO DE USUÁRIO
        binding.buttoncadastraruser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this, CadastroUsuario.class);
                startActivity(intent);
                // FINALIZAÇÃO DA MAINACTIVITY
                finish();
            }
        });
        // FUNÇÃO QUE REDIRECIONA PARA A TELA DE CADASTRO DE PET
        binding.buttoncadastrarpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this, Cadastro.class);
                startActivity(intent);
                // FINALIZAÇÃO DA MAINACTIVITY
                finish();
            }
        });
    }
    }

