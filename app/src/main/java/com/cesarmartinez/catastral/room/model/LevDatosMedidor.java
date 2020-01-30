package com.cesarmartinez.catastral.room.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "levdatosmedidores",
        indices = {@Index(value = "levdatmedcuenta",unique = true),@Index(value = "levdatmedmedidor",unique = true)}
)
public class LevDatosMedidor {
    //DATOS MEDIDOR CAMPOS COMUNES
    @SerializedName("levdatmedsector")
    @Expose
    @Nullable
    public String levdatmedsector;//SECTOR DE LECTURA
    @SerializedName("levdatmedruta")
    @Expose
    @Nullable
    public String levdatmedruta;//RUTA DE LECTURA
    @PrimaryKey
    @NonNull
    @SerializedName("levdatmedcuenta")
    @Expose
    public String levdatmedcuenta;//CUENTA DE MEDIDOR
    @SerializedName("levdatmedcodcatastral")
    @Expose
    @Nullable
    public String levdatmedcodcatastral;//CODIGO CATASTRAL
    @SerializedName("levdatmedmedidor")
    @Expose
    @Nullable
    public String levdatmedmedidor;//NUMERO DE MEDIDOR
    //FIN DATOS MEDIDOR CAMPOS COMUNES
    @SerializedName("levdatmedsecuencia")
    @Expose
    @Nullable
    public String levdatmedsecuencia;//SECUENCIA DE LECTURA

    @SerializedName("levdatmedmarca")
    @Expose
    @Nullable
    public String levdatmedmarca;//MARCA DE MEDIDOR
    @SerializedName("levdatmeddigito")
    @Expose
    @Nullable
    public String levdatmeddigito;//NUMERO DE DIGITOS
    @SerializedName("levdatmedlectura")
    @Expose
    @Nullable
    public String levdatmedlectura;//LECTURA DE LEVANTAMIENTO
    @SerializedName("levdatmeddiametro")
    @Expose
    @Nullable
    public String levdatmeddiametro;//DIAMETRO (1/2, 3/4,1")
    @SerializedName("levdatmedmaterial")
    @Expose
    @Nullable
    public String levdatmedmaterial;//METALICO,PLASTICO
    @SerializedName("levdatmedestcupula")
    @Expose
    @Nullable
    public String levdatmedestcupula;//OPTIMO,DESGASTE,SIN CUPULA
    @SerializedName("levdatmedobservmed")
    @Expose
    @Nullable
    public String levobservmed;//FRENADO,ILEGIBLE,DESTRUIDO,EMPAÑADO,INVERTIDO,BUEN ESTADO
    @SerializedName("levdatmedobsmanual")
    @Expose
    @Nullable
    public String levdatmedobsmanual;//EL LECTOR ESCRIBE UNA NOVEDA
    //CAMPOS COMUNES NO VISIBLES
    @SerializedName("levdatmedfoto")
    @Expose
    @Nullable
    public String levdatmedfoto;//COD=TIPLEV_M_CUENTA_MEDNUMERO_FECHA//FOTO MEDIDOR
    @SerializedName("levdatmedpfoto")
    @Expose
    @Nullable
    public String levdatmedpfoto;//COD=TIPLEV_A_CUENTA_MEDNUMERO_FECHA//FOTO ACOMETIDA
    @SerializedName("levdatmedfecha")
    @Expose
    @Nullable
    public String levdatmedfecha;//FECHA DE LEVANTAMIENTO
    @SerializedName("levdatmedcoordx")
    @Expose
    @Nullable
    public String levdatmedcoordx;//COORDX EQUIPO
    @SerializedName("levdatmedcoordy")
    @Expose
    @Nullable
    public String levdatmedcoordy;//COORDY EQUIPO
    @SerializedName("levdatmedcantdatos")
    @Expose
    @Nullable
    public String levdatmedcantdatos;//CANTIDAD DE DATOS
    @SerializedName("levdatmedtipo")
    @Expose
    @Nullable
    public String levdatmedtipo;//TIPO DE LEVANTAMIENTO

    public LevDatosMedidor(@Nullable String levdatmedsector, @Nullable String levdatmedruta , @NonNull String levdatmedcuenta, @Nullable String levdatmedcodcatastral, @Nullable String levdatmedmedidor, @Nullable String levdatmedsecuencia, @Nullable String levdatmedmarca, @Nullable String levdatmeddigito, @Nullable String levdatmedlectura, @Nullable String levdatmeddiametro, @Nullable String levdatmedmaterial, @Nullable String levdatmedestcupula, @Nullable String levobservmed, @Nullable String levdatmedobsmanual, @Nullable String levdatmedfoto, @Nullable String levdatmedpfoto, @Nullable String levdatmedfecha, @Nullable String levdatmedcoordx, @Nullable String levdatmedcoordy, @Nullable String levdatmedcantdatos, @Nullable String levdatmedtipo) {
        this.levdatmedsector = levdatmedsector;
        this.levdatmedruta = levdatmedruta;
         this.levdatmedcuenta = levdatmedcuenta;
        this.levdatmedcodcatastral = levdatmedcodcatastral;
        this.levdatmedmedidor = levdatmedmedidor;
        this.levdatmedsecuencia = levdatmedsecuencia;
        this.levdatmedmarca = levdatmedmarca;
        this.levdatmeddigito = levdatmeddigito;
        this.levdatmedlectura = levdatmedlectura;
        this.levdatmeddiametro = levdatmeddiametro;
        this.levdatmedmaterial = levdatmedmaterial;
        this.levdatmedestcupula = levdatmedestcupula;
        this.levobservmed = levobservmed;
        this.levdatmedobsmanual = levdatmedobsmanual;
        this.levdatmedfoto = levdatmedfoto;
        this.levdatmedpfoto = levdatmedpfoto;
        this.levdatmedfecha = levdatmedfecha;
        this.levdatmedcoordx = levdatmedcoordx;
        this.levdatmedcoordy = levdatmedcoordy;
        this.levdatmedcantdatos = levdatmedcantdatos;
        this.levdatmedtipo = levdatmedtipo;
    }

    public void setLevdatmedcuenta(@NonNull String levdatmedcuenta) {
        this.levdatmedcuenta = levdatmedcuenta;
    }

    @Nullable
    public String getLevdatmedsector() {
        return levdatmedsector;
    }

    @Nullable
    public String getLevdatmedruta() {
        return levdatmedruta;
    }

    @NonNull
    public String getLevdatmedcuenta() {
        return levdatmedcuenta;
    }

    @Nullable
    public String getLevdatmedcodcatastral() {
        return levdatmedcodcatastral;
    }

    @Nullable
    public String getLevdatmedmedidor() {
        return levdatmedmedidor;
    }

    @Nullable
    public String getLevdatmedsecuencia() {
        return levdatmedsecuencia;
    }

    @Nullable
    public String getLevdatmedmarca() {
        return levdatmedmarca;
    }

    @Nullable
    public String getLevdatmeddigito() {
        return levdatmeddigito;
    }

    @Nullable
    public String getLevdatmedlectura() {
        return levdatmedlectura;
    }

    @Nullable
    public String getLevdatmeddiametro() {
        return levdatmeddiametro;
    }

    @Nullable
    public String getLevdatmedmaterial() {
        return levdatmedmaterial;
    }

    @Nullable
    public String getLevdatmedestcupula() {
        return levdatmedestcupula;
    }

    @Nullable
    public String getLevobservmed() {
        return levobservmed;
    }

    @Nullable
    public String getLevdatmedobsmanual() {
        return levdatmedobsmanual;
    }

    @Nullable
    public String getLevdatmedfoto() {
        return levdatmedfoto;
    }

    @Nullable
    public String getLevdatmedpfoto() {
        return levdatmedpfoto;
    }

    @Nullable
    public String getLevdatmedfecha() {
        return levdatmedfecha;
    }

    @Nullable
    public String getLevdatmedcoordx() {
        return levdatmedcoordx;
    }

    @Nullable
    public String getLevdatmedcoordy() {
        return levdatmedcoordy;
    }

    @Nullable
    public String getLevdatmedcantdatos() {
        return levdatmedcantdatos;
    }

    @Nullable
    public String getLevdatmedtipo() {
        return levdatmedtipo;
    }
}
