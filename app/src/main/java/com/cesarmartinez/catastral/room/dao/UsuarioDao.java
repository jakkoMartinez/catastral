package com.cesarmartinez.catastral.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.cesarmartinez.catastral.room.model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Usuario usuario);
    @Update
    void update(Usuario usuario);
    @Delete
    void delete(Usuario usuario);
    @Query("DELETE FROM usuarios")
    void deleteAllUsuarios();
    @Query("SELECT * FROM usuarios ORDER BY userid DESC")
    LiveData<List<Usuario>> getAllUsuarios();
    @Query("SELECT * FROM usuarios WHERE userid = :userCedula")
    LiveData<Usuario> getUsuariobycedula(String userCedula);

}
