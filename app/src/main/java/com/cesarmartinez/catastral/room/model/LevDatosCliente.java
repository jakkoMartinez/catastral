package com.cesarmartinez.catastral.room.model;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "levdatosclientes",
        indices = {@Index(value = "levdatclicuenta",unique = true),@Index(value = "levdatclimedidor",unique = true), @Index(value = "levdatclicedula")}
)
public class LevDatosCliente {
    //DATOS MEDIDOR CAMPOS COMUNES
    @SerializedName("levdatcliruta")
    @Expose
    @Nullable
    public String levdatcliruta;//RUTA DE LECTURA
    @PrimaryKey
    @NonNull
    @SerializedName("levdatclicuenta")
    @Expose
    public String levdatclicuenta;//CUENTA DE MEDIDOR
    @SerializedName("levdatclicodcatastral")
    @Expose
    @Nullable
    public String levdatclicodcatastral;//CODIGO CATASTRAL
    @SerializedName("levdatclimedidor")
    @Expose
    @Nullable
    public String levdatclimedidor;//NUMERO DE MEDIDOR
    //FIN DATOS MEDIDOR CAMPOS COMUNES
    //DATOS USUARIO
    @SerializedName("levdatclicedula")
    @Expose
    @Nullable
    public String levdatclicedula;//CEDULA
    @SerializedName("levdatclinombre")
    @Expose
    @Nullable
    public String levdatclinombre;// 2 NOMBRES
    @SerializedName("levdatcliapellido")
    @Expose
    @Nullable
    public String levdatcliapellido;//2 APELLIDOS
    @SerializedName("levdatclidireccion")
    @Expose
    @Nullable
    public String levdatclidireccion;//DIRECCION
    @SerializedName("levdatclitelefcasa")
    @Expose
    @Nullable
    public String levdatclitelefcasa;//TELEFONO CASA
    @SerializedName("levdatclitelefcel")
    @Expose
    @Nullable
    public String levdatclitelefcel;//TELEFONO CELULAR
    @SerializedName("levdatcliemail")
    @Expose
    @Nullable
    public String levdatcliemail;//EMAIL
    @SerializedName("levdatcliobserv")
    @Expose
    @Nullable
    public String levdatcliobserv;//OBSERVACION DATOS USUARIO
    @SerializedName("levdatclicodnotif")
    @Expose
    @Nullable
    public String levdatclicodnotif;//CODIGO DE LA NOTIFICACION
    //CAMPOS COMUNES NO VISIBLES
    @SerializedName("levdatclifoto")
    @Expose
    @Nullable
    public String levdatclifoto;//COD=TIPLEV_C_CUENTA_NUMNUMERO_FECHA//FOTO CLIENTE (CEDULA)
    @SerializedName("levdatclifotonot")
    @Expose
    @Nullable
    public String levdatclifotonot;//COD=TIPLEV_N_CUENTA_NUMNUMERO_FECHA//FOTO CLIENTE (CEDULA)
    @SerializedName("levdatclifecha")
    @Expose
    @Nullable
    public String levdatclifecha;//FECHA DE LEVANTAMIENTO
    @SerializedName("levdatclicoordx")
    @Expose
    @Nullable
    public String levdatclicoordx;//COORDX EQUIPO
    @SerializedName("levdatclicoordy")
    @Expose
    @Nullable
    public String levdatclicoordy;//COORDY EQUIPO
    @SerializedName("levdatclicantdatos")
    @Expose
    @Nullable
    public String levdatclicantdatos;//CANTIDAD DE DATOS
    @SerializedName("levdatclitipo")
    @Expose
    @Nullable
    public String levdatclitipo;//TIPO DE LEVANTAMIENTO
    //FIN DATOS COMUNES NO VISIBLES


    public LevDatosCliente(@Nullable String levdatcliruta, @NonNull String levdatclicuenta, @Nullable String levdatclicodcatastral, @Nullable String levdatclimedidor, @Nullable String levdatclicedula, @Nullable String levdatclinombre, @Nullable String levdatcliapellido, @Nullable String levdatclidireccion, @Nullable String levdatclitelefcasa, @Nullable String levdatclitelefcel, @Nullable String levdatcliemail, @Nullable String levdatcliobserv, @Nullable String levdatclicodnotif, @Nullable String levdatclifoto, @Nullable String levdatclifotonot, @Nullable String levdatclifecha, @Nullable String levdatclicoordx, @Nullable String levdatclicoordy, @Nullable String levdatclicantdatos, @Nullable String levdatclitipo) {
        this.levdatcliruta = levdatcliruta;
        this.levdatclicuenta = levdatclicuenta;
        this.levdatclicodcatastral = levdatclicodcatastral;
        this.levdatclimedidor = levdatclimedidor;
        this.levdatclicedula = levdatclicedula;
        this.levdatclinombre = levdatclinombre;
        this.levdatcliapellido = levdatcliapellido;
        this.levdatclidireccion = levdatclidireccion;
        this.levdatclitelefcasa = levdatclitelefcasa;
        this.levdatclitelefcel = levdatclitelefcel;
        this.levdatcliemail = levdatcliemail;
        this.levdatcliobserv = levdatcliobserv;
        this.levdatclicodnotif = levdatclicodnotif;
        this.levdatclifoto = levdatclifoto;
        this.levdatclifotonot = levdatclifotonot;
        this.levdatclifecha = levdatclifecha;
        this.levdatclicoordx = levdatclicoordx;
        this.levdatclicoordy = levdatclicoordy;
        this.levdatclicantdatos = levdatclicantdatos;
        this.levdatclitipo = levdatclitipo;
    }

    public void setLevdatclicuenta(@NonNull String levdatclicuenta) {
        this.levdatclicuenta = levdatclicuenta;
    }

    @Nullable
    public String getLevdatcliruta() {
        return levdatcliruta;
    }

    @NonNull
    public String getLevdatclicuenta() {
        return levdatclicuenta;
    }

    @Nullable
    public String getLevdatclicodcatastral() {
        return levdatclicodcatastral;
    }

    @Nullable
    public String getLevdatclimedidor() {
        return levdatclimedidor;
    }

    @Nullable
    public String getLevdatclicedula() {
        return levdatclicedula;
    }

    @Nullable
    public String getLevdatclinombre() {
        return levdatclinombre;
    }

    @Nullable
    public String getLevdatcliapellido() {
        return levdatcliapellido;
    }

    @Nullable
    public String getLevdatclidireccion() {
        return levdatclidireccion;
    }

    @Nullable
    public String getLevdatclitelefcasa() {
        return levdatclitelefcasa;
    }

    @Nullable
    public String getLevdatclitelefcel() {
        return levdatclitelefcel;
    }

    @Nullable
    public String getLevdatcliemail() {
        return levdatcliemail;
    }

    @Nullable
    public String getLevdatcliobserv() {
        return levdatcliobserv;
    }

    @Nullable
    public String getLevdatclicodnotif() {
        return levdatclicodnotif;
    }

    @Nullable
    public String getLevdatclifoto() {
        return levdatclifoto;
    }

    @Nullable
    public String getLevdatclifotonot() {
        return levdatclifotonot;
    }

    @Nullable
    public String getLevdatclifecha() {
        return levdatclifecha;
    }

    @Nullable
    public String getLevdatclicoordx() {
        return levdatclicoordx;
    }

    @Nullable
    public String getLevdatclicoordy() {
        return levdatclicoordy;
    }

    @Nullable
    public String getLevdatclicantdatos() {
        return levdatclicantdatos;
    }

    @Nullable
    public String getLevdatclitipo() {
        return levdatclitipo;
    }
}
