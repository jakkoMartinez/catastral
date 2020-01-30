package com.cesarmartinez.catastral.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.dao.LevDatosObsGeneralDao;
import com.cesarmartinez.catastral.room.database.DbLevantamiento;
import com.cesarmartinez.catastral.room.model.LevDatosObsGeneral;

import java.util.List;

public class LevDatosObsGeneralRepository {
    private LevDatosObsGeneralDao levDatosObsGeneralDao;
    private LiveData<List<LevDatosObsGeneral>> allLevObsGenerales;
    public LevDatosObsGeneralRepository(Application application) {
        DbLevantamiento database = DbLevantamiento.getInstance(application);
        levDatosObsGeneralDao = database.levDatosObsGeneralDao();
        allLevObsGenerales = levDatosObsGeneralDao.getAllLevDatosObserGenles();
    }
    public void insert(LevDatosObsGeneral levDatosObsGeneral) {
        new InsertLevDatosObsGeneralAsyncTask(levDatosObsGeneralDao).execute(levDatosObsGeneral);
    }
    public void update(LevDatosObsGeneral levDatosObsGeneral) {
        new UpdateLevDatosObsGeneralAsyncTask(levDatosObsGeneralDao).execute(levDatosObsGeneral);
    }
    public void delete(LevDatosObsGeneral levDatosObsGeneral) {
        new DeleteLevDatosObsGeneralAsyncTask(levDatosObsGeneralDao).execute(levDatosObsGeneral);
    }
    public LiveData<List<LevDatosObsGeneral>> getAllLevObsGenerales() {
        return allLevObsGenerales;
    }
    public void deleteAllLevDatosObsGenerales() {
        new LevDatosObsGeneralRepository.DeleteAllLevDatosObsGeneralAsyncTask(levDatosObsGeneralDao).execute();
    }

    private static class InsertLevDatosObsGeneralAsyncTask extends AsyncTask<LevDatosObsGeneral, Void, Void> {
        private LevDatosObsGeneralDao levDatosObsGeneralDao;

        private InsertLevDatosObsGeneralAsyncTask(LevDatosObsGeneralDao levDatosObsGeneralDao) {
            this.levDatosObsGeneralDao = levDatosObsGeneralDao;
        }

        @Override
        protected Void doInBackground(LevDatosObsGeneral... levDatosObsGenerales) {
            levDatosObsGeneralDao.insert(levDatosObsGenerales[0]);
            return null;
        }
    }
    private static class UpdateLevDatosObsGeneralAsyncTask extends AsyncTask<LevDatosObsGeneral, Void, Void> {
        private LevDatosObsGeneralDao levDatosObsGeneralDao;

        private UpdateLevDatosObsGeneralAsyncTask(LevDatosObsGeneralDao levDatosObsGeneralDao) {
            this.levDatosObsGeneralDao = levDatosObsGeneralDao;
        }

        @Override
        protected Void doInBackground(LevDatosObsGeneral... levDatosObsGenerales) {
            levDatosObsGeneralDao.update(levDatosObsGenerales[0]);
            return null;
        }
    }
    private static class DeleteLevDatosObsGeneralAsyncTask extends AsyncTask<LevDatosObsGeneral, Void, Void> {
        private LevDatosObsGeneralDao levDatosObsGeneralDao;

        private DeleteLevDatosObsGeneralAsyncTask(LevDatosObsGeneralDao levDatosObsGeneralDao) {
            this.levDatosObsGeneralDao = levDatosObsGeneralDao;
        }

        @Override
        protected Void doInBackground(LevDatosObsGeneral... levDatosObsGenerales) {
            levDatosObsGeneralDao.delete(levDatosObsGenerales[0]);
            return null;
        }
    }
    private static class DeleteAllLevDatosObsGeneralAsyncTask extends AsyncTask<Void, Void, Void> {
        private LevDatosObsGeneralDao levDatosObsGeneralDao;

        private DeleteAllLevDatosObsGeneralAsyncTask(LevDatosObsGeneralDao levDatosObsGeneralDao) {
            this.levDatosObsGeneralDao = levDatosObsGeneralDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            levDatosObsGeneralDao.deleteAllLevDatosObserGenles();
            return null;
        }
    }

}
