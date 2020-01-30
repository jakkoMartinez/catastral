package com.cesarmartinez.catastral.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;

import com.cesarmartinez.catastral.R;
import com.cesarmartinez.catastral.adapters.MyViewPagerAdapterMenu;
import com.cesarmartinez.catastral.fragments.routs.CatastrosFragment;
import com.cesarmartinez.catastral.fragments.routs.ClandestinosFragment;
import com.cesarmartinez.catastral.fragments.routs.ConfigurarFragment;
import com.cesarmartinez.catastral.fragments.routs.RutasFragment;
import com.cesarmartinez.catastral.fragments.routs.SincronizarFragment;
import com.cesarmartinez.catastral.interfaces.IComunicaFragments;
import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity
        implements
        IComunicaFragments,
        CatastrosFragment.OnFragmentInteractionListener,ClandestinosFragment.OnFragmentInteractionListener,
        ConfigurarFragment.OnFragmentInteractionListener,SincronizarFragment.OnFragmentInteractionListener,
        RutasFragment.OnFragmentInteractionListener{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyViewPagerAdapterMenu myviewpageradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tabLayout=findViewById(R.id.tablayout_id);
        viewPager=findViewById(R.id.viewpager_id);
        myviewpageradapter=new MyViewPagerAdapterMenu(getSupportFragmentManager(),1);
        myviewpageradapter.addFragment(new RutasFragment(),"Rutas");
        myviewpageradapter.addFragment(new CatastrosFragment(),"Catastros");
        myviewpageradapter.addFragment(new ClandestinosFragment(),"Clandestinos");
        myviewpageradapter.addFragment(new SincronizarFragment(),"Sincronizar");
        myviewpageradapter.addFragment(new ConfigurarFragment(),"Configurar");
        viewPager.setAdapter(myviewpageradapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_rutas);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_catastros);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_clandestinos);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_sincronizar);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_configurar);
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void vistamenurutas() {

    }

}
