package com.example.tcc_1302_petmatch.Interfaces;

// IMPORTS DA BIBLIOTECA ROOM PARA UTILIZAÇÃO DO CRUD
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tcc_1302_petmatch.Model.Animal;
import com.example.tcc_1302_petmatch.Model.Usuario;

import java.util.List;

// DECLARAÇÃO DO DAO DA ENTIDADE ANIMAL
@Dao
public interface DAOanimal {

    // CRIAÇÃO DO MÉTODO INSERT
    @Insert
    long insert(Animal animal);

    // CRIAÇÃO DO MÉTODO UPTDATE
    @Update
    void update(Animal animal);

    //CRIAÇÃO DO MÉTODO DELETE
    @Delete
    void delete(Animal animal);

    // CRIAÇÃO DE UMA LISTA PARA ARMAZENAR N USUÁRIOS
    @Query("SELECT * FROM Animal")
    List<Usuario> getAll();
    @Query("SELECT * FROM animal WHERE codigo = :id")
    Animal buscarPorId(int id);


}
