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

import com.example.tcc_1302_petmatch.R;
import com.example.tcc_1302_petmatch.databinding.ActivityCadastroAnimalBinding;

import java.util.concurrent.Executors;

public class CadastroAnimal extends AppCompatActivity {
private ActivityCadastroAnimalBinding binding;
private AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityCadastroAnimalBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
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
    String nomeanimal; String especie;
    String raca; String sexo;
    String vacinacao;String castracao;
    String cor;
    String idadeanimal; String peso;
    String complicacao;
    private void salvarUsuario() {
        // Captura os dados digitados na tela
        nomeanimal = binding.txtNomeAnimal.getText().toString().trim();
        especie = binding.txtespecie.getText().toString().trim();
        raca = binding.txtraca.getText().toString().trim();
        sexo = binding.txtsexanimal.getText().toString().trim();
        vacinacao = binding.txtvacina.getText().toString().trim();
        castracao = binding.txtcastracao.getText().toString().trim();
        cor = binding.txtcor.getText().toString().trim();
        idadeanimal = binding.txtidadeanimal.getText().toString().trim();
        peso = binding.txtpeso.getText().toString().trim();
        complicacao = binding.txtcomplicacao.toString().trim();

        // Verifica se algum campo está vazio
        if (nomeanimal.isEmpty() || especie.isEmpty() || raca.isEmpty() || sexo.isEmpty() ||
                vacinacao.isEmpty() || castracao.isEmpty() || cor.isEmpty() || cor.isEmpty() ||
                idadeanimal.isEmpty() || peso.isEmpty() || complicacao.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Converte idade para inteiro
        int idade = Integer.parseInt(idadeanimal);

        // Cria um objeto Usuario
        Animal animal = new Animal(nomeanimal,especie, raca, sexo, vacinacao, castracao, cor, idadeanimal, peso, complicacao);

        // Salva o animal no banco de dados (em uma thread separada)
        Executors.newSingleThreadExecutor().execute(() -> {
            database.daoAnimal().Insert(animal);
            runOnUiThread(() -> Toast.makeText(CadastroAnimal.this, "Animal salvo com sucesso!", Toast.LENGTH_SHORT).show());
            // Criando a Intent para abrir a tela DetalhesUser e passando os dados
            Intent intent = new Intent(CadastroAnimal.this, DetalheAnimal.class);

            intent.putExtra("nomeanimal", animal.getNOMEANIMAL());
            intent.putExtra("espeice", animal.getESPECIE());
            intent.putExtra("raca", animal.getRACA());
            intent.putExtra("sexo", animal.getSEXO());
            intent.putExtra("vacinacao", animal.getVACINACAO());
            intent.putExtra("castracao", animal.getCASTRACAO());
            intent.putExtra("cor", animal.getCOR());
            intent.putExtra("idadeanimal", animal.getIDADEANIMAL());
            intent.putExtra("peso", animal.getPESO());
            intent.putExtra("complicacao", animal.getCOMPLICACAO());
            startActivity(intent);
            finish();
        });
    };
}
