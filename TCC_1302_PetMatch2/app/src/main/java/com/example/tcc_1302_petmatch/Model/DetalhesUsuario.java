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
    AppDatabase db; // Declara a instância do banco de dados, embora não esteja sendo usada diretamente no código
    private ActivityDetalhesUsuarioBinding binding; // Declara a variável de binding para acessar os componentes do layout

    // Método chamado quando a activity é criada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Infla o layout da Activity e cria uma instância do binding para acessar os componentes do layout
        binding = ActivityDetalhesUsuarioBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);

        // Ativa o modo Edge-to-Edge para ajustar o layout à borda da tela, sem interferência das barras do sistema
        EdgeToEdge.enable(this);

        // Define o layout da Activity utilizando o root do binding
        setContentView(binding.getRoot());

        // Aplica um listener para ajustar o padding do layout conforme os insets da barra do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Obtém os insets das barras do sistema (como barra de status e barra de navegação)
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Ajusta o padding do layout para que o conteúdo não seja coberto pelas barras do sistema
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; // Retorna os insets para a aplicação do listener
        });

        // Obtém o código do usuário a partir da Intent que iniciou essa Activity
        int codigoUsuario = getIntent().getIntExtra("coduser", -1);

        // Verifica se o código do usuário é válido (não é -1)
        if (codigoUsuario != -1) {
            // Busca o usuário no banco de dados usando o código fornecido
            Usuario usuario = MyApp.getDatabase().daoUsuario().buscarPorId(codigoUsuario);

            // Se o usuário for encontrado, exibe seus dados nos campos correspondentes
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
                // Se o usuário não for encontrado, exibe uma mensagem indicando que não foi encontrado
                binding.txtnome.setText("Usuário não encontrado.");
            }
        } else {
            // Se o código do usuário não for válido (é -1), exibe uma mensagem indicando que o código é inválido
            binding.txtnome.setText("Código inválido.");
        }
    }
}

