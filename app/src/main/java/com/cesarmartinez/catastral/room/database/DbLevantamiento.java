package com.cesarmartinez.catastral.room.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.cesarmartinez.catastral.room.dao.*;
import com.cesarmartinez.catastral.room.model.*;
import com.cesarmartinez.catastral.workers.DatabaseWorker;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {LevDatosAcometida.class, LevDatosCliente.class, LevDatosMedidor.class, LevDatosObsGeneral.class, Marca.class, Observacion.class, Ruta.class, Usuario.class}
, version = 1 ,exportSchema = false
)

public abstract class DbLevantamiento extends RoomDatabase {
    private static DbLevantamiento instance;

    public abstract LevDatosAcometidaDao levDatosAcometidaDao();
    public abstract LevDatosClienteDao levDatosClienteDao();
    public abstract LevDatosMedidorDao levDatosMedidorDao();
    public abstract LevDatosObsGeneralDao levDatosObsGeneralDao();
    public abstract MarcaDao marcaDao();
    public abstract ObservacionDao observacionDao();
    public abstract RutaDao rutaDao();
    public abstract UsuarioDao usuarioDao();

    public static DbLevantamiento getInstance(Context context) {
        if (instance == null) {
            synchronized (DbLevantamiento.class) {
                if (instance == null)
                    instance = buildDatabase(context);
            }
        }
        return instance;
    }

    private static DbLevantamiento buildDatabase(Context context) {
        return Room.databaseBuilder(context, DbLevantamiento.class, "DBlevantamiento")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(DatabaseWorker.class).build();
                        WorkManager.getInstance().enqueue(workRequest);
                    }
                }).build();
    }
    public static void destroyDatabase() {
        instance = null;
    }



}
/*
    public static synchronized DbLevantamiento getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DbLevantamiento.class, "DbLevantamiento")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private RutaDao rutaDao;
        private UsuarioDao usuarioDao;
        private LevDatosAcometidaDao levDatosAcometidaDao;
        private LevDatosClienteDao levDatosClienteDao;
        private LevDatosMedidorDao levDatosMedidorDao;
        private LevDatosObsGeneralDao levDatosObsGeneralDao;
        private ObservacionDao observacionDao;

        private PopulateDbAsyncTask(DbLevantamiento db) {
            //rutaDao = db.rutaDao();
            //usuarioDao = db.usuarioDao();
            levDatosMedidorDao=db.levDatosMedidorDao();
            observacionDao=db.observacionDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            //usuarioDao.insert(new Usuario("JULIO CESAR","VELOZ MARTINEZ","1721583092","cesar1_999@hotmail.com","contraseña","1","COT_JCVM_001"));
            observacionDao.insert(new Observacion("LT_001", "OK", "NO HAY INCONVENIENTE", "0"));
            observacionDao.insert(new Observacion("LT_002", "CASA CERRADA", "CASA CERRADA DEJAR NOTIF", "1"));
            observacionDao.insert(new Observacion("LT_003", "COORDENADAS A VERIFICAR", "COORDENADAS NO CORRESPONDE", "0"));
            observacionDao.insert(new Observacion("LT_004", "USUARIO FALLECIDO,", "USUARIO FALLECIDO DEJAR NOTIF", "1"));
            observacionDao.insert(new Observacion("LT_005", "USUARIO NO COLABORA", "USUARIO NO COLABORA DEJAR NOTIF", "1"));

            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "RURAL POALO", "RE-00600", "99_9990"
                    , "0501010205077015", "7777770"
                    , "1110", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.060334282", "-78.58133673"
                    , "", ""
            ));
            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "110", "99_9991"
                    , "0501010205077015", "7777771"
                    , "1111", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.064457894", "-78.58689859"
                    , "", ""
            ));
            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "110", "99_9992"
                    , "0501010205077015", "7777772"
                    , "1104", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.062852328", "-78.57982909"
                    , "", ""
            ));
            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "112", "99_9993"
                    , "0501010205077015", "7777773"
                    , "1144", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.059008445", "-78.58204116"
                    , "", ""
            ));
            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "112", "99_9994"
                    , "0501010205077015", "7777774"
                    , "1434", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.065342239", "-78.58153395"
                    , "", ""
            ));

            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "112", "99_9995"
                    , "0501010205077015", "7777775"
                    , "1444", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.05570962", "-78.58061707"
                    , "", ""
            ));
            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "112", "99_9996"
                    , "0501010205077015", "7777776"
                    , "1424", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.056484019", "-78.58053094"
                    , "", ""
            ));
            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "112", "99_9997"
                    , "0501010205077015", "7777777"
                    , "1425", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.055877087", "-78.58224132"
                    , "", ""
            ));
            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "112", "99_9998"
                    , "0501010205077015", "7777778"
                    , "3425", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.066649704", "-78.58413098"
                    , "", ""
            ));
            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "112", "99_9999"
                    , "0501010205077015", "7777779"
                    , "100", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.085429999", "-78.62051928"
                    , "", ""
            ));
            levDatosMedidorDao.insert(new LevDatosMedidor(
                    "01", "112", "99_9910"
                    , "0501010205077015", "7777710"
                    , "10", "HGS", "5"
                    , "1234", "3/4", ""
                    , "", "", "", ""
                    , "", "", "-1.051777037", "-78.56874107"
                    , "", ""
            ));
            /*
            List<Ruta>milista;
            milista = levDatosMedidorDao.getAllRutas();
            try {
                rutaDao.insertAll(milista);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            //return null;
            //List<LevDatosMedidorDao.allRutas> milista;



                //imprimimos el objeto pivote
                //System.out.println(milista);


            /*
            try {}
            catch ( Exception e){
            }
            rutaDao.insert(new Ruta("01", "110", "LA MATRIZ",280,45,12));
            rutaDao.insert(new Ruta("01", "120", "LA MATRIZ",200,5,10));
            rutaDao.insert(new Ruta("01", "130", "LA MATRIZ",180,2,2));

            */

        //}
    //}




