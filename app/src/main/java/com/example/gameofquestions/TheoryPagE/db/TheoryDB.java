package com.example.gameofquestions.TheoryPagE.db;



import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.gameofquestions.TheoryPagE.Theory;


@Database(entities = Theory.class, version = 1)
public abstract class TheoryDB extends RoomDatabase {
    public abstract TheoryDao theoriesDao();

    public static final String DATABSE_NAME = "theoriesDb";
    private static TheoryDB instance;

    public static TheoryDB getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, TheoryDB.class, DATABSE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }
}
