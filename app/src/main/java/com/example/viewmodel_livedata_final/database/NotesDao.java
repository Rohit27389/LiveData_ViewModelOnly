package com.example.viewmodel_livedata_final.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NotesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NoteEntity noteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NoteEntity> noteEntities);

    @Delete
    void deleteNote(NoteEntity noteEntity);

    @Query("DELETE FROM notes")
    int deleteAllNotes();

    @Query("SELECT * FROM notes WHERE id= :id")
    NoteEntity getNoteById(int id);

    @Query("SELECT * FROM notes ORDER BY date DESC")
    List<NoteEntity> getAllNotes();

    @Query("SELECT COUNT(*) FROM notes")
    int getCount();


}
