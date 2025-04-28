package com.example.tcc_1302_petmatch.Model;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tcc_1302_petmatch.MyApp;
import com.example.tcc_1302_petmatch.R;
import com.example.tcc_1302_petmatch.databinding.ActivityCadastroBinding;
import com.example.tcc_1302_petmatch.databinding.ActivityDetalhesUsuarioBinding;

public class DetalhesUsuario extends AppCompatActivity {
    AppDatabase db;
    private ActivityDetalhesUsuarioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityDetalhesUsuarioBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(binding.getRoot());
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

        int codigoUsuario = getIntent().getIntExtra("coduser", -1);

        if (codigoUsuario != -1) {
            Usuario usuario = MyApp.getDatabase().daoUsuario().buscarPorId(codigoUsuario);

            if (usuario != null) {
                binding.txtnome.setText("Nome: " + usuario.getNome());
                binding.txtsnome.setText("Sobrenome: " + usuario.getSobrenome());
                binding.txtemail.setText("E-Mail: " + usuario.getEmail());
                binding.txtsenha.setText("Senha: " + usuario.getSenha());
                binding.txttelefone.setText("Telefone: " + usuario.getTelefone());
                binding.txtcpf.setText("CPF: " + usuario.getCpf());
                binding.txtcep.setText("CEP: " + usuario.getCep());
                binding.txtidade.setText("Idade: " + usuario.getIdade());
                binding.txttipo.setText("Tipo: " + usuario.getTipo());
            } else {
                binding.txtnome.setText("Usuário não encontrado.");
            }
        } else {
            binding.txtnome.setText("Código inválido.");
        }
    }
}
