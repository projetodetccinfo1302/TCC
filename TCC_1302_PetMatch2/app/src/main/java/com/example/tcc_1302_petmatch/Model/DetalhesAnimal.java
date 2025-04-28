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

    private ActivityDetalhesAnimalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalhesAnimalBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int codigoanimal = getIntent().getIntExtra("codanimal", -1);

        if (codigoanimal != -1) {
            Animal animal = MyApp.getDatabase().daoAnimal().buscarPorId(codigoanimal);

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
                binding.txtNome.setText("Usuário não encontrado.");
            }
        } else {
            binding.txtNome.setText("Código inválido.");
        }
    }
}
