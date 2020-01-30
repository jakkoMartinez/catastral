package com.cesarmartinez.catastral.room.model;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "marcas")
public class Marca {
    @PrimaryKey(autoGenerate = true)
    public  int marcaid;
    @SerializedName("marcacodigo")
    @Expose
    @Nullable
    public  String marcacodigo;
    @SerializedName("marcadescripcion")
    @Expose
    @Nullable
    public  String marcadescripcion;
    @SerializedName("marcatipo")
    @Expose
    @Nullable
    public String marcatipo;
    @SerializedName("marcaesfera")
    @Expose
    @Nullable
    public String marcaesfera;

    public Marca(String marcacodigo, String marcadescripcion, String marcatipo, String marcaesfera) {
        this.marcacodigo = marcacodigo;
        this.marcadescripcion = marcadescripcion;
        this.marcatipo = marcatipo;
        this.marcaesfera = marcaesfera;
    }

    public void setMarcaid(int marcaid) {
        this.marcaid = marcaid;
    }

    public int getMarcaid() {
        return marcaid;
    }

    public String getMarcacodigo() {
        return marcacodigo;
    }

    public String getMarcadescripcion() {
        return marcadescripcion;
    }

    public String getMarcatipo() {
        return marcatipo;
    }

    public String getMarcaesfera() {
        return marcaesfera;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "marcacodigo='" + marcacodigo + '\'' +
                ", marcadescripcion='" + marcadescripcion + '\'' +
                ", marcatipo='" + marcatipo + '\'' +
                ", marcaesfera='" + marcaesfera + '\'' +
                '}';
    }
}
