package com.example.tcc_1302_petmatch.Model;

// IMPORTS RELACIONADOS AO ROOM PARA A CRIAÇÃO DA CLASSE APPDATABASE
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tcc_1302_petmatch.Interfaces.DAOanimal;
import com.example.tcc_1302_petmatch.Interfaces.DAOusuario;

// CRIAÇÃO DO BANCO DE DADOS
@Database(entities = {Usuario.class, Animal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract DAOusuario daoUsuario();
    public abstract DAOanimal daoAnimal();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "meu_banco_de_dados")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
