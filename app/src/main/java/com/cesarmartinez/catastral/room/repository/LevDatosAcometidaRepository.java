package com.cesarmartinez.catastral.room.repository;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.dao.LevDatosAcometidaDao;
import com.cesarmartinez.catastral.room.database.DbLevantamiento;
import com.cesarmartinez.catastral.room.model.LevDatosAcometida;

import java.util.List;

public class LevDatosAcometidaRepository {
    private LevDatosAcometidaDao levDatosAcometidaDao;
    private LiveData<List<LevDatosAcometida>> allLevDatosAcometidas;
    public LevDatosAcometidaRepository(Application application) {
        DbLevantamiento database = DbLevantamiento.getInstance(application);
        levDatosAcometidaDao = database.levDatosAcometidaDao();
        allLevDatosAcometidas = levDatosAcometidaDao.getAllLevDatosAcometidas();
    }
    public void insert(LevDatosAcometida levDatosAcometida) {
        new InsertLevDatosAcometidaAsyncTask(levDatosAcometidaDao).execute(levDatosAcometida);
    }
    public void update(LevDatosAcometida levDatosAcometida) {
        new UpdateLevDatosAcometidaAsyncTask(levDatosAcometidaDao).execute(levDatosAcometida);
    }
    public void delete(LevDatosAcometida levDatosAcometida) {
        new DeleteLevDatosAcometidaAsyncTask(levDatosAcometidaDao).execute(levDatosAcometida);
    }

    public void deleteAllLevDatosAcometidas() {
        new LevDatosAcometidaRepository.DeleteAllLevDatosAcometidaAsyncTask(levDatosAcometidaDao).execute();
    }


    public LiveData<List<LevDatosAcometida>> getAllLevDatosAcometidas() {
        return allLevDatosAcometidas;
    }

    private static class InsertLevDatosAcometidaAsyncTask extends AsyncTask<LevDatosAcometida, Void, Void> {
        private LevDatosAcometidaDao levDatosAcometidaDao;

        private InsertLevDatosAcometidaAsyncTask(LevDatosAcometidaDao levDatosAcometidaDao) {
            this.levDatosAcometidaDao = levDatosAcometidaDao;
        }

        @Override
        protected Void doInBackground(LevDatosAcometida... levDatosAcometidas) {
            levDatosAcometidaDao.insert(levDatosAcometidas[0]);
            return null;
        }
    }

    private static class UpdateLevDatosAcometidaAsyncTask extends AsyncTask<LevDatosAcometida, Void, Void> {
        private LevDatosAcometidaDao levDatosAcometidaDao;

        private UpdateLevDatosAcometidaAsyncTask(LevDatosAcometidaDao levDatosAcometidaDao) {
            this.levDatosAcometidaDao = levDatosAcometidaDao;
        }

        @Override
        protected Void doInBackground(LevDatosAcometida... levDatosAcometidas) {
            levDatosAcometidaDao.update(levDatosAcometidas[0]);
            return null;
        }
    }
    private static class DeleteLevDatosAcometidaAsyncTask extends AsyncTask<LevDatosAcometida, Void, Void> {
        private LevDatosAcometidaDao levDatosAcometidaDao;

        private DeleteLevDatosAcometidaAsyncTask(LevDatosAcometidaDao levDatosAcometidaDao) {
            this.levDatosAcometidaDao = levDatosAcometidaDao;
        }

        @Override
        protected Void doInBackground(LevDatosAcometida... levDatosAcometidas) {
            levDatosAcometidaDao.delete(levDatosAcometidas[0]);
            return null;
        }
    }


    private static class DeleteAllLevDatosAcometidaAsyncTask extends AsyncTask<Void, Void, Void> {
        private LevDatosAcometidaDao levDatosAcometidaDao;

        private DeleteAllLevDatosAcometidaAsyncTask(LevDatosAcometidaDao levDatosAcometidaDao) {
            this.levDatosAcometidaDao = levDatosAcometidaDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            levDatosAcometidaDao.deleteAllLevDatosAcometidas();
            return null;
        }
    }

}