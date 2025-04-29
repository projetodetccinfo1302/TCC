
package com.example.tcc_1302_petmatch.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcc_1302_petmatch.R;

import java.util.List;

// Classe AnimalAdapter que estende RecyclerView.Adapter
// Serve para conectar os dados dos animais a um RecyclerView (lista na tela)
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    // Lista de animais que será exibida no RecyclerView
    private List<Animal> listaAnimais;

    // Construtor da classe que recebe a lista de animais
    public AnimalAdapter(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Cria um novo item (view) a partir do layout XML
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cadastro_animal, parent, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        // Associa os dados do animal a view
        Animal animal = listaAnimais.get(position);
        holder.nomeAnimal.setText(animal.getNome()); // Define o nome do animal
        holder.especieRaca.setText(animal.getEspecie() + " - " + animal.getRaca()); // Define a espécie e raça
    }

    @Override
    public int getItemCount() {
        // Retorna o número de itens na lista
        return listaAnimais.size();
    }

    // Classe interna que representa cada item do RecyclerView
    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        // Declara TextViews para o nome e a espécie/raça
        TextView nomeAnimal, especieRaca;

        // Construtor que recebe a view do item e inicializa os TextViews
        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeAnimal = itemView.findViewById(R.id.txtNomeAnimal); // TextView para o nome do animal
            especieRaca = itemView.findViewById(R.id.txtEspecie);   // TextView para a espécie e raça
        }
    }
}

