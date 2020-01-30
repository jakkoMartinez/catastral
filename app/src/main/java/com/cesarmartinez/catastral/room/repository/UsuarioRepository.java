package com.cesarmartinez.catastral.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import com.cesarmartinez.catastral.room.dao.UsuarioDao;
import com.cesarmartinez.catastral.room.database.DbLevantamiento;
import com.cesarmartinez.catastral.room.model.Usuario;

import java.util.List;

public class UsuarioRepository {
    private UsuarioDao usuarioDao;
    private LiveData<List<Usuario>> allUsuarios;
    private LiveData<List<Usuario>> byCedUsuarios;

    public UsuarioRepository(Application application) {
        DbLevantamiento database = DbLevantamiento.getInstance(application);
        usuarioDao = database.usuarioDao();
        allUsuarios = usuarioDao.getAllUsuarios();

    }
    public void insert(Usuario usuario) { new InsertUsuarioAsyncTask(usuarioDao).execute(usuario); }
    public void update(Usuario usuario) { new UpdateUsuarioAsyncTask(usuarioDao).execute(usuario); }
    public void delete(Usuario usuario) { new DeleteUsuarioAsyncTask(usuarioDao).execute(usuario); }
    public void deleteAllUsuarios() { new DeleteAllUsuariosAsyncTask(usuarioDao).execute(); }

    public LiveData<Usuario>getUsuariobycedula (String cedulauser) {
        return usuarioDao.getUsuariobycedula(cedulauser);
    }
    public LiveData<List<Usuario>> getAllUsuarios() {
        return allUsuarios;
    }


    private static class InsertUsuarioAsyncTask extends AsyncTask<Usuario, Void, Void> {
        private UsuarioDao usuarioDao;

        private InsertUsuarioAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Usuario... usuarios) {
            usuarioDao.insert(usuarios[0]);
            return null;
        }
    }

    private static class UpdateUsuarioAsyncTask extends AsyncTask<Usuario, Void, Void> {
        private UsuarioDao usuarioDao;

        private UpdateUsuarioAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Usuario... usuarios) {
            usuarioDao.update(usuarios[0]);
            return null;
        }
    }

    private static class DeleteUsuarioAsyncTask extends AsyncTask<Usuario, Void, Void> {
        private UsuarioDao usuarioDao;

        private DeleteUsuarioAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Usuario... usuarios) {
            usuarioDao.delete(usuarios[0]);
            return null;
        }
    }

    private static class DeleteAllUsuariosAsyncTask extends AsyncTask<Void, Void, Void> {
        private UsuarioDao usuarioDao;

        private DeleteAllUsuariosAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            usuarioDao.deleteAllUsuarios();
            return null;
        }
    }
}
