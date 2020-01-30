package com.cesarmartinez.catastral.views;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.cesarmartinez.catastral.MainActivity;
import com.cesarmartinez.catastral.R;
import com.cesarmartinez.catastral.utils.CrearDirectorios;
import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {
    private final int DURACION_SPLASH = 3000;
    CrearDirectorios crercarpetas=new CrearDirectorios();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String copyri;
        Calendar c = Calendar.getInstance ();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        int year = c.get(Calendar.YEAR);
        TextView textView = findViewById(R.id.copy1);
        copyri="Copyright "+ year +" ©  Todos los Derechos Reservados";
        textView.setText(copyri);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                crercarpetas.creardirectorios();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURACION_SPLASH);
    }

}
