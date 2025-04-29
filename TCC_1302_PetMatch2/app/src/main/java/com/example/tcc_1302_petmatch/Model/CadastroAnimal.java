package com.example.tcc_1302_petmatch.Model;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tcc_1302_petmatch.MyApp;
import com.example.tcc_1302_petmatch.R;
import com.example.tcc_1302_petmatch.databinding.ActivityCadastroAnimalBinding;

// Classe CadastroAnimal, responsável pela tela de cadastro de novos animais
public class CadastroAnimal extends AppCompatActivity {

    // Binding para acessar os elementos da tela sem precisar usar findViewById
    private ActivityCadastroAnimalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializa o View Binding para acessar os elementos do layout
        binding = ActivityCadastroAnimalBinding.inflate(getLayoutInflater());

        // Habilita compatibilidade para ocupar a tela inteira, incluindo áreas do sistema
        EdgeToEdge.enable(this);

        // Define o layout da tela
        setContentView(binding.getRoot());

        // Ajusta automaticamente o padding para evitar sobreposição com barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Define ação de clique no botão "enviar"
        binding.buttonenviar.setOnClickListener(view -> {

            // Captura o valor de cada campo
            String nomeanimal = binding.txtNomeAnimal.getText().toString().trim();
            String especie = binding.txtespecie.getText().toString().trim();
            String raca = binding.txtraca.getText().toString().trim();
            String porte = binding.txtporte.getText().toString().trim();

            // Determina o sexo
            String sexo;
            if (binding.radioMasculino.isChecked() == true){
                sexo = "macho";
            } else {
                sexo = "fêmea";
            }

            String vacina = binding.txtvacina.getText().toString().trim();

            // Determina se é castrado
            String castracao;
            if (binding.radiosim.isChecked() == true){
                castracao = "sim";
            } else {
                castracao = "não";
            }

            String cor = binding.txtcor.getText().toString().trim();
            String idadeText = binding.txtidadeanimal.getText().toString().trim();

            // Converte a idade para inteiro
            int idadeanimal = Integer.parseInt(idadeText);

            String peso = binding.txtpeso.getText().toString().trim();

            // Verifica se todos os campos obrigatórios foram preenchidos
            if (nomeanimal.isEmpty() || especie.isEmpty() || raca.isEmpty() || porte.isEmpty() || sexo.isEmpty()
                    || vacina.isEmpty() || castracao.isEmpty() || cor.isEmpty() || idadeanimal == 0 || peso == null) {
                Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cria um novo objeto Animal com os dados informados
            Animal novoAnimal = new Animal(nomeanimal, especie, raca, porte, sexo, vacina, castracao, cor, idadeanimal, peso);

            // Salva o animal no banco de dados
            MyApp.getDatabase().daoAnimal().insert(novoAnimal);

            // Mostra mensagem de sucesso
            Toast.makeText(this, "Animal cadastrado com sucesso.", Toast.LENGTH_SHORT).show();

            // Insere novamente o animal e obtém o ID gerado
            final long codanimal = MyApp.getDatabase().daoAnimal().insert(novoAnimal);

            // Navega para a tela de detalhes do animal recém-cadastrado
            Intent intent = new Intent(this, DetalhesAnimal.class);
            intent.putExtra("codanimal", (int) codanimal);
            startActivity(intent);
        });
    }
}
