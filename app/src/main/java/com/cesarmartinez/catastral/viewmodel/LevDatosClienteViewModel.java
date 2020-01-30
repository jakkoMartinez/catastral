package com.cesarmartinez.catastral.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.model.LevDatosCliente;
import com.cesarmartinez.catastral.room.repository.LevDatosClienteRepository;

import java.util.List;

public class LevDatosClienteViewModel extends AndroidViewModel {
    private LevDatosClienteRepository repository;
    private LiveData<List<LevDatosCliente>> allLevDatosClientes;

    public LevDatosClienteViewModel(@NonNull Application application) {
        super(application);
        repository = new LevDatosClienteRepository(application);
        allLevDatosClientes = repository.getAllLevDatosClientes();
    }
    public void insert(LevDatosCliente levDatosCliente) {
        repository.insert(levDatosCliente);
    }

    public void update(LevDatosCliente levDatosCliente) {
        repository.update(levDatosCliente);
    }

    public void delete(LevDatosCliente levDatosCliente) {
        repository.delete(levDatosCliente);
    }

    public void deleteAllLevDatosClientes() {
        repository.deleteAllLevDatosClientes();
    }

    public LiveData<List<LevDatosCliente>> getAllLevDatosClientes() {
        return allLevDatosClientes;
    }
}
