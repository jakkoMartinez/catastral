package com.cesarmartinez.catastral.room.model;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "observaciones")
public class Observacion {

    @PrimaryKey(autoGenerate = true)
    public int obsid;
    @SerializedName("obscodigo")
    @Expose
    @Nullable
    public String obscodigo;
    @SerializedName("obsdescripcion")
    @Expose
    @Nullable
    public String obsdescripcion;
    @SerializedName("obstipo")
    @Expose
    @Nullable
    public String obstipo;
    @SerializedName("obsrequerida")
    @Expose
    @Nullable
    public String obsrequerida;

    public Observacion(String obscodigo, String obsdescripcion, String obstipo, String obsrequerida) {
        this.obscodigo = obscodigo;
        this.obsdescripcion = obsdescripcion;
        this.obstipo = obstipo;
        this.obsrequerida = obsrequerida;
    }

    public void setObsid(int obsid) {
        this.obsid = obsid;
    }

    public int getObsid() {
        return obsid;
    }

    public String getObscodigo() {
        return obscodigo;
    }

    public String getObsdescripcion() {
        return obsdescripcion;
    }

    public String getObstipo() {
        return obstipo;
    }

    public String getObsrequerida() {
        return obsrequerida;
    }

    @Override
    public String toString() {
        return "Observacion{" +
                "obscodigo='" + obscodigo + '\'' +
                ", obsdescripcion='" + obsdescripcion + '\'' +
                ", obstipo='" + obstipo + '\'' +
                ", obsrequerida='" + obsrequerida + '\'' +
                '}';
    }
}
