package com.cesarmartinez.catastral.room.model;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuarios",
        indices = {@Index(value = "useremail",unique = true), @Index(value = "userequipo",unique = true),
                @Index(value = "usercedula",unique = true)})
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    public int userid;
    @Nullable
    public String usernombres;//NOMBRES
    @Nullable
    public String userapellidos;//APELLIDOS
    @Nullable
    public String usercedula;//CEDULA
    @Nullable
    public String useremail;//EMAIL
    @Nullable
    public String usercontras;//CONTRASEÑA
    //public String userprovincia;//PROVINCIA
    @Nullable
    public String userrecordar;//RECORDAR CONSTRASEÑA
    @Nullable
    public String userequipo;//EQUIPO/2 inciales nombres /2 inciales apellidos+_ + contador COT_JCVM_001
    @Nullable
    public String userfecha;//FECHA DEL INSERT O ACTUALIZACION

    public Usuario(@Nullable String usernombres, @Nullable String userapellidos, @Nullable String usercedula, @Nullable String useremail, @Nullable String usercontras, @Nullable String userrecordar, @Nullable String userequipo, @Nullable String userfecha) {
        this.usernombres = usernombres;
        this.userapellidos = userapellidos;
        this.usercedula = usercedula;
        this.useremail = useremail;
        this.usercontras = usercontras;
        this.userrecordar = userrecordar;
        this.userequipo = userequipo;
        this.userfecha = userfecha;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }

    @Nullable
    public String getUsernombres() {
        return usernombres;
    }

    @Nullable
    public String getUserapellidos() {
        return userapellidos;
    }

    @Nullable
    public String getUsercedula() {
        return usercedula;
    }

    @Nullable
    public String getUseremail() {
        return useremail;
    }

    @Nullable
    public String getUsercontras() {
        return usercontras;
    }

    @Nullable
    public String getUserrecordar() {
        return userrecordar;
    }

    @Nullable
    public String getUserequipo() {
        return userequipo;
    }

    @Nullable
    public String getUserfecha() {
        return userfecha;
    }
}
