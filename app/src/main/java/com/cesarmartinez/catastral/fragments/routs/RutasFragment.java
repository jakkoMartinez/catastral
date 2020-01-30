package com.cesarmartinez.catastral.fragments.routs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cesarmartinez.catastral.MainActivity;
import com.cesarmartinez.catastral.R;
import com.cesarmartinez.catastral.adapters.RutaAdapter;
import com.cesarmartinez.catastral.interfaces.IComunicaFragments;
import com.cesarmartinez.catastral.room.dao.LevDatosMedidorDao;
import com.cesarmartinez.catastral.room.model.LevDatosMedidor;
import com.cesarmartinez.catastral.room.model.Ruta;
import com.cesarmartinez.catastral.viewmodel.LevDatosMedidorViewModel;
import com.cesarmartinez.catastral.viewmodel.RutaViewModel;
import com.cesarmartinez.catastral.views.MapaActivity;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RutasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RutasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RutasFragment extends Fragment {
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
    private RecyclerView myReciclerView;
    //private RutaViewModel rutaViewModel;
    private String cantonlecturar;
    private String sectorlecturar;
    private String rutalecturar;
    private LevDatosMedidorViewModel rutaViewModel;

    public RutasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RutasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RutasFragment newInstance(String param1, String param2) {
        RutasFragment fragment = new RutasFragment();
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
        //return inflater.inflate(R.layout.fragment_rutas, container, false);
        vista=inflater.inflate(R.layout.fragment_rutas, container, false);

        myReciclerView = vista.findViewById(R.id.recyclerview_ruta);
        myReciclerView.setLayoutManager(new LinearLayoutManager(actividad));
        myReciclerView.setHasFixedSize(true);
        final RutaAdapter rutaAdapter= new RutaAdapter();
        myReciclerView.setAdapter(rutaAdapter);

        rutaViewModel = ViewModelProviders.of(this).get(LevDatosMedidorViewModel.class);

        rutaViewModel.getAllMRutas().observe(this, new Observer<List<LevDatosMedidorDao.allRutas>>() {
            @Override
            public void onChanged(@Nullable List<LevDatosMedidorDao.allRutas> rutas) {
                rutaAdapter.setRutas(rutas);
                //rutaAdapter.submitList(rutas);
            }

        });
        rutaAdapter.setOnItemClickListener(new RutaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(LevDatosMedidorDao.allRutas ruta) {
                sectorlecturar=ruta.sector;
                rutalecturar=ruta.mruta;
                mostrarmaparuta();
            }

        });

        return vista;
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
    private void mostrarmaparuta(){
        //Toast.makeText(actividad,"abrir mapa",Toast.LENGTH_SHORT).show();
        Toast.makeText(actividad,"ruta de lectura:"+sectorlecturar+rutalecturar,Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(actividad, MapaActivity.class);
        intent.putExtra("rutaparamap", rutalecturar);
        startActivity(intent);

        //Intent i =new Intent(getContext(),MapsLectura.class);
        //i.putExtra("RUTA_LECTURAR",cantonlecturar+sectorlecturar+rutalecturar);
        //i.putExtra("ESTADO_GPS",l.getDataFragment());
        //getContext().startActivity(i);
    }
}
