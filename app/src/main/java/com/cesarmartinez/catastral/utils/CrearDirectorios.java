package com.cesarmartinez.catastral.utils;

import java.io.File;

import static com.cesarmartinez.catastral.helpers.Directorios.*;


public class CrearDirectorios {
        private static File crearcarpetabases=new File(CarpetaBases);
        private static File crearcarpetaimagnmedidor=new File(Carpetaimagenmedidor);
        private static  File crearcarpetaimagncatastro=new File(Carpetaimagencatastro);
        private static  File crearcarpetaimagnclandestinos=new File(Carpetaimagenclandestinos);
        private static  File crearcarpetarespaldos=new File(CarpetaRespaldos);
        private File carpeta;
        public void creardirectorios(){
            try {
                crearcarpetabases.mkdirs() ;
                crearcarpetaimagncatastro.mkdirs();
                crearcarpetaimagnclandestinos.mkdirs();
                crearcarpetaimagnmedidor.mkdirs() ;
                crearcarpetarespaldos.mkdirs();
            }catch (Exception exc){

            }
        }
        public void creardirectorioespecifico(String Ruta){
            carpeta=new File(Ruta);
            try {
                carpeta.mkdirs();
            }catch (Exception ex)
            {

            }
        }
}
