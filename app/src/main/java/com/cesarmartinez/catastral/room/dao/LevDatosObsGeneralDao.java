package com.cesarmartinez.catastral.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cesarmartinez.catastral.room.model.LevDatosObsGeneral;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface LevDatosObsGeneralDao {
    @Insert
    void insert(LevDatosObsGeneral levDatosObsGeneral);
    @Insert(onConflict = REPLACE)
    void insertAll(List<LevDatosObsGeneral> levDatosObsGeneralList);
    @Update
    void update(LevDatosObsGeneral levDatosObsGeneral);
    @Delete
    void delete(LevDatosObsGeneral levDatosObsGeneral);
    @Query("DELETE FROM levdatosobservaciones")
    void deleteAllLevDatosObserGenles();
    @Query("SELECT * FROM levdatosobservaciones ORDER BY levobsgenruta DESC")
    LiveData<List<LevDatosObsGeneral>> getAllLevDatosObserGenles();
    @Query("SELECT * FROM levdatosobservaciones WHERE levobsgencuenta=:medidorId")
    LiveData<LevDatosObsGeneral> getObsMedidor(String medidorId);
}
