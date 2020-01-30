package com.cesarmartinez.catastral.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cesarmartinez.catastral.room.model.LevDatosCliente;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface LevDatosClienteDao {
    @Insert
    void insert(LevDatosCliente levDatosCliente);
    @Insert(onConflict = REPLACE)
    void insertAll(List<LevDatosCliente> levDatosClienteList);
    @Update
    void update(LevDatosCliente levDatosCliente);
    @Delete
    void delete(LevDatosCliente levDatosCliente);
    @Query("DELETE FROM levdatosclientes")
    void deleteAllLevDatosClientes();
    @Query("SELECT * FROM levdatosclientes ORDER BY levdatcliruta DESC")
    LiveData<List<LevDatosCliente>> getAllLevDatosClientes();

    @Query("SELECT * FROM levdatosclientes WHERE levdatclicuenta=:medidorId")
    LiveData<LevDatosCliente> getMedidor(String medidorId);
}
