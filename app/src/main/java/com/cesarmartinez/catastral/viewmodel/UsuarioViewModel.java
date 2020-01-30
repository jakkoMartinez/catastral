package com.cesarmartinez.catastral.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.model.Usuario;
import com.cesarmartinez.catastral.room.repository.UsuarioRepository;

import java.util.List;


public class UsuarioViewModel extends AndroidViewModel  {
    private UsuarioRepository repository;
    private LiveData<List<Usuario>> allUsuarios;

    public UsuarioViewModel(@NonNull Application application) {
        super(application);
        repository = new UsuarioRepository(application);
        allUsuarios = repository.getAllUsuarios();
    }

    public void insert(Usuario usuario) {
        repository.insert(usuario);
    }

    public void update(Usuario usuario) {
        repository.update(usuario);
    }

    public void delete(Usuario usuario) {
        repository.delete(usuario);
    }

    public void deleteAllUsuarios() {
        repository.deleteAllUsuarios();
    }

    public LiveData<List<Usuario>> getAllUsuarios() {
        return allUsuarios;
    }




}
