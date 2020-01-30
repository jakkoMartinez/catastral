package com.cesarmartinez.catastral.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.model.Observacion;
import com.cesarmartinez.catastral.room.repository.ObservacionRepository;

import java.util.List;

public class ObservacionViewModel extends AndroidViewModel {
    private ObservacionRepository repository;
    private LiveData<List<Observacion>> allObservaciones;
    public ObservacionViewModel(@NonNull Application application) {
        super(application);
        repository = new ObservacionRepository(application);
        allObservaciones = repository.getAllObservaciones();
    }

    public void insert(Observacion observacion) {
        repository.insert(observacion);
    }

    public void update(Observacion observacion) {
        repository.update(observacion);
    }

    public void delete(Observacion observacion) {
        repository.delete(observacion);
    }

    public void deleteAllObservaciones() {
        repository.deleteAllObservaciones();
    }

    public LiveData<List<Observacion>> getAllObservaciones() {
        return allObservaciones;
    }
}
