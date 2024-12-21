package com.app.neclone;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter2 extends FragmentStateAdapter {


    public ViewPagerAdapter2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position){
           case 0:return new PersonalFragment();
           case 1:return new ServicesFragment();
           case 2:return new BusinessesFragment();
           default:return new PersonalFragment();
       }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
