package com.cesarmartinez.catastral.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Fechas {
    String aammdd;

    Locale locale = new Locale("es","EC");
    public String Fecha() {
        this.aammdd = new SimpleDateFormat("yyyyMMdd", locale).format(new Date());
        return this.aammdd;
    }
}
