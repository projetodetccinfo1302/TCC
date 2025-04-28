package com.example.tcc_1302_petmatch.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcc_1302_petmatch.R;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private List<Animal> listaAnimais;

    public AnimalAdapter(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cadastro_animal, parent, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = listaAnimais.get(position);
        holder.nomeAnimal.setText(animal.getNome());
        holder.especieRaca.setText(animal.getEspecie() + " - " + animal.getRaca());
    }

    @Override
    public int getItemCount() {
        return listaAnimais.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView nomeAnimal, especieRaca;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeAnimal = itemView.findViewById(R.id.txtNomeAnimal);
            especieRaca = itemView.findViewById(R.id.txtEspecie);
        }
    }
}

