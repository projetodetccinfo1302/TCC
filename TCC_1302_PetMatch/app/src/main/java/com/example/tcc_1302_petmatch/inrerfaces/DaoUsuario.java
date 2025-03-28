package com.example.tcc_1302_petmatch.inrerfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tcc_1302_petmatch.model.Usuario;

import java.util.List;

@Dao
public interface DaoUsuario {
    @Insert
    long Insert(Usuario usuario);
    // Busca um usuário pelo código (ID)

    @Query("SELECT * FROM usuario WHERE codigo = :codigo")
    Usuario getUsuarioById(int codigo);

    // Atualiza um usuário existente
    @Update
    void update(Usuario usuario);

    // Exclui um usuário
    @Delete
    void delete(Usuario usuario);


    @Query("SELECT * FROM USUARIO")
    LiveData<List<Usuario>> getAllUsuarios();

}
