package com.cesarmartinez.catastral.fragments.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.cesarmartinez.catastral.R;
import com.cesarmartinez.catastral.interfaces.IComunicaFragments;
import com.cesarmartinez.catastral.room.model.Usuario;
import com.cesarmartinez.catastral.utils.Fechas;
import com.cesarmartinez.catastral.viewmodel.UsuarioViewModel;
import com.cesarmartinez.catastral.views.MenuActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    IComunicaFragments interfaceComunicaFragments;
    Activity actividad;
    View vista;
    EditText edtxtlogincedula,edtxtlogincontrs;
    TextView txtVwloginolvidocontrs;
    Button btnloginsingup;
    Switch swLoginRecuerdame;
    SingUpFragment singUpFragment;
    private UsuarioViewModel usuarioViewModel;
    private Usuario usuario;
    String user,apell,ced,em,contras,recor,equp,fech;
    int id,recuerdame;
    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        vista= inflater.inflate(R.layout.fragment_login, container, false);
        edtxtlogincedula=vista.findViewById(R.id.EdtxtLoginCedula);
        edtxtlogincontrs=vista.findViewById(R.id.EdtxtLoginContrs);
        txtVwloginolvidocontrs=vista.findViewById(R.id.TxtVwLoginOlvidoContrs);
        btnloginsingup=vista.findViewById(R.id.BtnLoginSingUp);
        swLoginRecuerdame=vista.findViewById(R.id.SwLoginRecuerdame);
        usuarioViewModel = ViewModelProviders.of(this).get(UsuarioViewModel.class);
        usuarioViewModel.getAllUsuarios().observe(this, new Observer<List<Usuario>>() {
            @Override
            public void onChanged(@Nullable List<Usuario> usuarios) {
                id=usuarios.get(0).getUserid();
                user=usuarios.get(0).getUsernombres();
                apell=usuarios.get(0).getUserapellidos();
                ced=usuarios.get(0).getUsercedula();
                em=usuarios.get(0).getUseremail();
                contras=usuarios.get(0).getUsercontras();
                equp=usuarios.get(0).getUserequipo();
            }
        });
        eventosLogin();
        return vista;
    }
    private void eventosLogin() {
        btnloginsingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cedul=edtxtlogincedula.getText().toString();
                String contraseña=edtxtlogincontrs.getText().toString();
                try{
                    if (ced.equals(cedul)&& contras.equals(contraseña)){
                        if (recuerdame==1){
                            Fechas fechas =new Fechas();
                            fech=fechas.Fecha();
                            guardardatos(id,user,apell,ced,em,contras,"1",equp,fech);
                        }
                        Intent intent=new Intent(actividad, MenuActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(actividad, "Error de credenciales", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(actividad, "Error" +e.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        txtVwloginolvidocontrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaFragments.vistamenurutas();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, singUpFragment);
                transaction.commit();
            }
        });
        swLoginRecuerdame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                   recuerdame=1;
                    Toast.makeText(actividad, "Ok. recordamos tus credenciales..!!.", Toast.LENGTH_LONG).show();

                }else{
                    recuerdame=0;
                    Toast.makeText(actividad, "El proximo ingreso debes ingresar las credenciales..", Toast.LENGTH_LONG).show();
                }
            }
        });
       // swLoginRecuerdame.setOnCheckedChangeListener((new View.OnCh));
    }
    private boolean  guardardatos(int id,String nombres, String apellidos, String cedula, String email, String contraseña, String recordar, String equipo,String fecha){
        Usuario usuario = new Usuario(nombres, apellidos, cedula,email,contraseña,recordar,equipo,fecha);
        usuario.setUserid(id);
        try{
            usuarioViewModel = ViewModelProviders.of(this).get(UsuarioViewModel.class);
            //usuarioViewModel.insert(usuario);
            usuarioViewModel.update(usuario);
            return true;
        }catch (Exception e){
            Toast.makeText(actividad, "Error "+e.getMessage(), Toast.LENGTH_LONG).show();
            return false;
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.actividad=(Activity) context;
            interfaceComunicaFragments= (IComunicaFragments) this.actividad;
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
