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

public class CadastroAnimal extends AppCompatActivity {

    private ActivityCadastroAnimalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroAnimalBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.buttonenviar.setOnClickListener(view -> {

            String nomeanimal = binding.txtNomeAnimal.getText().toString().trim();
            String especie = binding.txtespecie.getText().toString().trim();
            String raca = binding.txtraca.getText().toString().trim();
            String porte = binding.txtporte.getText().toString().trim();
            String sexo;
            if (binding.radioMasculino.isChecked() == true){
                sexo = "macho";
            } else {
                sexo = "fêmea";
            }
            String vacina = binding.txtvacina.getText().toString().trim();
            String castracao;
            if (binding.radiosim.isChecked() == true){
               castracao = "sim";
            } else {
                castracao = "não";
            }
            String cor = binding.txtcor.getText().toString().trim();
            String idadeText = binding.txtidadeanimal.getText().toString().trim();
            int idadeanimal = Integer.parseInt(idadeText);
            String peso = binding.txtpeso.getText().toString().trim();


            if (nomeanimal.isEmpty() || especie.isEmpty() || raca.isEmpty() || porte.isEmpty() || sexo.isEmpty()
                    || vacina.isEmpty() || castracao.isEmpty() || cor.isEmpty() || idadeanimal == 0 || peso == null) {
                Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                return;
            }

            Animal novoAnimal = new Animal(nomeanimal, especie, raca, porte, sexo, vacina, castracao, cor, idadeanimal, peso);

            MyApp.getDatabase().daoAnimal().insert(novoAnimal);

            Toast.makeText(this, "Animal cadastrado com sucesso.", Toast.LENGTH_SHORT).show();

            final long codanimal = MyApp.getDatabase().daoAnimal().insert(novoAnimal);

            Intent intent = new Intent(this, DetalhesAnimal.class);
            intent.putExtra("codanimal", (int) codanimal);
            startActivity(intent);
        });
    }
}