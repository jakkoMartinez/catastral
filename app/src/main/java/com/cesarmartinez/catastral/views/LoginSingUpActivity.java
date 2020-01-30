package com.cesarmartinez.catastral.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.cesarmartinez.catastral.R;
import com.cesarmartinez.catastral.fragments.home.LoginFragment;
import com.cesarmartinez.catastral.fragments.home.SingUpFragment;
import com.cesarmartinez.catastral.interfaces.IComunicaFragments;

import com.cesarmartinez.catastral.room.model.Usuario;
import com.cesarmartinez.catastral.viewmodel.UsuarioViewModel;

import java.util.List;


public class LoginSingUpActivity extends AppCompatActivity  implements IComunicaFragments, LoginFragment.OnFragmentInteractionListener,SingUpFragment.OnFragmentInteractionListener{
    private UsuarioViewModel usuarioViewModel;

    Fragment loginFragment,singUpFragment;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sing_up);
        loginFragment= new LoginFragment();
        singUpFragment=new SingUpFragment();
        frameLayout=findViewById(R.id.frameLayout);
        usuarioViewModel = ViewModelProviders.of(this).get(UsuarioViewModel.class);
        usuarioViewModel.getAllUsuarios().observe(this, new Observer<List<Usuario>>() {
            @Override
            public void onChanged(@Nullable List<Usuario> usuarios) {
                String recuerdame;
                int count = usuarios.size();
                Log.println(Log.ERROR,"Contador", String.valueOf(count));
                if (count>=1){
                    recuerdame=usuarios.get(0).getUserrecordar();
                    mostarpantalla(recuerdame);
                }else
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,singUpFragment).commit();
                }

            }
        });
        //getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,loginFragment).commit();
    }

    public void mostarpantalla(String recuerdame){
        if (recuerdame.equals("1")){
            Intent intent=new Intent(this, MenuActivity.class);
            startActivity(intent);
        }else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,loginFragment).commit();

        }

    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void vistamenurutas() {

    }
}
