package com.cesarmartinez.catastral.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cesarmartinez.catastral.room.model.Marca;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MarcaDao {
    @Insert
    void insert(Marca marca);
    @Insert(onConflict = REPLACE)
    void insertAll(List<Marca> marcaList);
    @Update
    void update(Marca marca);
    @Delete
    void delete(Marca marca);
    @Query("DELETE FROM marcas")
    void deleteAllMarcas();
    @Query("SELECT * FROM marcas ORDER BY marcacodigo DESC")
    LiveData<List<Marca>> getAllMarcas();
}
