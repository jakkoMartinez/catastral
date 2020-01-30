package com.cesarmartinez.catastral.room.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "levdatosacometidas",
        indices = {@Index(value = "levdatacomcuenta",unique = true),@Index(value = "levdatacommedidor",unique = true)}
)
public class LevDatosAcometida {
    //DATOS MEDIDOR CAMPOS COMUNES
    @SerializedName("levdatacomruta")
    @Expose
    @Nullable
    public String levdatacomruta;//RUTA DE LECTURA
    @PrimaryKey
    @NonNull
    @SerializedName("levdatacomcuenta")
    @Expose
    public String levdatacomcuenta;//CUENTA DE MEDIDOR
    @SerializedName("levdatacomcodcatastral")
    @Expose
    @Nullable
    public String levdatacomcodcatastral;//CODIGO CATASTRAL
    @SerializedName("levdatacommedidor")
    @Expose
    @Nullable
    public String levdatacommedidor;//NUMERO DE MEDIDOR
    //FIN DATOS MEDIDOR CAMPOS COMUNES
    //INFORMACION  DE LA ACOMETIDA
    @SerializedName("levdatacomdiametro")
    @Expose
    @Nullable
    public String levdatacomdiametro;//DIAMETRO (1/2, 3/4,1")
    @SerializedName("levdatacommaterial")
    @Expose
    @Nullable
    public String levdatacommaterial;//COBRE, PLASTICA, PVC, GALVANIZADA
    @SerializedName("levdatacomcajamaterial")
    @Expose
    @Nullable
    public String levdatacomcajamaterial;//METALICO,PLASTICO,CONCRETO,SIN CAJA
    @SerializedName("levdatacomestado")
    @Expose
    @Nullable
    public String levdatacomestado;//BUEN ESTADO, MAL ESTADO
    @SerializedName("levdatacommodinstal")
    @Expose
    @Nullable
    public String levdatacommodinstal;//HORIZONTAL,VERTICAL
    //INFORMACION BASICA PREDIO
    @SerializedName("levdatacomexistmed")
    @Expose
    @Nullable
    public String levdatacomexistmed;//SI,NO
    @SerializedName("levdatacomtipouso")
    @Expose
    @Nullable
    public String levdatacomtipouso;//1- DOMESTICO/2- COMERCIAL/3- INDUSTRIAL/4- OFICIAL/5. OFICIAL EDUC.
    @SerializedName("levdatacomcondprep")
    @Expose
    @Nullable
    public String levdatacomcondprep;//Arrendamiento,Propio
    @SerializedName("levdatacomunidpred")
    @Expose
    @Nullable
    public String levdatacomunidpred;//UNIFAMILIAR,MULTIFAMILIAR,EDIF.APARTAMENTOS,(CANTIDAD DE PISOS),HABITACIONAL
    @SerializedName("levdatacomservbasic")
    @Expose
    @Nullable
    public String levdatacomservbasic;//AGUA,ALCANTARILLADO,ENERGIA,CNT,INTERNET
    @SerializedName("levdatacomestpredio")
    @Expose
    @Nullable
    public String levdatacomestpredio;//EN CONSTRUCCION,CONSTRUCCION SUSPENDIDA,DEMOLIDO,ABANDONADO,LOTE
    //INFORMACION URBANISTICO
    @SerializedName("levdatacomparq")
    @Expose
    @Nullable
    public String levdatacomparq;//SI,NO
    @SerializedName("levdatacomcentrosalud")
    @Expose
    @Nullable
    public String levdatacomcentrosalud;//SI,NO
    @SerializedName("levdatacomprespolicial")
    @Expose
    @Nullable
    public String levdatacomprespolicial;//OCACIONAL,PERMANENTE,NUNCA
    @SerializedName("levdatacomtranspub")
    @Expose
    @Nullable
    public String levdatacomtranspub;//SI,NO
    @SerializedName("levdatacomtipovia")
    @Expose
    @Nullable
    public String levdatacomtipovia;//TIERRA,HORMIGON,ASFALTO,ADOQUIN
    @SerializedName("levdatacomtipoacera")
    @Expose
    @Nullable
    public String levdatacomtipoacera;//TIERRA,HORMIGON,ASFALTO,ADOQUIN
    @SerializedName("levdatacomfococontam")
    @Expose
    @Nullable
    public String levdatacomfococontam;//SI,NO
    @SerializedName("levdatacomfocodescrip")
    @Expose
    @Nullable
    public String levdatacomfocodescrip;//LECTOR ESCRIBE EL TIPO  DE CONTAMINACION
    //CAMPOS COMUNES NO VISIBLES
    @SerializedName("levdatacomfoto")
    @Expose
    @Nullable
    public String levdatacomfoto;//COD=TIPLEV_A_CUENTA_NUMNUMERO_FECHA//FOTO PREDIO
    @SerializedName("levdatacomfecha")
    @Expose
    @Nullable
    public String levdatacomfecha;//FECHA DE LEVANTAMIENTO
    @SerializedName("levdatacomcoordx")
    @Expose
    @Nullable
    public String levdatacomcoordx;//COORDX EQUIPO
    @SerializedName("levdatacomcoordy")
    @Expose
    @Nullable
    public String levdatacomcoordy;//COORDY EQUIPO
    @SerializedName("levdatacomcantdatos")
    @Expose
    @Nullable
    public String levdatacomcantdatos;//CANTIDAD DE DATOS
    @SerializedName("levdatacomtipo")
    @Expose
    @Nullable
    public String levdatacomtipo;//TIPO DE LEVANTAMIENTO
    //FIN DATOS COMUNES NO VISIBLES


    public LevDatosAcometida(@Nullable String levdatacomruta, @NonNull String levdatacomcuenta, @Nullable String levdatacomcodcatastral, @Nullable String levdatacommedidor, @Nullable String levdatacomdiametro, @Nullable String levdatacommaterial, @Nullable String levdatacomcajamaterial, @Nullable String levdatacomestado, @Nullable String levdatacommodinstal, @Nullable String levdatacomexistmed, @Nullable String levdatacomtipouso, @Nullable String levdatacomcondprep, @Nullable String levdatacomunidpred, @Nullable String levdatacomservbasic, @Nullable String levdatacomestpredio, @Nullable String levdatacomparq, @Nullable String levdatacomcentrosalud, @Nullable String levdatacomprespolicial, @Nullable String levdatacomtranspub, @Nullable String levdatacomtipovia, @Nullable String levdatacomtipoacera, @Nullable String levdatacomfococontam, @Nullable String levdatacomfocodescrip, @Nullable String levdatacomfoto, @Nullable String levdatacomfecha, @Nullable String levdatacomcoordx, @Nullable String levdatacomcoordy, @Nullable String levdatacomcantdatos, @Nullable String levdatacomtipo) {
        this.levdatacomruta = levdatacomruta;
        this.levdatacomcuenta = levdatacomcuenta;
        this.levdatacomcodcatastral = levdatacomcodcatastral;
        this.levdatacommedidor = levdatacommedidor;
        this.levdatacomdiametro = levdatacomdiametro;
        this.levdatacommaterial = levdatacommaterial;
        this.levdatacomcajamaterial = levdatacomcajamaterial;
        this.levdatacomestado = levdatacomestado;
        this.levdatacommodinstal = levdatacommodinstal;
        this.levdatacomexistmed = levdatacomexistmed;
        this.levdatacomtipouso = levdatacomtipouso;
        this.levdatacomcondprep = levdatacomcondprep;
        this.levdatacomunidpred = levdatacomunidpred;
        this.levdatacomservbasic = levdatacomservbasic;
        this.levdatacomestpredio = levdatacomestpredio;
        this.levdatacomparq = levdatacomparq;
        this.levdatacomcentrosalud = levdatacomcentrosalud;
        this.levdatacomprespolicial = levdatacomprespolicial;
        this.levdatacomtranspub = levdatacomtranspub;
        this.levdatacomtipovia = levdatacomtipovia;
        this.levdatacomtipoacera = levdatacomtipoacera;
        this.levdatacomfococontam = levdatacomfococontam;
        this.levdatacomfocodescrip = levdatacomfocodescrip;
        this.levdatacomfoto = levdatacomfoto;
        this.levdatacomfecha = levdatacomfecha;
        this.levdatacomcoordx = levdatacomcoordx;
        this.levdatacomcoordy = levdatacomcoordy;
        this.levdatacomcantdatos = levdatacomcantdatos;
        this.levdatacomtipo = levdatacomtipo;
    }

    public void setLevdatacomcuenta(@NonNull String levdatacomcuenta) {
        this.levdatacomcuenta = levdatacomcuenta;
    }

    @Nullable
    public String getLevdatacomruta() {
        return levdatacomruta;
    }

    @NonNull
    public String getLevdatacomcuenta() {
        return levdatacomcuenta;
    }

    @Nullable
    public String getLevdatacomcodcatastral() {
        return levdatacomcodcatastral;
    }

    @Nullable
    public String getLevdatacommedidor() {
        return levdatacommedidor;
    }

    @Nullable
    public String getLevdatacomdiametro() {
        return levdatacomdiametro;
    }

    @Nullable
    public String getLevdatacommaterial() {
        return levdatacommaterial;
    }

    @Nullable
    public String getLevdatacomcajamaterial() {
        return levdatacomcajamaterial;
    }

    @Nullable
    public String getLevdatacomestado() {
        return levdatacomestado;
    }

    @Nullable
    public String getLevdatacommodinstal() {
        return levdatacommodinstal;
    }

    @Nullable
    public String getLevdatacomexistmed() {
        return levdatacomexistmed;
    }

    @Nullable
    public String getLevdatacomtipouso() {
        return levdatacomtipouso;
    }

    @Nullable
    public String getLevdatacomcondprep() {
        return levdatacomcondprep;
    }

    @Nullable
    public String getLevdatacomunidpred() {
        return levdatacomunidpred;
    }

    @Nullable
    public String getLevdatacomservbasic() {
        return levdatacomservbasic;
    }

    @Nullable
    public String getLevdatacomestpredio() {
        return levdatacomestpredio;
    }

    @Nullable
    public String getLevdatacomparq() {
        return levdatacomparq;
    }

    @Nullable
    public String getLevdatacomcentrosalud() {
        return levdatacomcentrosalud;
    }

    @Nullable
    public String getLevdatacomprespolicial() {
        return levdatacomprespolicial;
    }

    @Nullable
    public String getLevdatacomtranspub() {
        return levdatacomtranspub;
    }

    @Nullable
    public String getLevdatacomtipovia() {
        return levdatacomtipovia;
    }

    @Nullable
    public String getLevdatacomtipoacera() {
        return levdatacomtipoacera;
    }

    @Nullable
    public String getLevdatacomfococontam() {
        return levdatacomfococontam;
    }

    @Nullable
    public String getLevdatacomfocodescrip() {
        return levdatacomfocodescrip;
    }

    @Nullable
    public String getLevdatacomfoto() {
        return levdatacomfoto;
    }

    @Nullable
    public String getLevdatacomfecha() {
        return levdatacomfecha;
    }

    @Nullable
    public String getLevdatacomcoordx() {
        return levdatacomcoordx;
    }

    @Nullable
    public String getLevdatacomcoordy() {
        return levdatacomcoordy;
    }

    @Nullable
    public String getLevdatacomcantdatos() {
        return levdatacomcantdatos;
    }

    @Nullable
    public String getLevdatacomtipo() {
        return levdatacomtipo;
    }
}
