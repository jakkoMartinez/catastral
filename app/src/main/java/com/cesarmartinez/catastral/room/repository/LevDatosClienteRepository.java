package com.cesarmartinez.catastral.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.dao.LevDatosClienteDao;
import com.cesarmartinez.catastral.room.database.DbLevantamiento;
import com.cesarmartinez.catastral.room.model.LevDatosCliente;

import java.util.List;

public class LevDatosClienteRepository {
    private LevDatosClienteDao levDatosClienteDao;
    private LiveData<List<LevDatosCliente>> allLevDatosClientes;
    public LevDatosClienteRepository(Application application) {
        DbLevantamiento database = DbLevantamiento.getInstance(application);
        levDatosClienteDao = database.levDatosClienteDao();
        allLevDatosClientes = levDatosClienteDao.getAllLevDatosClientes();
    }
    public void insert(LevDatosCliente levDatosCliente) {
        new InsertLevDatosClienteAsyncTask(levDatosClienteDao).execute(levDatosCliente);
    }
    public void update(LevDatosCliente levDatosCliente) {
        new UpdateLevDatosClienteAsyncTask(levDatosClienteDao).execute(levDatosCliente);
    }
    public void delete(LevDatosCliente levDatosCliente) {
        new DeleteLevDatosClienteAsyncTask(levDatosClienteDao).execute(levDatosCliente);
    }
    public void deleteAllLevDatosClientes() {
        new LevDatosClienteRepository.DeleteAllLevDatosClienteAsyncTask(levDatosClienteDao).execute();
    }

    public LiveData<List<LevDatosCliente>> getAllLevDatosClientes() {
        return allLevDatosClientes;
    }

    private static class InsertLevDatosClienteAsyncTask extends AsyncTask<LevDatosCliente, Void, Void> {
        private LevDatosClienteDao levDatosClienteDao;

        private InsertLevDatosClienteAsyncTask(LevDatosClienteDao levDatosClienteDao) {
            this.levDatosClienteDao = levDatosClienteDao;
        }

        @Override
        protected Void doInBackground(LevDatosCliente... levDatosClientes) {
            levDatosClienteDao.insert(levDatosClientes[0]);
            return null;
        }
    }

    private static class UpdateLevDatosClienteAsyncTask extends AsyncTask<LevDatosCliente, Void, Void> {
        private LevDatosClienteDao levDatosClienteDao;

        private UpdateLevDatosClienteAsyncTask(LevDatosClienteDao levDatosClienteDao) {
            this.levDatosClienteDao = levDatosClienteDao;
        }

        @Override
        protected Void doInBackground(LevDatosCliente... levDatosClientes) {
            levDatosClienteDao.update(levDatosClientes[0]);
            return null;
        }
    }

    private static class DeleteLevDatosClienteAsyncTask extends AsyncTask<LevDatosCliente, Void, Void> {
        private LevDatosClienteDao levDatosClienteDao;

        private DeleteLevDatosClienteAsyncTask(LevDatosClienteDao levDatosClienteDao) {
            this.levDatosClienteDao = levDatosClienteDao;
        }

        @Override
        protected Void doInBackground(LevDatosCliente... levDatosClientes) {
            levDatosClienteDao.delete(levDatosClientes[0]);
            return null;
        }
    }

    private static class DeleteAllLevDatosClienteAsyncTask extends AsyncTask<Void, Void, Void> {
        private LevDatosClienteDao levDatosClienteDao;

        private DeleteAllLevDatosClienteAsyncTask(LevDatosClienteDao levDatosClienteDao) {
            this.levDatosClienteDao = levDatosClienteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            levDatosClienteDao.deleteAllLevDatosClientes();
            return null;
        }
    }
}
