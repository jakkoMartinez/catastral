package com.cesarmartinez.catastral.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.dao.MarcaDao;
import com.cesarmartinez.catastral.room.database.DbLevantamiento;
import com.cesarmartinez.catastral.room.model.Marca;

import java.util.List;

public class MarcaRepository {
    private MarcaDao marcaDao;
    private LiveData<List<Marca>> allMarcas;
    public MarcaRepository(Application application) {
        DbLevantamiento database = DbLevantamiento.getInstance(application);
        marcaDao = database.marcaDao();
        allMarcas = marcaDao.getAllMarcas();
    }
    public void insert(Marca marca) { new InsertMarcaAsyncTask(marcaDao).execute(marca); }

    public void update(Marca marca) {
        new UpdateMarcaAsyncTask(marcaDao).execute(marca);
    }

    public void delete(Marca marca) {
        new DeleteMarcaAsyncTask(marcaDao).execute(marca);
    }

    public void deleteAllMarcas() {
        new DeleteAllMarcasAsyncTask(marcaDao).execute();
    }

    public LiveData<List<Marca>> getAllMarcas() {
        return allMarcas;
    }

    private static class InsertMarcaAsyncTask extends AsyncTask<Marca, Void, Void> {
        private MarcaDao marcaDao;

        private InsertMarcaAsyncTask(MarcaDao marcaDao) {
            this.marcaDao = marcaDao;
        }

        @Override
        protected Void doInBackground(Marca... marcas) {
            marcaDao.insert(marcas[0]);
            return null;
        }
    }
    private static class UpdateMarcaAsyncTask extends AsyncTask<Marca, Void, Void> {
        private MarcaDao marcaDao;

        private UpdateMarcaAsyncTask(MarcaDao marcaDao) {
            this.marcaDao = marcaDao;
        }

        @Override
        protected Void doInBackground(Marca... marcas) {
            marcaDao.update(marcas[0]);
            return null;
        }
    }
    private static class DeleteMarcaAsyncTask extends AsyncTask<Marca, Void, Void> {
        private MarcaDao marcaDao;

        private DeleteMarcaAsyncTask(MarcaDao marcaDao) {
            this.marcaDao = marcaDao;
        }

        @Override
        protected Void doInBackground(Marca... marcas) {
            marcaDao.delete(marcas[0]);
            return null;
        }
    }
    private static class DeleteAllMarcasAsyncTask extends AsyncTask<Void, Void, Void> {
        private MarcaDao marcaDao;

        private DeleteAllMarcasAsyncTask(MarcaDao marcaDao) {
            this.marcaDao = marcaDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            marcaDao.deleteAllMarcas();
            return null;
        }
    }
}
