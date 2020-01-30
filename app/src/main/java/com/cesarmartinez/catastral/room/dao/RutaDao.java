package com.cesarmartinez.catastral.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cesarmartinez.catastral.room.model.Ruta;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface RutaDao {
    @Insert
    void insert(Ruta ruta);
    @Insert(onConflict = REPLACE)
    void insertAll(List<Ruta> rutaList);
    @Update
    void update(Ruta ruta);
    @Delete
    void delete(Ruta ruta);
    @Query("DELETE FROM rutas")
    void deleteAllRutas();
    @Query("SELECT * FROM rutas ORDER BY rutsector,rutruta DESC")
    LiveData<List<Ruta>> getAllRutas();
    @Query("SELECT * FROM rutas WHERE rutruta=:rutaId")
    LiveData<Ruta> getObsRuta(String rutaId);

}
