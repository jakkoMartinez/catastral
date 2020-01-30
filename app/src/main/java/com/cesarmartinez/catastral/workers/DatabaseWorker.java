package com.cesarmartinez.catastral.workers;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.cesarmartinez.catastral.room.database.DbLevantamiento;
import com.cesarmartinez.catastral.room.model.LevDatosAcometida;
import com.cesarmartinez.catastral.room.model.LevDatosCliente;
import com.cesarmartinez.catastral.room.model.LevDatosMedidor;
import com.cesarmartinez.catastral.room.model.LevDatosObsGeneral;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.List;

public class DatabaseWorker extends Worker {
    public DatabaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            //acometidas
            InputStream inputStreamA = getApplicationContext().getAssets().open("acometidas.json");
            int sizeA = inputStreamA.available();
            byte[] bufferA = new byte[sizeA];
            inputStreamA.read(bufferA);
            inputStreamA.close();
            String jsonA = new String(bufferA, "UTF-8");
            List<LevDatosAcometida> acometidasList = new Gson().fromJson(jsonA, new TypeToken<List<LevDatosAcometida>>() {
            }.getType());
            //clientes
            InputStream inputStreamC = getApplicationContext().getAssets().open("clientes.json");
            int sizeC = inputStreamC.available();
            byte[] bufferC = new byte[sizeC];
            inputStreamC.read(bufferC);
            inputStreamC.close();
            String jsonC = new String(bufferC, "UTF-8");
            List<LevDatosCliente> clientesList = new Gson().fromJson(jsonC, new TypeToken<List<LevDatosCliente>>() {
            }.getType());
            //medidores
            InputStream inputStreamM = getApplicationContext().getAssets().open("medidores.json");
            int sizeM = inputStreamM.available();
            byte[] bufferM = new byte[sizeM];
            inputStreamM.read(bufferM);
            inputStreamM.close();
            String jsonM = new String(bufferM, "UTF-8");
            List<LevDatosMedidor> medidoresList = new Gson().fromJson(jsonM, new TypeToken<List<LevDatosMedidor>>() {
            }.getType());
            //observaciones
            InputStream inputStreamO = getApplicationContext().getAssets().open("observaciones.json");
            int sizeO = inputStreamO.available();
            byte[] bufferO = new byte[sizeO];
            inputStreamO.read(bufferO);
            inputStreamO.close();
            String jsonO = new String(bufferO, "UTF-8");
            List<LevDatosObsGeneral> observacionesList = new Gson().fromJson(jsonO, new TypeToken<List<LevDatosObsGeneral>>() {
            }.getType());

            DbLevantamiento appDatabase = DbLevantamiento.getInstance(getApplicationContext());
            appDatabase.levDatosAcometidaDao().insertAll(acometidasList);
            appDatabase.levDatosClienteDao().insertAll(clientesList);
            appDatabase.levDatosMedidorDao().insertAll(medidoresList);
            appDatabase.levDatosObsGeneralDao().insertAll(observacionesList);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
