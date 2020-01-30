package com.cesarmartinez.catastral.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.model.LevDatosAcometida;
import com.cesarmartinez.catastral.room.repository.LevDatosAcometidaRepository;

import java.util.List;

public class LevDatosAcometidaViewModel extends AndroidViewModel {
    private LevDatosAcometidaRepository repository;
    private LiveData<List<LevDatosAcometida>> allLevDatosAcometidas;

    public LevDatosAcometidaViewModel(@NonNull Application application) {
        super(application);
        repository = new LevDatosAcometidaRepository(application);
        allLevDatosAcometidas = repository.getAllLevDatosAcometidas();
    }
    public void insert(LevDatosAcometida levDatosAcometida) {
        repository.insert(levDatosAcometida);
    }

    public void update(LevDatosAcometida levDatosAcometida) {
        repository.update(levDatosAcometida);
    }

    public void delete(LevDatosAcometida levDatosAcometida) {
        repository.delete(levDatosAcometida);
    }

    public void deleteAllLevDatosAcometidas() {
        repository.deleteAllLevDatosAcometidas();
    }

    public LiveData<List<LevDatosAcometida>> getAllLevDatosAcometidas() {
        return allLevDatosAcometidas;
    }

}
