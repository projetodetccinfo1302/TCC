package com.example.tcc_1302_petmatch.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tcc_1302_petmatch.MainActivity;
import com.example.tcc_1302_petmatch.R;
import com.example.tcc_1302_petmatch.databinding.ActivityCadastroUsuarioBinding;

import java.util.concurrent.Executors;

public class CadastroUsuario extends AppCompatActivity {
    private ActivityCadastroUsuarioBinding binding;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroUsuarioBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        database = AppDatabase.getInstance(this);

        binding.buttonenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarUsuario();
            }
        });
    }

    // VARIÁVEL ESCRITA EM CARACTERES MINÚSCULOS PARA EVITAR CONFUSÕES
    String nome;
    String sobrenome;
    String cpf;
    String cep;
    // IDADE STR SERÁ CONVERTIDA PARA INT FUIURAMENTE
    String idadeStr;
    String email;
    String telefone;

    // FUNÇÃO QUE REGISTRA OS DADOS INSERIDOS VIA EDITEXT NO BANCO DE DADOS
    private void salvarUsuario() {
        nome = binding.txtNome.getText().toString().trim();
        sobrenome = binding.txtSNome.getText().toString().trim();
        cpf = binding.txtcpf.getText().toString().trim();
        cep = binding.txtcep.getText().toString().trim();
        idadeStr = binding.txtidade.getText().toString().trim();
        email = binding.txtemail.getText().toString().trim();
        telefone = binding.txtfone.getText().toString().trim();

        // VERIFICAÇÃO DOS CAMPOS

        // SE TODOS ESTIVEREM VAZIOS OU SE HOUVER ALGUM CAMPO AINDA NÃO PREENCHIDO:
        if (nome.isEmpty() || sobrenome.isEmpty() || cpf.isEmpty() || cep.isEmpty() ||
                idadeStr.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // CONVERTE A VARIÁVEL IDADESTR PARA INT
        int idadeusuario = Integer.parseInt(idadeStr);

        // SE O USUÁRIO FOR MENOR DE 18 ANOS:
        if (idadeusuario < 18) {
            Toast.makeText(this, "Você precisa ser maior de 18 anos para se cadastrar!", Toast.LENGTH_SHORT).show();
            return;
            // SE O USUÁRIO FOR MAIOR DE 18 ANOS:
        } else {
            Executors.newSingleThreadExecutor().execute(() -> {
                Usuario usuario = new Usuario(nome, sobrenome, cpf, cep, idadeusuario, email, telefone);
                long codigoGerado = database.daoUsuario().Insert(usuario);
                runOnUiThread(() -> {
                    Toast.makeText(CadastroUsuario.this, "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show();

                    // Criando a Intent para abrir a tela DetalhesUser e passando os dados
                    Intent intent = new Intent(CadastroUsuario.this, DetalhesUsuarioActivity.class);
                    intent.putExtra("codigo",  codigoGerado);
                    intent.putExtra("nome", usuario.getNOME());
                    intent.putExtra("sobrenome", usuario.getSOBRENOME());
                    intent.putExtra("cpf", usuario.getCPF());
                    intent.putExtra("cep", usuario.getCEP());
                    intent.putExtra("idade", usuario.getIDADE());
                    intent.putExtra("email", usuario.getEMAIL());
                    intent.putExtra("telefone", usuario.getTELEFONE());

                    startActivity(intent);
                    finish();
                });
            });
        }
    }
}