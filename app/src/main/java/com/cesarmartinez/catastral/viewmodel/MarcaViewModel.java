package com.cesarmartinez.catastral.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.model.Marca;
import com.cesarmartinez.catastral.room.repository.MarcaRepository;

import java.util.List;

public class MarcaViewModel extends AndroidViewModel {
    private MarcaRepository repository;
    private LiveData<List<Marca>> allMarcas;
    public MarcaViewModel(@NonNull Application application) {
        super(application);
        repository = new MarcaRepository(application);
        allMarcas = repository.getAllMarcas();
    }

    public void insert(Marca marca) {
        repository.insert(marca);
    }

    public void update(Marca marca) {
        repository.update(marca);
    }

    public void delete(Marca marca) {
        repository.delete(marca);
    }

    public void deleteAllMarcas() {
        repository.deleteAllMarcas();
    }

    public LiveData<List<Marca>> getAllMarcas() {
        return allMarcas;
    }
}
