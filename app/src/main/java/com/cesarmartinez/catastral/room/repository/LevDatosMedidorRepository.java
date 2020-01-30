package com.cesarmartinez.catastral.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.cesarmartinez.catastral.room.dao.LevDatosMedidorDao;
import com.cesarmartinez.catastral.room.database.DbLevantamiento;
import com.cesarmartinez.catastral.room.model.LevDatosMedidor;

import java.util.List;

public class LevDatosMedidorRepository {
    private LevDatosMedidorDao levDatosMedidorDao;
    private LiveData<List<LevDatosMedidor>> allLevDatosMedidores;
    private LiveData<List<LevDatosMedidorDao.allRutas>> allMisRutas;
    private LiveData<List<LevDatosMedidor>> allLevDatosMedidoresbyruta;
    public LevDatosMedidorRepository(Application application) {
        DbLevantamiento database = DbLevantamiento.getInstance(application);
        levDatosMedidorDao = database.levDatosMedidorDao();
        allLevDatosMedidores = levDatosMedidorDao.getAllLevDatosMedidores();
        allMisRutas = levDatosMedidorDao.getAllRutas();
    }
    public LiveData<LevDatosMedidor> getMedidorbyId(String id) {
        return levDatosMedidorDao.getMedidor(id);
    }
    public LiveData<List<LevDatosMedidor>> getAllLevDatosMedidoresbyruta(String rutaID) {
        return levDatosMedidorDao.getMedidorbyRuta(rutaID);
    }

    public void insert(LevDatosMedidor levDatosMedidor) {
        new InsertLevDatosMedidorAsyncTask(levDatosMedidorDao).execute(levDatosMedidor);
    }
    public void update(LevDatosMedidor levDatosMedidor) {
        new UpdateLevDatosMedidorAsyncTask(levDatosMedidorDao).execute(levDatosMedidor);
    }
    public void delete(LevDatosMedidor levDatosMedidor) {
        new DeleteLevDatosMedidorAsyncTask(levDatosMedidorDao).execute(levDatosMedidor);
    }

    public LiveData<List<LevDatosMedidor>> getAllLevDatosMedidores() {
        return allLevDatosMedidores;
    }
    public LiveData<List<LevDatosMedidorDao.allRutas>> getAllRutas() {
        return allMisRutas;
    }
    public void deleteAllLevDatosMedidores() {
        new LevDatosMedidorRepository.DeleteAllLevDatosMedidorAsyncTask(levDatosMedidorDao).execute();
    }

    private static class InsertLevDatosMedidorAsyncTask extends AsyncTask<LevDatosMedidor, Void, Void> {
        private LevDatosMedidorDao levDatosMedidorDao;

        private InsertLevDatosMedidorAsyncTask(LevDatosMedidorDao levDatosMedidorDao) {
            this.levDatosMedidorDao = levDatosMedidorDao;
        }

        @Override
        protected Void doInBackground(LevDatosMedidor... levDatosMedidores) {
            levDatosMedidorDao.insert(levDatosMedidores[0]);
            return null;
        }
    }
    private static class UpdateLevDatosMedidorAsyncTask extends AsyncTask<LevDatosMedidor, Void, Void> {
        private LevDatosMedidorDao levDatosMedidorDao;

        private UpdateLevDatosMedidorAsyncTask(LevDatosMedidorDao levDatosMedidorDao) {
            this.levDatosMedidorDao = levDatosMedidorDao;
        }

        @Override
        protected Void doInBackground(LevDatosMedidor... levDatosMedidores) {
            levDatosMedidorDao.update(levDatosMedidores[0]);
            return null;
        }
    }
    private static class DeleteLevDatosMedidorAsyncTask extends AsyncTask<LevDatosMedidor, Void, Void> {
        private LevDatosMedidorDao levDatosMedidorDao;

        private DeleteLevDatosMedidorAsyncTask(LevDatosMedidorDao levDatosMedidorDao) {
            this.levDatosMedidorDao = levDatosMedidorDao;
        }

        @Override
        protected Void doInBackground(LevDatosMedidor... levDatosMedidores) {
            levDatosMedidorDao.delete(levDatosMedidores[0]);
            return null;
        }
    }
    private static class DeleteAllLevDatosMedidorAsyncTask extends AsyncTask<Void, Void, Void> {
        private LevDatosMedidorDao levDatosMedidorDao;

        private DeleteAllLevDatosMedidorAsyncTask(LevDatosMedidorDao levDatosMedidorDao) {
            this.levDatosMedidorDao = levDatosMedidorDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            levDatosMedidorDao.deleteAllLevDatosMedidores();
            return null;
        }
    }

}
