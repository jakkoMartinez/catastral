package com.cesarmartinez.catastral.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.dao.ObservacionDao;
import com.cesarmartinez.catastral.room.database.DbLevantamiento;
import com.cesarmartinez.catastral.room.model.Observacion;

import java.util.List;

public class ObservacionRepository {
    private ObservacionDao observacionDao;
    private LiveData<List<Observacion>> allObservaciones;

    public ObservacionRepository(Application application) {
        DbLevantamiento database = DbLevantamiento.getInstance(application);
        observacionDao = database.observacionDao();
        allObservaciones = observacionDao.getAllObservaciones();
    }

    public void insert(Observacion observacion) { new InsertObservacionAsyncTask(observacionDao).execute(observacion); }

    public void update(Observacion observacion) {
        new UpdateObservacionAsyncTask(observacionDao).execute(observacion);
    }

    public void delete(Observacion observacion) {
        new DeleteObservacionAsyncTask(observacionDao).execute(observacion);
    }

    public void deleteAllObservaciones() {
        new DeleteAllObservacionesAsyncTask(observacionDao).execute();
    }

    public LiveData<List<Observacion>> getAllObservaciones() {
        return allObservaciones;
    }

    private static class InsertObservacionAsyncTask extends AsyncTask<Observacion, Void, Void> {
        private ObservacionDao observacionDao;

        private InsertObservacionAsyncTask(ObservacionDao observacionDao) {
            this.observacionDao = observacionDao;
        }

        @Override
        protected Void doInBackground(Observacion... observaciones) {
            observacionDao.insert(observaciones[0]);
            return null;
        }
    }
    private static class UpdateObservacionAsyncTask extends AsyncTask<Observacion, Void, Void> {
        private ObservacionDao observacionDao;

        private UpdateObservacionAsyncTask(ObservacionDao observacionDao) {
            this.observacionDao = observacionDao;
        }

        @Override
        protected Void doInBackground(Observacion... observaciones) {
            observacionDao.update(observaciones[0]);
            return null;
        }
    }
    private static class DeleteObservacionAsyncTask extends AsyncTask<Observacion, Void, Void> {
        private ObservacionDao observacionDao;

        private DeleteObservacionAsyncTask(ObservacionDao observacionDao) {
            this.observacionDao = observacionDao;
        }

        @Override
        protected Void doInBackground(Observacion... observaciones) {
            observacionDao.delete(observaciones[0]);
            return null;
        }
    }

    private static class DeleteAllObservacionesAsyncTask extends AsyncTask<Void, Void, Void> {
        private ObservacionDao observacionDao;

        private DeleteAllObservacionesAsyncTask(ObservacionDao observacionDao) {
            this.observacionDao = observacionDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            observacionDao.deleteAllObservaciones();
            return null;
        }
    }
}
