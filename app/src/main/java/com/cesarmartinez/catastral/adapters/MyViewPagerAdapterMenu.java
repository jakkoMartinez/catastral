package com.cesarmartinez.catastral.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewPagerAdapterMenu extends FragmentPagerAdapter {
    private final List<Fragment> lstFragment=new ArrayList<>();
    private final List<String>lstTitulos=new ArrayList<>();

    public MyViewPagerAdapterMenu(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    /*
    public MyViewPagerAdapterMenu(@NonNull FragmentManager fm) {
        super(fm);
    }*/
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitulos.size();
    }
    public void addFragment(Fragment fragmento, String titulo){
        lstFragment.add(fragmento);
        lstTitulos.add(titulo);
    }
}
