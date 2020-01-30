package com.cesarmartinez.catastral.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cesarmartinez.catastral.room.model.LevDatosAcometida;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface LevDatosAcometidaDao {
    @Insert
    void insert(LevDatosAcometida levDatosAcometida);
    @Insert(onConflict = REPLACE)
    void insertAll(List<LevDatosAcometida> levDatosAcometidaList);
    @Update
    void update(LevDatosAcometida levDatosAcometida);
    @Delete
    void delete(LevDatosAcometida levDatosAcometida);
    @Query("DELETE FROM levdatosacometidas")
    void deleteAllLevDatosAcometidas();
    @Query("SELECT * FROM levdatosacometidas ORDER BY levdatacomruta DESC")
    LiveData<List<LevDatosAcometida>> getAllLevDatosAcometidas();
    @Query("SELECT * FROM levdatosacometidas WHERE levdatacomcuenta=:medidorId")
    LiveData<LevDatosAcometida> getMedidor(String medidorId);
}
