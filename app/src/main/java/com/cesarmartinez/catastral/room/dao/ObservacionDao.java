package com.cesarmartinez.catastral.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cesarmartinez.catastral.room.model.Observacion;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ObservacionDao {
    @Insert
    void insert(Observacion observacion);
    @Insert(onConflict = REPLACE)
    void insertAll(List<Observacion> observacionList);
    @Update
    void update(Observacion observacion);
    @Delete
    void delete(Observacion observacion);
    @Query("DELETE FROM observaciones")
    void deleteAllObservaciones();
    @Query("SELECT * FROM observaciones ORDER BY obscodigo DESC")
    LiveData<List<Observacion>> getAllObservaciones();
}
