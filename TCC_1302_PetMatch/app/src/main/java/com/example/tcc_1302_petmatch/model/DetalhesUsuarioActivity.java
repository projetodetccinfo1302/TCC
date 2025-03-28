package com.example.tcc_1302_petmatch.model;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tcc_1302_petmatch.R;
import com.example.tcc_1302_petmatch.databinding.ActivityDetalhesUserBinding;

import java.util.concurrent.Executors;

public class DetalhesUsuarioActivity extends AppCompatActivity {

    private ActivityDetalhesUserBinding binding;
    private TextView txtCodigo, txtNome, txtSobrenome, txtCpf, txtCep, txtIdade, txtEmail, txtTelefone;
    private Button btnEditar, btnExcluir;
    private int usuarioCodigo; // Código do usuário

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        // Inicializar Views
        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtCpf = findViewById(R.id.txtCpf);
        txtCep = findViewById(R.id.txtCep);
        txtIdade = findViewById(R.id.txtIdade);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);
        btnEditar = findViewById(R.id.btnEditar);
        btnExcluir = findViewById(R.id.btnExcluir);

        // Verificar se a Intent tem os dados necessários
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("codigo")) {
            usuarioCodigo = intent.getIntExtra("codigo", -1);

            if (usuarioCodigo != -1) {
                // Exibir o código do usuário na tela
                txtCodigo.setText("Código: " + usuarioCodigo);

                txtNome.setText("Nome: " + intent.getStringExtra("nome"));
                txtSobrenome.setText("Sobrenome: " + intent.getStringExtra("sobrenome"));
                txtCpf.setText("CPF: " + intent.getStringExtra("cpf"));
                txtCep.setText("CEP: " + intent.getStringExtra("cep"));

                int idade = intent.getIntExtra("idade", -1);
                txtIdade.setText(idade != -1 ? "Idade: " + idade : "Idade: Não informado");

                txtEmail.setText("Email: " + intent.getStringExtra("email"));
                txtTelefone.setText("Telefone: " + intent.getStringExtra("telefone"));
            } else {
                Toast.makeText(this, "Erro ao carregar os dados do usuário!", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            Toast.makeText(this, "Nenhum usuário encontrado!", Toast.LENGTH_SHORT).show();
            finish();
        }

        // Botão Editar
        btnEditar.setOnClickListener(v -> {
            Intent editIntent = new Intent(DetalhesUsuarioActivity.this, CadastroUsuario.class);
            editIntent.putExtra("codigo", usuarioCodigo);
            startActivity(editIntent);
        });

        // Botão Excluir
        btnExcluir.setOnClickListener(v -> excluirUsuario());
    }

    // Método para excluir usuário do banco de dados
    private void excluirUsuario() {
        Executors.newSingleThreadExecutor().execute(() -> {
            AppDatabase db = AppDatabase.getInstance(getApplicationContext());

            if (usuarioCodigo != -1) {
                Usuario usuario = db.daoUsuario().getUsuarioById(usuarioCodigo);

                if (usuario != null) {
                    db.daoUsuario().delete(usuario);
                    runOnUiThread(() -> {
                        Toast.makeText(DetalhesUsuarioActivity.this, "Usuário excluído!", Toast.LENGTH_SHORT).show();
                        finish();
                    });
                } else {
                    runOnUiThread(() ->
                            Toast.makeText(DetalhesUsuarioActivity.this, "Erro ao excluir: usuário não encontrado!", Toast.LENGTH_SHORT).show()
                    );
                }
            }
        });
    }
}