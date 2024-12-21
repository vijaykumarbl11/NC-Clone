package com.app.neclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class TabAdapter extends FragmentPagerAdapter {

    private  final ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    private  final ArrayList<String> fragmentTitle=new ArrayList<>();

    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new PersonalFragment();
        } else if (position==1) {
            return new ServicesFragment();

        }else {
            return new BusinessesFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    //method to add fragment to arraylist
    public void addFragment(Fragment fragment,String title){
        fragmentArrayList.add(fragment);
        fragmentTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "Personal";
        } else if (position==1) {
            return "Services";

        }else {
            return "Businesses";
        }
    }
}
