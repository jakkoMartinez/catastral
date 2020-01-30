package com.cesarmartinez.catastral.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.dao.RutaDao;
import com.cesarmartinez.catastral.room.database.DbLevantamiento;
import com.cesarmartinez.catastral.room.model.Ruta;

import java.util.List;

public class RutaRepository {

    private RutaDao rutaDao;
    private LiveData<List<Ruta>> allRutas;

    public RutaRepository(Application application) {
        DbLevantamiento database = DbLevantamiento.getInstance(application);
        rutaDao = database.rutaDao();
        allRutas = rutaDao.getAllRutas();
    }

    public void insert(Ruta ruta) { new InsertRutaAsyncTask(rutaDao).execute(ruta); }

    public void update(Ruta ruta) {
        new UpdateRutaAsyncTask(rutaDao).execute(ruta);
    }

    public void delete(Ruta ruta) {
        new DeleteRutaAsyncTask(rutaDao).execute(ruta);
    }

    public void deleteAllRutas() {
        new DeleteAllRutasAsyncTask(rutaDao).execute();
    }

    public LiveData<List<Ruta>> getAllRutas() {
        return allRutas;
    }

    private static class InsertRutaAsyncTask extends AsyncTask<Ruta, Void, Void> {
        private RutaDao rutaDao;

        private InsertRutaAsyncTask(RutaDao rutaDao) {
            this.rutaDao = rutaDao;
        }

        @Override
        protected Void doInBackground(Ruta... rutas) {
            rutaDao.insert(rutas[0]);
            return null;
        }
    }
    private static class UpdateRutaAsyncTask extends AsyncTask<Ruta, Void, Void> {
        private RutaDao rutaDao;

        private UpdateRutaAsyncTask(RutaDao rutaDao) {
            this.rutaDao = rutaDao;
        }

        @Override
        protected Void doInBackground(Ruta... rutas) {
            rutaDao.update(rutas[0]);
            return null;
        }
    }
    private static class DeleteRutaAsyncTask extends AsyncTask<Ruta, Void, Void> {
        private RutaDao rutaDao;

        private DeleteRutaAsyncTask(RutaDao rutaDao) {
            this.rutaDao = rutaDao;
        }

        @Override
        protected Void doInBackground(Ruta... rutas) {
            rutaDao.delete(rutas[0]);
            return null;
        }
    }

    private static class DeleteAllRutasAsyncTask extends AsyncTask<Void, Void, Void> {
        private RutaDao rutaDao;

        private DeleteAllRutasAsyncTask(RutaDao rutaDao) {
            this.rutaDao = rutaDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            rutaDao.deleteAllRutas();
            return null;
        }
    }

}
