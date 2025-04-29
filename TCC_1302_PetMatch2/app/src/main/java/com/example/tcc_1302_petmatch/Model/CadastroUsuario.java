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

    // Método chamado quando a activity é criada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Infla o layout da Activity e cria uma instância do binding para acessar os componentes do layout
        binding = ActivityCadastroUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // Define o layout da Activity usando o root do binding

        // Configura o listener do botão de envio
        binding.buttonenviar.setOnClickListener(view -> {

            // Obtém os valores inseridos pelo usuário nos campos de texto e remove espaços extras
            String nome = binding.txtNome.getText().toString().trim();
            String sobrenome = binding.txtSNome.getText().toString().trim();
            String email = binding.txtemail.getText().toString().trim();
            String senha = binding.txtsenha.getText().toString().trim();
            String telefone = binding.txtfone.getText().toString().trim();
            String cep = binding.txtcep.getText().toString().trim();
            String cpf = binding.txtcpf.getText().toString().trim();
            String idadeText = binding.txtidade.getText().toString().trim();
            int idade = Integer.parseInt(idadeText); // Converte a idade para um inteiro

            // Define o tipo de usuário com base nas opções selecionadas
            String tipo = null;
            if (binding.checkAdotante.isChecked() && binding.checkDoador.isChecked()) {
                tipo = "Adotante e Doador";
            } else if (binding.checkAdotante.isChecked()) {
                tipo = "Adotante";
            } else if (binding.checkDoador.isChecked()) {
                tipo = "Doador";
            }

            // Valida se algum campo obrigatório não foi preenchido
            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()
                    || telefone.isEmpty() || cep.isEmpty() || cpf.isEmpty() || idade == 0 || tipo == null) {
                Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                return; // Interrompe a execução se houver campos vazios
            }

            // Valida se a idade é menor que 18
            if (idade < 18) {
                Toast.makeText(this, "É necessário ter mais de 18 anos para se cadastrar.", Toast.LENGTH_SHORT).show();
                return; // Interrompe a execução se a idade for inferior a 18
            }

            // Cria um novo objeto Usuario com os dados fornecidos
            Usuario novoUsuario = new Usuario(nome, sobrenome, email, senha, telefone, cpf, cep, idade, tipo);

            // Insere o novo usuário no banco de dados
            MyApp.getDatabase().daoUsuario().insert(novoUsuario);

            // Exibe uma mensagem de sucesso ao usuário
            Toast.makeText(this, "Usuário cadastrado com sucesso.", Toast.LENGTH_SHORT).show();

            // Insere novamente o usuário para obter o código de usuário retornado pelo banco de dados
            final long coduser = MyApp.getDatabase().daoUsuario().insert(novoUsuario);

            // Cria uma intenção para navegar para a página inicial
            Intent intent = new Intent(this, Homepage.class);
            intent.putExtra("coduser", (int) coduser); // Passa o código do usuário para a próxima Activity
            startActivity(intent); // Inicia a Activity Homepage
        });
    }
}
