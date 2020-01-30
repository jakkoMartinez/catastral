package com.cesarmartinez.catastral.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.model.Ruta;
import com.cesarmartinez.catastral.room.repository.RutaRepository;

import java.util.List;

public class RutaViewModel extends AndroidViewModel {
    private RutaRepository repository;
    private LiveData<List<Ruta>> allRutas;
    public RutaViewModel(@NonNull Application application) {
        super(application);
        repository = new RutaRepository(application);
        allRutas = repository.getAllRutas();
    }

    public void insert(Ruta ruta) {
        repository.insert(ruta);
    }

    public void update(Ruta ruta) {
        repository.update(ruta);
    }

    public void delete(Ruta ruta) {
        repository.delete(ruta);
    }

    public void deleteAllRutas() {
        repository.deleteAllRutas();
    }

    public LiveData<List<Ruta>> getAllRutas() {
        return allRutas;
    }
}
