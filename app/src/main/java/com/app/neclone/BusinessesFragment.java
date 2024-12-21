package com.app.neclone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.neclone.databinding.FragmentBusinessesBinding;


public class BusinessesFragment extends Fragment {



    public BusinessesFragment() {
        // Required empty public constructor
    }
    boolean show=false;

  FragmentBusinessesBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentBusinessesBinding.inflate(inflater,container,false);
        binding.sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!show){
                    binding.sort.animate().rotation(45f).setDuration(50).start();

                    binding.tranferent.setVisibility(View.VISIBLE);
                    binding.emptyview.setAlpha(0.1F);
                    show=true;
                }else {
                    binding.sort.animate().rotation(-90f).setDuration(50).start();

                    binding.tranferent.setVisibility(View.GONE);
                    binding.emptyview.setAlpha(1);

                    show=false;
                }

            }
        });


        return binding.getRoot();
    }
}