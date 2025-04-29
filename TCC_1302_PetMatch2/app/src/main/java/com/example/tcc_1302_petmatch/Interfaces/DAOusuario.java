package com.example.tcc_1302_petmatch.Interfaces;

// IMPORTS DA BIBLIOTECA ROOM PARA UTILIZAÇÃO DO CRUD
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tcc_1302_petmatch.Model.Usuario;

import java.util.List;

// DECLARAÇÃO DO DAO DA ENTIDADE USUÁRIO
@Dao
public interface DAOusuario {

    // CRIAÇÃO DO MÉTODO INSERT
    @Insert
    long insert(Usuario usuario);

    // CRIAÇÃO DO MÉTODO UPTDATE
    @Update
    void update(Usuario usuario);

    //CRIAÇÃO DO MÉTODO DELETE
    @Delete
    void delete(Usuario usuario);

    // CRIAÇÃO DE UMA LISTA PARA ARMAZENAR N USUÁRIOS
    @Query("SELECT * FROM Usuario")
    List<Usuario> getAll();
    @Query("SELECT * FROM usuario WHERE codigo = :id")
    Usuario buscarPorId(int id);
}
