package com.cesarmartinez.catastral.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.dao.LevDatosMedidorDao;
import com.cesarmartinez.catastral.room.model.LevDatosMedidor;
import com.cesarmartinez.catastral.room.repository.LevDatosMedidorRepository;

import java.util.List;

public class LevDatosMedidorViewModel extends AndroidViewModel {
    private LevDatosMedidorRepository repository;
    //private String rutaid,cuentaid;
    private LiveData<List<LevDatosMedidor>> allLevDatosMedidores;
    private LiveData<List<LevDatosMedidorDao.allRutas>> AllMRutas;

    public LevDatosMedidorViewModel(@NonNull Application application) {
        super(application);
        repository = new LevDatosMedidorRepository(application);
        allLevDatosMedidores = repository.getAllLevDatosMedidores();
        AllMRutas = repository.getAllRutas();
    }
    public void insert(LevDatosMedidor levDatosMedidor) {
        repository.insert(levDatosMedidor);
    }

    public void update(LevDatosMedidor levDatosMedidor) {
        repository.update(levDatosMedidor);
    }

    public void delete(LevDatosMedidor levDatosMedidor) {
        repository.delete(levDatosMedidor);
    }

    public void deleteAllLevDatosMedidores() {
        repository.deleteAllLevDatosMedidores();
    }

    public LiveData<List<LevDatosMedidor>> getAllLevDatosMedidores() {
        return allLevDatosMedidores;
    }
    public LiveData<List<LevDatosMedidorDao.allRutas>> getAllMRutas() {
        return AllMRutas;
    }
    public LiveData<List<LevDatosMedidorDao.allRutas>> getAllMisRutas() {
        return AllMRutas;
    }
    public LiveData<List<LevDatosMedidor>> getLevDatosMedidoresbyRuta(String rutaid) {
        return repository.getAllLevDatosMedidoresbyruta(rutaid);
    }

}
