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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class PersonalFragment extends Fragment {



    public PersonalFragment() {
        // Required empty public constructor
    }


    ArrayList<PersonalClass> list123=new ArrayList<>();

   FragmentPersonalBinding binding;
    PersonalAdapter adapter123;
    boolean show=false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentPersonalBinding.inflate(inflater,container,false);

       adapter123=new PersonalAdapter(getContext(),list123);
        binding.recpersonal.setAdapter(adapter123);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        binding.recpersonal.setLayoutManager(manager);

        binding.progressBar3.setVisibility(View.VISIBLE);


        FirebaseFirestore.getInstance().collection("Personal")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {


                            list123.clear();
                            List<DocumentSnapshot> snapshotList=queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot snapshot:snapshotList){
                                PersonalClass data=snapshot.toObject(PersonalClass.class);
                                list123.add(data);
                            }
                            adapter123.notifyDataSetChanged();
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


                Query querySearch = FirebaseFirestore.getInstance().collection("Personal")
                        .orderBy("lowercase").startAt(text);

                querySearch.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        list123.clear();
                        for (DocumentSnapshot data : queryDocumentSnapshots.getDocuments()) {
                            PersonalClass data1 = data.toObject(PersonalClass.class);

                                list123.add(data1);


                        }
                        adapter123.notifyDataSetChanged();

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
                    binding.recpersonal.setAlpha(0.1F);
                    show=true;
                }else {
                    binding.sort.animate().rotation(-90f).setDuration(50).start();

                    binding.tranferent.setVisibility(View.GONE);
                    binding.recpersonal.setAlpha(1);

                    show=false;
                }

            }
        });


        return binding.getRoot();
    }
}