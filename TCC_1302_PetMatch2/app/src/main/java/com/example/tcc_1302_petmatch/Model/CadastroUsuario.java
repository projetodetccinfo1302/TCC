package com.example.tcc_1302_petmatch.Model;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.tcc_1302_petmatch.Homepage;
import com.example.tcc_1302_petmatch.Interfaces.DAOusuario;
import com.example.tcc_1302_petmatch.MyApp;
import com.example.tcc_1302_petmatch.R;
import com.example.tcc_1302_petmatch.databinding.ActivityCadastroUsuarioBinding;

public class CadastroUsuario extends AppCompatActivity {
    private ActivityCadastroUsuarioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonenviar.setOnClickListener(view -> {

            String nome = binding.txtNome.getText().toString().trim();
            String sobrenome = binding.txtSNome.getText().toString().trim();
            String email = binding.txtemail.getText().toString().trim();
            String senha = binding.txtsenha.getText().toString().trim();
            String telefone = binding.txtfone.getText().toString().trim();
            String cep = binding.txtcep.getText().toString().trim();
            String cpf = binding.txtcpf.getText().toString().trim();
            String idadeText = binding.txtidade.getText().toString().trim();
            int idade = Integer.parseInt(idadeText);

            String tipo = null;
            if (binding.checkAdotante.isChecked() && binding.checkDoador.isChecked()) {
                tipo = "Adotante e Doador";
            } else if (binding.checkAdotante.isChecked()) {
                tipo = "Adotante";
            } else if (binding.checkDoador.isChecked()) {
                tipo = "Doador";
            }

            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()
                    || telefone.isEmpty() || cep.isEmpty() || cpf.isEmpty() || idade == 0 || tipo == null) {
                Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                return;
            }

            if (idade < 18) {
                Toast.makeText(this, "É necessário ter mais de 18 anos para se cadastrar.", Toast.LENGTH_SHORT).show();
                return;
            }

            Usuario novoUsuario = new Usuario(nome, sobrenome, email, senha, telefone, cpf, cep, idade, tipo);

            MyApp.getDatabase().daoUsuario().insert(novoUsuario);

            Toast.makeText(this, "Usuário cadastrado com sucesso.", Toast.LENGTH_SHORT).show();

            final long coduser = MyApp.getDatabase().daoUsuario().insert(novoUsuario);

            Intent intent = new Intent(this, Homepage.class);
            intent.putExtra("coduser", (int) coduser);
            startActivity(intent);
        });
    }
}