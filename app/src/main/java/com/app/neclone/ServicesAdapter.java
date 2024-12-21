package com.app.neclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.neclone.databinding.ServicesampleBinding;
import com.squareup.picasso.Picasso;

import org.apache.commons.text.WordUtils;

import java.util.ArrayList;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {


    Context context;
    ArrayList<ServicesClass> list;

    public ServicesAdapter(Context context, ArrayList<ServicesClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.servicesample, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.ViewHolder holder, int position) {
        ServicesClass data = list.get(position);

        String name = data.getName();
        String city = data.getCity();
        String profession = data.getProfession();
        String yoe = data.getYoe();
        String range = data.getRange();

        String status = data.getStatus();
        int score=data.getScore();

        holder.binding.name.setText(name);
        holder.binding.city.setText(city);
        holder.binding.range.setText(range);
        holder.binding.profession.setText(profession);
        holder.binding.yoe.setText(yoe);
        holder.binding.status.setText(status);
        holder.binding.score.setText(data.getScore()+"");

        holder.binding.progressBar.setProgress(score);
        holder.binding.progressBar.setMax(100);





        if (data.getImage().equals("")){
            holder.binding.latters.setVisibility(View.VISIBLE);
            holder.binding.profile.setVisibility(View.GONE);

            String initials = WordUtils.initials(name);
            holder.binding.latters.setText(initials);

        }else {
            holder.binding.latters.setVisibility(View.GONE);
            holder.binding.profile.setVisibility(View.VISIBLE);
            Picasso.get().load(data.getImage()).into(holder.binding.profile);

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

    public class ViewHolder extends RecyclerView.ViewHolder{
        ServicesampleBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ServicesampleBinding.bind(itemView);
        }
    }
}
