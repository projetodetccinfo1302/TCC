package com.example.tcc_1302_petmatch.model;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tcc_1302_petmatch.inrerfaces.DaoAnimal;
import com.example.tcc_1302_petmatch.inrerfaces.DaoUsuario;

@Database(entities = {Usuario.class, Animal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    public abstract DaoUsuario daoUsuario();
    public abstract DaoAnimal daoAnimal();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
