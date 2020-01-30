package com.cesarmartinez.catastral.room.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "rutas")
public class Ruta {

   @PrimaryKey(autoGenerate = true)
    public int rutid;
    public String rutsector;//SECTOR DE LECTURA
    public String rutruta;//RUTA DE LECTURA
    public String rutdescripcion;//DESCRIPCION DE RUTA//parroquia
    public int rutacantidad;//CANTIDAD
    public int rutfaltantes;//FALTANTES
    public int rutlevantados;//LEVANTADOS
  public Ruta(String rutsector, String rutruta, String rutdescripcion, int rutacantidad, int rutfaltantes, int rutlevantados) {
        this.rutsector = rutsector;
        this.rutruta = rutruta;
        this.rutdescripcion = rutdescripcion;
        this.rutacantidad = rutacantidad;
        this.rutfaltantes = rutfaltantes;
        this.rutlevantados = rutlevantados;
    }

    public void setRutid(int rutid) {
        this.rutid = rutid;
    }

    public int getRutid() {
        return rutid;
    }

    public String getRutsector() {
        return rutsector;
    }

    public String getRutruta() {
        return rutruta;
    }

    public String getRutdescripcion() {
        return rutdescripcion;
    }

    public int getRutacantidad() {
        return rutacantidad;
    }

    public int getRutfaltantes() {
        return rutfaltantes;
    }

    public int getRutlevantados() {
        return rutlevantados;
    }
}
