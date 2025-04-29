package com.example.tcc_1302_petmatch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tcc_1302_petmatch.Model.Animal;
import com.example.tcc_1302_petmatch.Model.AnimalAdapter;
import com.example.tcc_1302_petmatch.Model.CadastroAnimal;
import com.example.tcc_1302_petmatch.Model.Usuario;
import com.example.tcc_1302_petmatch.databinding.ActivityHomepageBinding;

import java.util.List;

public class Homepage extends AppCompatActivity {

    private ActivityHomepageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomepageBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            WindowInsetsCompat.Type.systemBars();
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });

        int codigoUsuario = getIntent().getIntExtra("coduser", -1);

        if (codigoUsuario != -1) {
            Usuario usuario = MyApp.getDatabase().daoUsuario().buscarPorId(codigoUsuario);

            if (usuario != null) {
                binding.txtNomeUsuario.setText(usuario.getNome() + " " + usuario.getSobrenome());
                binding.txtEmailUsuario.setText(usuario.getEmail());
                binding.txtTelefoneUsuario.setText("Telefone: " + usuario.getTelefone());
                binding.txtTipoUsuario.setText("Tipo: " + usuario.getTipo());
            } else {
                Toast.makeText(this, "Usuário não encontrado.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Erro ao carregar perfil.", Toast.LENGTH_SHORT).show();
        }

        binding.btnCadastroanimal.setOnClickListener(view -> {
            Intent intent = new Intent(this, CadastroAnimal.class);
            startActivity(intent);
            finish();
        });
        private void carregarAnimais() {
            List<Animal> listaAnimais = MyApp.getDatabase().daoAnimal().buscarPorId();
            AnimalAdapter adapter = new AnimalAdapter(listaAnimais);

            binding.recyclerAnimais.setLayoutManager(new LinearLayoutManager(this));
            binding.recyclerAnimais.setAdapter(adapter);

        }
        binding.btnEditarPerfil.setOnClickListener(view -> {
            Usuario usuario = MyApp.getDatabase().daoUsuario().buscarPorId(codigoUsuario);

            if (usuario != null) {
                usuario.getNome(); = "Novo Nome";
                usuario.getEmail(); = "novoemail@email.com";
                MyApp.getDatabase().daoUsuario().update(usuario);
                Toast.makeText(this, "Usuário atualizado!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnExcluirUsuario.setOnClickListener(view -> {
            Usuario usuario = MyApp.getDatabase().daoUsuario().buscarPorId(codigoUsuario);

            if (usuario != null) {
                MyApp.getDatabase().daoUsuario().delete(usuario);
                Toast.makeText(this, "Conta excluída!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Cadastro.class));
                finish();
            }
        });
    }
    }