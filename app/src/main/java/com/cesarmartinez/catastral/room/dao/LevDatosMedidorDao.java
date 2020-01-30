package com.cesarmartinez.catastral.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cesarmartinez.catastral.room.model.LevDatosMedidor;
import com.cesarmartinez.catastral.room.model.Ruta;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface LevDatosMedidorDao {
    @Insert
    void insert(LevDatosMedidor levDatosMedidor);

    @Insert(onConflict = REPLACE)
    void insertAll(List<LevDatosMedidor> levDatosMedidorList);

    @Update
    void update(LevDatosMedidor levDatosMedidor);

    @Delete
    void delete(LevDatosMedidor levDatosMedidor);

    @Query("DELETE FROM levdatosmedidores")
    void deleteAllLevDatosMedidores();

    @Query("SELECT * FROM levdatosmedidores ORDER BY levdatmedruta DESC")
    LiveData<List<LevDatosMedidor>> getAllLevDatosMedidores();

    @Query("SELECT * FROM levdatosmedidores WHERE levdatmedcuenta=:medidorId")
    LiveData<LevDatosMedidor> getMedidor(String medidorId);

    @Query("SELECT * FROM levdatosmedidores WHERE levdatmedruta=:rutaId")
    LiveData<List<LevDatosMedidor>> getMedidorbyRuta(String rutaId);

    @Query("select " +
            "levdatmedruta as mruta, " +
            "levdatmedsector as sector, " +
            "levdatmedruta as descripcion, " +
            "count(case when levdatmedtipo='M'or levdatmedtipo='ML' then 1 end) as cantidad, " +
            "count(case when levdatmedtipo='M' then 1 end) as faltantes, " +
            "count(case  when levdatmedtipo<>'M' and levdatmedtipo<>'CL' and levdatmedtipo<>'C' then 1 end) as levantados " +
            "from levdatosmedidores " +
            "group by " +
            "levdatmedruta,levdatmedsector")
    LiveData<List<allRutas>> getAllRutas();
    static class allRutas {
        public String mruta;
        public String sector;
        public String descripcion;
        public int cantidad;
        public int faltantes;
        public int levantados;
    }
    /*


     */


}

