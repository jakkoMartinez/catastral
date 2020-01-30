package com.cesarmartinez.catastral.room.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "levdatosobservaciones",
        indices = {@Index(value = "levobsgencuenta",unique = true),@Index(value = "levobsgenmedidor",unique = true)}
)
public class LevDatosObsGeneral {
    //DATOS MEDIDOR CAMPOS COMUNES
    public String levobsgensector;//SECTOR DE LECTURA
    @SerializedName("levobsgenruta")
    @Expose
    @Nullable
    public String levobsgenruta;//RUTA DE LECTURA
    @PrimaryKey
    @NonNull
    @SerializedName("levobsgencuenta")
    @Expose
    public String levobsgencuenta;//CUENTA DE MEDIDOR
    @SerializedName("levobsgencodcatastral")
    @Expose
    @Nullable
    public String levobsgencodcatastral;//CODIGO CATASTRAL
    @SerializedName("levobsgenmedidor")
    @Expose
    @Nullable
    public String levobsgenmedidor;//NUMERO DE MEDIDOR
    //FIN DATOS MEDIDOR CAMPOS COMUNES
    //OBSERVACIONES
    @SerializedName("levobsgentiempoagua")
    @Expose
    @Nullable
    public String levobsgentiempoagua;// AÑOS DE AGUA
    @SerializedName("levobsgenfrecuencia")
    @Expose
    @Nullable
    public String levobsgenfrecuencia;//DIARIA,SEMANAL
    @SerializedName("levobsgencalidad")
    @Expose
    @Nullable
    public String levobsgencalidad;//BUENA,REGULAR

    @SerializedName("levobsgenvobs")
    @Expose
    @Nullable
    public String levobsgenvobs;//observaciones de levantamiento//
    @SerializedName("levobsgenobsman")
    @Expose
    @Nullable
    public String levobsgenobsman;//observaciones de levantamiento lector//
    //CAMPOS COMUNES NO VISIBLES

    @SerializedName("levobsgenfecha")
    @Expose
    @Nullable
    public String levobsgenfecha;//FECHA DE LEVANTAMIENTO
    @SerializedName("levobsgencoordx")
    @Expose
    @Nullable
    public String levobsgencoordx;//COORDX EQUIPO
    @SerializedName("levobsgencoordy")
    @Expose
    @Nullable
    public String levobsgencoordy;//COORDY EQUIPO
    @SerializedName("levobsgencantdatos")
    @Expose
    @Nullable
    public String levobsgencantdatos;//CANTIDAD DE DATOS
    @SerializedName("levobsgentipo")
    @Expose
    @Nullable
    public String levobsgentipo;//TIPO DE LEVANTAMIENTO
    //FIN DATOS COMUNES NO VISIBLES


    public LevDatosObsGeneral(@Nullable String levobsgenruta, @NonNull String levobsgencuenta, @Nullable String levobsgencodcatastral, @Nullable String levobsgenmedidor, @Nullable String levobsgentiempoagua, @Nullable String levobsgenfrecuencia, @Nullable String levobsgencalidad, @Nullable String levobsgenvobs, @Nullable String levobsgenobsman, @Nullable String levobsgenfecha, @Nullable String levobsgencoordx, @Nullable String levobsgencoordy, @Nullable String levobsgencantdatos, @Nullable String levobsgentipo) {
        this.levobsgenruta = levobsgenruta;
        this.levobsgencuenta = levobsgencuenta;
        this.levobsgencodcatastral = levobsgencodcatastral;
        this.levobsgenmedidor = levobsgenmedidor;
        this.levobsgentiempoagua = levobsgentiempoagua;
        this.levobsgenfrecuencia = levobsgenfrecuencia;
        this.levobsgencalidad = levobsgencalidad;
        this.levobsgenvobs = levobsgenvobs;
        this.levobsgenobsman = levobsgenobsman;
        this.levobsgenfecha = levobsgenfecha;
        this.levobsgencoordx = levobsgencoordx;
        this.levobsgencoordy = levobsgencoordy;
        this.levobsgencantdatos = levobsgencantdatos;
        this.levobsgentipo = levobsgentipo;
    }

    public void setLevobsgencuenta(@NonNull String levobsgencuenta) {
        this.levobsgencuenta = levobsgencuenta;
    }


    @Nullable
    public String getLevobsgenruta() {
        return levobsgenruta;
    }

    @NonNull
    public String getLevobsgencuenta() {
        return levobsgencuenta;
    }

    @Nullable
    public String getLevobsgencodcatastral() {
        return levobsgencodcatastral;
    }

    @Nullable
    public String getLevobsgenmedidor() {
        return levobsgenmedidor;
    }

    @Nullable
    public String getLevobsgentiempoagua() {
        return levobsgentiempoagua;
    }

    @Nullable
    public String getLevobsgenfrecuencia() {
        return levobsgenfrecuencia;
    }

    @Nullable
    public String getLevobsgencalidad() {
        return levobsgencalidad;
    }

    @Nullable
    public String getLevobsgenvobs() {
        return levobsgenvobs;
    }

    @Nullable
    public String getLevobsgenobsman() {
        return levobsgenobsman;
    }

    @Nullable
    public String getLevobsgenfecha() {
        return levobsgenfecha;
    }

    @Nullable
    public String getLevobsgencoordx() {
        return levobsgencoordx;
    }

    @Nullable
    public String getLevobsgencoordy() {
        return levobsgencoordy;
    }

    @Nullable
    public String getLevobsgencantdatos() {
        return levobsgencantdatos;
    }

    @Nullable
    public String getLevobsgentipo() {
        return levobsgentipo;
    }
}
