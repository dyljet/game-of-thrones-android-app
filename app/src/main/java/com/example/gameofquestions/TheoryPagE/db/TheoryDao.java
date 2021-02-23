package com.example.gameofquestions.TheoryPagE.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.gameofquestions.TheoryPagE.Theory;

import java.util.List;


@Dao
public interface TheoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTheory(Theory theory);


    @Delete
    void deleteTheory(Theory... theory);


    @Update
    void updateTheory(Theory theory);


    @Query("SELECT * FROM Theory")
    List<Theory> getTheories();


    @Query("SELECT * FROM Theory WHERE id = :theoryId")
    Theory getTheoryById(int theoryId);



}
