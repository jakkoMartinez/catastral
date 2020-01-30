package com.cesarmartinez.catastral.utils;

import java.util.StringTokenizer;

public class UsuarioUtils {
    public String numeroequipo(String nombrescompletos){
        String subs="",spalabra;
        StringTokenizer stPalabras = new StringTokenizer(nombrescompletos);
        while (stPalabras.hasMoreTokens()) {
            spalabra = stPalabras.nextToken();
            subs=subs + spalabra.substring(0,1);
        }
        return "COT_"+subs+"_001";
    }

}
