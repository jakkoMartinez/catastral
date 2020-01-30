package com.cesarmartinez.catastral.helpers;

import android.os.Environment;

public class Directorios {
    public static String  CarpetaBases= Environment.getExternalStorageDirectory() +"/Catastral/BasesSqlite";
    public static String  Carpetaimagen= Environment.getExternalStorageDirectory() +"/Catastral/Imagenes";
    public static String  Carpetaimagenmedidor= Environment.getExternalStorageDirectory() +"/Catastral/Imagenes/Medidor";
    public static String  Carpetaimagencatastro= Environment.getExternalStorageDirectory() +"/Catastral/Imagenes/Catastro";
    public static String  Carpetaimagenclandestinos= Environment.getExternalStorageDirectory() +"/Catastral/Imagenes/Clandestinos";
    public static String  CarpetaRespaldos= Environment.getExternalStorageDirectory() +"/Catastral/Respaldos";
}
