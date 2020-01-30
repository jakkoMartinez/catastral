package com.cesarmartinez.catastral.fragments.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cesarmartinez.catastral.R;
import com.cesarmartinez.catastral.interfaces.IComunicaFragments;
import com.cesarmartinez.catastral.room.dao.UsuarioDao;
import com.cesarmartinez.catastral.room.model.Usuario;
import com.cesarmartinez.catastral.utils.Fechas;
import com.cesarmartinez.catastral.utils.UsuarioUtils;
import com.cesarmartinez.catastral.utils.Validardocumentos;
import com.cesarmartinez.catastral.viewmodel.UsuarioViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SingUpFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SingUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingUpFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    IComunicaFragments interfaceComunicaFragments;
    LoginFragment loginFragment = new LoginFragment();
    Activity actividad;
    View vista;
    EditText edtxtRegistroNom,edtxtRegistroApell,edtxtRegistroCed,edtxtRegistroEmail,edtxtRegistroContrs;
    Button btnRegistroRegis;
    String fech;
    private  UsuarioViewModel usuarioViewModel;

    Validardocumentos validardocumentos= new Validardocumentos();
    public static final int ADD_USUARIO_REQUEST = 1;

    public SingUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SingUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SingUpFragment newInstance(String param1, String param2) {
        SingUpFragment fragment = new SingUpFragment();

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
        //return inflater.inflate(R.layout.fragment_sing_up, container, false);
        vista= inflater.inflate(R.layout.fragment_sing_up, container, false);
        edtxtRegistroNom=vista.findViewById(R.id.EdtxtRegistroNom);
        edtxtRegistroApell=vista.findViewById(R.id.EdtxtRegistroApell);
        edtxtRegistroCed=vista.findViewById(R.id.EdtxtRegistroCed);
        edtxtRegistroCed=vista.findViewById(R.id.EdtxtRegistroCed);
        edtxtRegistroEmail=vista.findViewById(R.id.EdtxtRegistroEmail);
        edtxtRegistroContrs=vista.findViewById(R.id.EdtxtRegistroContrs);
        btnRegistroRegis=vista.findViewById(R.id.BtnRegistroRegis);
        eventosLogin();
        return vista;
    }
    private void eventosLogin() {
        btnRegistroRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (misdatos()){
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayout, loginFragment);
                        transaction.commit();
                    }else{
                        return;
                    }

                }catch (Exception e){
                    Toast.makeText(actividad, "Error no se ha guardado "+e.getMessage(), Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }

    private boolean misdatos(){
        String nombres = edtxtRegistroNom.getText().toString();
        String apellidos = edtxtRegistroApell.getText().toString();
        String cedula = edtxtRegistroCed.getText().toString();
        String email = edtxtRegistroEmail.getText().toString();
        String contras = edtxtRegistroContrs.getText().toString();
        if (nombres.trim().isEmpty() || apellidos.trim().isEmpty()||cedula.trim().isEmpty()|| email.trim().isEmpty()||contras.trim().isEmpty() ) {
            Toast.makeText(actividad, "ingrese todos los datos son requeridos", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            UsuarioUtils usuarioUtils=new UsuarioUtils();
            String equip;
            equip=usuarioUtils.numeroequipo(nombres+" "+apellidos);

            if (validardocumentos.validarCedula(cedula)){
                try {
                    Fechas fechas =new Fechas();
                    fech=fechas.Fecha();
                    guardardatos(nombres,apellidos,cedula,email,contras,"0",equip,fech);
                    return true;
                }catch (Exception e){
                    Toast.makeText(actividad, "Error "+e.getMessage(), Toast.LENGTH_LONG).show();
                    return false;
                }

            }else{
                Toast.makeText(actividad, "Cedula mal ingresada", Toast.LENGTH_LONG).show();
                return false;
            }
        }
    }
     private boolean  guardardatos(String nombres, String apellidos, String cedula, String email, String contraseña, String recordar, String equipo,String fecha){
        Usuario usuario = new Usuario(nombres, apellidos, cedula,email,contraseña,recordar,equipo,fecha);
        try{
             usuarioViewModel = ViewModelProviders.of(this).get(UsuarioViewModel.class);
             usuarioViewModel.insert(usuario);
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
