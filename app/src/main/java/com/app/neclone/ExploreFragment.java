package com.app.neclone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.neclone.databinding.FragmentExploreBinding;
import com.google.android.material.tabs.TabLayout;


public class ExploreFragment extends Fragment {


    public ExploreFragment() {
        // Required empty public constructor
    }


  FragmentExploreBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentExploreBinding.inflate(inflater,container,false);


       /* TabAdapter tabAdapter=new TabAdapter(getActivity().getSupportFragmentManager());
        binding.viewpager22.setAdapter(tabAdapter);
        binding.tablayout.setupWithViewPager(binding.viewpager22);*/


        /*tabAdapter.addFragment(new PersonalFragment(),"Personal");
        tabAdapter.addFragment(new ServicesFragment(),"Services");
        tabAdapter.addFragment(new BusinessesFragment(),"Businesses");*/

      /* ViewPagerAdapter2 viewPagerAdapter2=new ViewPagerAdapter2(this);
       binding.viewpager22.setAdapter(viewPagerAdapter2);*/

      /*  binding.tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewpager22.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.viewpager22.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.tablayout.getTabAt(position).select();

                super.onPageSelected(position);
            }
        });
*/

        return binding.getRoot();
    }
}