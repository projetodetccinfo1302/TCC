package com.example.tcc_1302_petmatch.inrerfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tcc_1302_petmatch.model.Animal;
import com.example.tcc_1302_petmatch.model.Usuario;

import java.util.List;

@Dao
public interface DaoAnimal {
    @Insert
    void Insert(Animal animal);
    @Query("SELECT * FROM animal WHERE microchip = :microchip")
    Animal getAnimalById(long microchip);

    // Atualiza um animal existente
    @Update
    void update(Animal animal);

    // Exclui um animal
    @Delete
    void delete(Animal animal);
    @Query("SELECT * FROM ANIMAL")
    LiveData<List<Animal>> getAllAnimais();

}
