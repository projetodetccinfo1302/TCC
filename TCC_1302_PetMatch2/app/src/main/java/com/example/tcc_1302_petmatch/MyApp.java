package com.example.tcc_1302_petmatch;
import android.app.Application;

import androidx.room.Room;

import com.example.tcc_1302_petmatch.Model.AppDatabase;

public class MyApp extends Application {
    private static AppDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "User-database")
                .allowMainThreadQueries() // apenas para testes
                .build();
    }
    public static AppDatabase getDatabase() {
        return database;
    }
}