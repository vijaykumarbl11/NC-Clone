package com.app.neclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.neclone.databinding.PersonalsampleBinding;
import com.squareup.picasso.Picasso;

import org.apache.commons.text.WordUtils;

import java.util.ArrayList;

public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.ViewHolder> {


    Context context;
    ArrayList<PersonalClass> list;

    public PersonalAdapter(Context context, ArrayList<PersonalClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PersonalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.personalsample, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonalClass data = list.get(position);

        String name = data.getName();
        String city = data.getCity();
        String profession = data.getProfession();
        String status = data.getStatus();
        String image = data.getImage();
        int score=data.getScore();



        holder.binding.name.setText(name);
        holder.binding.city.setText(city);
        holder.binding.education.setText(profession);
        holder.binding.status.setText(status);
        holder.binding.range.setText(data.getRange());
        holder.binding.score.setText(data.getScore()+"");

        holder.binding.progressBar.setProgress(score);
        holder.binding.progressBar.setMax(100);
        if (!image.isEmpty()){

            holder.binding.latters.setVisibility(View.GONE);
            holder.binding.profile.setVisibility(View.VISIBLE);
            Picasso.get().load(data.getImage()).into(holder.binding.profile);
        }
        else {

            holder.binding.latters.setVisibility(View.VISIBLE);
            holder.binding.profile.setVisibility(View.GONE);

            String initials = WordUtils.initials(name);
            holder.binding.latters.setText(initials);
        }

        holder.binding.invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.binding.invite.setText("Pending...");
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        PersonalsampleBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = PersonalsampleBinding.bind(itemView);
        }
    }
}
/*public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.ViewHolder> {

    Context context;
    ArrayList<PersonalClass> list;

    public PersonalAdapter(Context context, ArrayList<PersonalClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PersonalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.personalsample,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalAdapter.ViewHolder holder, int position) {
      PersonalClass data=list.get(position);
      holder.binding.name.setText(data.getName());
      holder.binding.city.setText(data.getCity());
      holder.binding.education.setText(data.getProfession());
      holder.binding.status.setText(data.getStatus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        PersonalsampleBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=PersonalsampleBinding.bind(itemView);
        }
    }
}*/
