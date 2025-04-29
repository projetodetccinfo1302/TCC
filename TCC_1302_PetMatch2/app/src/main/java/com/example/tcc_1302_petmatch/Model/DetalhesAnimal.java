package com.example.tcc_1302_petmatch.Model;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tcc_1302_petmatch.MyApp;
import com.example.tcc_1302_petmatch.R;
import com.example.tcc_1302_petmatch.databinding.ActivityDetalhesAnimalBinding;

public class DetalhesAnimal extends AppCompatActivity {

    private ActivityDetalhesAnimalBinding binding; // Declara a variável de binding para acessar os componentes do layout

    // Método chamado quando a activity é criada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Infla o layout da Activity e cria uma instância do binding para acessar os componentes da interface
        binding = ActivityDetalhesAnimalBinding.inflate(getLayoutInflater());

        // Ativa o modo Edge-to-Edge para ajustar o layout à borda da tela, sem interferência das barras do sistema
        EdgeToEdge.enable(this);

        // Define o layout da Activity usando o root do binding (a raiz do layout XML)
        setContentView(binding.getRoot());

        // Aplica um listener para ajustar o padding do layout conforme os insets da barra do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Obtém os insets das barras do sistema (como barra de status e barra de navegação)
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Ajusta o padding do layout para não ser ocultado pelas barras do sistema
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; // Retorna os insets para a aplicação do listener
        });

        // Obtém o código do animal a partir da Intent que iniciou essa Activity
        int codigoanimal = getIntent().getIntExtra("codanimal", -1);

        // Verifica se o código do animal é válido (não é -1)
        if (codigoanimal != -1) {
            // Busca o animal no banco de dados usando o código fornecido
            Animal animal = MyApp.getDatabase().daoAnimal().buscarPorId(codigoanimal);

            // Se o animal for encontrado, exibe seus dados nos campos correspondentes
            if (animal != null) {
                binding.txtNome.setText("Nome: " + animal.getNome());
                binding.txtEspecie.setText("Espécie: " + animal.getEspecie());
                binding.txtRaca.setText("Raça: " + animal.getRaca());
                binding.sexo.setText("Sexo: " + animal.getSexo());
                binding.txtporte.setText("Porte: " + animal.getPorte());
                binding.txtvacina.setText("Vacina: " + animal.getVacinacao());
                binding.txtcastracao.setText("Castração: " + animal.getCastracao());
                binding.txtcor.setText("Cor: " + animal.getCor());
                binding.txtidade.setText("Idade: " + animal.getIdade());
                binding.txtpeso.setText("Peso: " + animal.getPeso());
                binding.txtcomplicacao.setText("Complicação: " + animal.getComplicacao());
            } else {
                // Se o animal não for encontrado, exibe uma mensagem de erro
                binding.txtNome.setText("Usuário não encontrado.");
            }
        } else {
            // Se o código do animal não for válido (é -1), exibe uma mensagem de erro
            binding.txtNome.setText("Código inválido.");
        }
    }
}
