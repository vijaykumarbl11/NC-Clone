package com.app.neclone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.app.neclone.databinding.FragmentPersonalBinding;
import com.app.neclone.databinding.FragmentServicesBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class ServicesFragment extends Fragment {


    public ServicesFragment() {
        // Required empty public constructor
    }
    ArrayList<ServicesClass> list=new ArrayList<>();
    boolean show=false;

    ServicesAdapter adapter;
FragmentServicesBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentServicesBinding.inflate(inflater,container,false);

        binding.progressBar3.setVisibility(View.VISIBLE);


       adapter=new ServicesAdapter(getContext(),list);
        binding.recservice.setAdapter(adapter);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        binding.recservice.setLayoutManager(manager);


        FirebaseFirestore.getInstance().collection("Services")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {

                            list.clear();
                            List<DocumentSnapshot> snapshotList=queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot snapshot:snapshotList){
                                ServicesClass data=snapshot.toObject(ServicesClass.class);
                                list.add(data);
                            }
                            adapter.notifyDataSetChanged();
                            binding.progressBar3.setVisibility(View.GONE);

                        }else {
                            Toast.makeText(getContext(), "no data", Toast.LENGTH_SHORT).show();
                            binding.progressBar3.setVisibility(View.GONE);

                        }

                    }
                });
        binding.searchview1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {


                Query querySearch = FirebaseFirestore.getInstance().collection("Services")
                        .orderBy("lowercase").startAt(text);

                querySearch.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        list.clear();
                        for (DocumentSnapshot data : queryDocumentSnapshots.getDocuments()) {
                            ServicesClass data1 = data.toObject(ServicesClass.class);

                            list.add(data1);


                        }
                        adapter.notifyDataSetChanged();

                    }
                });
                return false;
            }
        });
        binding.sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!show){
                    binding.sort.animate().rotation(45f).setDuration(50).start();

                    binding.tranferent.setVisibility(View.VISIBLE);
                    binding.recservice.setAlpha(0.1F);
                    show=true;
                }else {
                    binding.sort.animate().rotation(-90f).setDuration(50).start();

                    binding.tranferent.setVisibility(View.GONE);
                    binding.recservice.setAlpha(1);

                    show=false;
                }

            }
        });

        return binding.getRoot();
    }
}