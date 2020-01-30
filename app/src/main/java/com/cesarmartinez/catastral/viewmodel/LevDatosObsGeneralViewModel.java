package com.cesarmartinez.catastral.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.model.LevDatosObsGeneral;
import com.cesarmartinez.catastral.room.repository.LevDatosObsGeneralRepository;

import java.util.List;

public class LevDatosObsGeneralViewModel extends AndroidViewModel {
    private LevDatosObsGeneralRepository repository;
    private LiveData<List<LevDatosObsGeneral>> allLevDatosObsGenerales;

    public LevDatosObsGeneralViewModel(@NonNull Application application) {
        super(application);
        repository = new LevDatosObsGeneralRepository(application);
        allLevDatosObsGenerales = repository.getAllLevObsGenerales();
    }
    public void insert(LevDatosObsGeneral levDatosObsGeneral) {
        repository.insert(levDatosObsGeneral);
    }

    public void update(LevDatosObsGeneral levDatosObsGeneral) {
        repository.update(levDatosObsGeneral);
    }

    public void delete(LevDatosObsGeneral levDatosObsGeneral) {
        repository.delete(levDatosObsGeneral);
    }

    public void deleteAllLevDatosObsGenerales() {
        repository.deleteAllLevDatosObsGenerales();
    }

    public LiveData<List<LevDatosObsGeneral>> getAllLevDatosObsGenerales() {
        return getAllLevDatosObsGenerales();
    }
}
