package com.cesarmartinez.catastral.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.cesarmartinez.catastral.BuildConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.cesarmartinez.catastral.helpers.Directorios.Carpetaimagen;

public class Fotografia {
    Context ctx;
    private String fechafoto;
    private String Fotoname;
    private String state;
    private String  carpetaimagenmediror;
    private Uri photoURI;
    CrearDirectorios crearDirectorios=new CrearDirectorios();
    public Fotografia(Context ctx) {
        this.ctx = ctx;
    }
    Fechas fechas =new Fechas();
    public void EliminarFotogrfia(String Carpeta,String Ruta, String NombreFoto) {

        new File(Carpeta + Ruta + NombreFoto + ".jpg").delete();
    }
    public Uri CargarFotografia(String Carpeta,String Ruta, String NombreFoto) {
        Fotoname=NombreFoto+"_"+fechas.Fecha();
        return Uri.fromFile(new File(Carpeta + Ruta + Fotoname + ".jpg"));
    }
    public  Uri TomarFotografia( String  Carpeta,String Ruta,String NombreFoto){
        crearDirectorios.creardirectorioespecifico(Carpeta+Ruta);
        Fotoname=NombreFoto+"_"+fechas.Fecha()+".jpg";
        state = Environment.getExternalStorageState();
        carpetaimagenmediror= Carpeta+Ruta;
        String carptafoto;
        carptafoto=carpetaimagenmediror+Fotoname;
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            File fotografia = new File(carptafoto);
            try{
                if (fotografia.exists()) {
                    fotografia.delete();
                    fotografia.createNewFile();
                } else {
                    fotografia.createNewFile();
                }
            }catch (IOException ex){
                Toast.makeText(ctx, "Error.."+ex, Toast.LENGTH_SHORT).show();
            }
            try{
                photoURI = FileProvider.getUriForFile(ctx, BuildConfig.APPLICATION_ID + ".provider", fotografia);
            }catch (Exception e){
                Toast.makeText(ctx, "Error.."+e, Toast.LENGTH_SHORT).show();
            }
        }
        return  photoURI;
    }
    private String pahtfotografia( String carpetaimagen,String ruta, String medidor){
        String pathfoto;
        pathfoto=carpetaimagen+ruta+medidor+"_"+fechas.Fecha()+".jpg";
        return pathfoto;
    }
    public  void  stampfotofecha( String carpeta ,String ruta, String medidor, String equipo) {
        String Contratista="G&S GALO GALLO";
        Bitmap src = BitmapFactory.decodeFile(pahtfotografia(carpeta,ruta, medidor));
        Bitmap dest = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(Calendar.getInstance().getTime()); // reading local time in the system
        dateTime = dateTime + "  Equipo: " +equipo + "  Contratista: "+ Contratista;
        Canvas cs = new Canvas(dest);
        Paint tPaint = new Paint();
        tPaint.setTextSize(70);
        tPaint.setColor(Color.YELLOW);
        tPaint.setStyle(Paint.Style.FILL);
        cs.drawBitmap(src, 0f, 0f, null);
        float height = tPaint.measureText("yY");
        cs.drawText(dateTime, 20f, height + 15f, tPaint);
        try {
            dest.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(new File(pahtfotografia(carpeta,ruta, medidor))));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

