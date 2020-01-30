package com.cesarmartinez.catastral.views;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cesarmartinez.catastral.R;
import com.cesarmartinez.catastral.adapters.LevDatosMedidorAdapter;
import com.cesarmartinez.catastral.room.dao.LevDatosMedidorDao;
import com.cesarmartinez.catastral.room.model.LevDatosMedidor;
import com.cesarmartinez.catastral.viewmodel.LevDatosMedidorViewModel;
import com.cesarmartinez.catastral.views.catastral.levantamiento.LevdatosMedActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapaActivity  extends FragmentActivity implements OnMapReadyCallback {
    //private static final String TAG = "MainActivity";
    private GoogleMap mMap;
    private String cuentalev,rutalectura,latitud,longitud;

    int cant =0;
    public double lati;
    public double longi;
    List milist;
    //public String
    //public String ;
    private LocationManager locManager;
    private LocationListener locListener;
    private LevDatosMedidorViewModel levDatosMedidorViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        rutalectura = getIntent().getStringExtra("rutaparamap");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_mapmedidores);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        final LevDatosMedidorAdapter levDatosMedidorAdapter= new LevDatosMedidorAdapter();
        recyclerView.setAdapter(levDatosMedidorAdapter);
        levDatosMedidorViewModel = ViewModelProviders.of(this).get(LevDatosMedidorViewModel.class);

        levDatosMedidorViewModel.getLevDatosMedidoresbyRuta(rutalectura).observe(this, new Observer<List<LevDatosMedidor>>() {
            @Override
            public void onChanged(@Nullable List<LevDatosMedidor> levDatosMedidores) {
                levDatosMedidorAdapter.setLevantamientos(levDatosMedidores);
                milist=levDatosMedidores;
                LatLng coorpunto;
                String medidor=levDatosMedidores.get(0).levdatmedmedidor;
                String tipo=levDatosMedidores.get(0).levdatmedtipo;
                double latitud =  Double.parseDouble(levDatosMedidores.get(0).levdatmedcoordx);
                double longitud = Double.parseDouble(levDatosMedidores.get(0).levdatmedcoordy);
                coorpunto=new LatLng(latitud,longitud);
                MarkesMedidor(coorpunto, medidor, tipo);
               }
        });
       levDatosMedidorAdapter.setOnItemClickListener(new LevDatosMedidorAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(LevDatosMedidor levDatosMedidor) {
               cuentalev=levDatosMedidor.levdatmedcuenta;
               iniciarlev();
           }
       });
       // Toast.makeText(this,"cantidad list:"+milist.size(),Toast.LENGTH_SHORT).show();

    }
    private void iniciarlev(){

        Toast.makeText(this,"cuenta catastrar:"+cuentalev,Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this, LevdatosMedActivity.class);
        intent.putExtra("rutamedidor", rutalectura);
        intent.putExtra("cuenta", cuentalev);
        startActivity(intent);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        comenzarLocalizacion();
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.isMyLocationEnabled();
        mMap.isTrafficEnabled() ;
        mMap.setTrafficEnabled(true);
        //posicionar camara para q tenga efecto 3d
        LatLng posisiogps = new LatLng(lati, longi);
        CameraPosition camPos = new CameraPosition.Builder()
                .target(posisiogps )   //Centramos el mapa en posision gps
                .zoom(19)         //Establecemos el zoom en 19
                .bearing(45)      //Establecemos la orientación con el noreste arriba
                .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
                .build();
        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);
        mMap.animateCamera(camUpd3);
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
    public void mostrarPosicion(Location loc) {
        if (loc != null) {
            latitud=""+loc.getLatitude();
            lati= loc.getLatitude();
            longi=loc.getLongitude();
            longitud=""+loc.getLongitude();
        } else {
            latitud="Latitud: (sin_datos)";
            longitud="Longitud: (sin_datos)";
        }
    }
    private void comenzarLocalizacion() {
        //Obtenemos una referencia al LocationManager
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //Obtenemos la última posición conocida
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }
        Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //Mostramos la última posición conocida
        mostrarPosicion(loc);
        //Nos registramos para recibir actualizaciones de la posición
        locListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                mostrarPosicion(location);
            }
            public void onProviderDisabled(String provider) {
            }
            public void onProviderEnabled(String provider) {
            }
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.i("", "Provider Status: " + status);
            }
        };
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locListener);
    }


    public void MarkesMedidor(LatLng position, String titulo, String info) {
        // Agregamos marcadores para indicar los medidores
           if (info.equals("M")){
                mMap.addMarker(new MarkerOptions()
                        .position(position)
                        .title(titulo)  //Agrega un titulo al marcador
                        .snippet(info)   //Agrega informacion detalle relacionada con el marcador
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            }
        if (info.equals("ML")){
            mMap.addMarker(new MarkerOptions()
                    .position(position)
                    .title(titulo)  //Agrega un titulo al marcador
                    .snippet(info)   //Agrega informacion detalle relacionada con el marcador
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        }
        if (info.equals("C")){
            mMap.addMarker(new MarkerOptions()
                    .position(position)
                    .title(titulo)  //Agrega un titulo al marcador
                    .snippet(info)   //Agrega informacion detalle relacionada con el marcador
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        }
        if (info.equals("CL")){
            mMap.addMarker(new MarkerOptions()
                    .position(position)
                    .title(titulo)  //Agrega un titulo al marcador
                    .snippet(info)   //Agrega informacion detalle relacionada con el marcador
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        }
    }
}

