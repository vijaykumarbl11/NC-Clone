package com.app.neclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.app.neclone.databinding.ActivityRefineBinding;
import com.google.firebase.database.collection.LLRBNode;

public class RefineActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityRefineBinding binding;
    String Availability[];
    int num=50;
    int one=1;
    boolean coffee=true,business=false,hobi=false,friends=false,movie=false,dinning=false,dating=false,matrimony=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRefineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Availability, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.selltype.setAdapter(adapter);
        binding.selltype.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) RefineActivity.this);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

        binding.progressBar2.setProgress(num);
        binding.progressBar2.setMax(100);
        binding.count.setText(num+"");
        binding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num<100){
                    binding.progressBar2.setProgress(num+1);
                    binding.count.setText(num+1+"");
                    num++;

                    binding.progressBar2.setMax(100);
                }

            }
        });
        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num>1){
                    binding.progressBar2.setProgress(num-1);
                    binding.count.setText(num-1+"");
                    num--;

                    binding.progressBar2.setMax(100);
                }

            }
        });
        binding.Coffee.setTextColor(RefineActivity.this.getResources().getColor(R.color.white));
        binding.Coffee.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.selected));
        binding.Coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!coffee){
                    binding.Coffee.setTextColor(RefineActivity.this.getResources().getColor(R.color.white));
                    binding.Coffee.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.selected));
                    coffee=true;
                    one++;
                }else {

                    if (one>1){
                        binding.Coffee.setTextColor(RefineActivity.this.getResources().getColor(R.color.maincolor));
                        binding.Coffee.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.purpose));
                        coffee=false;
                        one--;
                    }else{
                        Toast.makeText(RefineActivity.this, "You needs to select at least one purpose", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        }); binding.Business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!business){
                    binding.Business.setTextColor(RefineActivity.this.getResources().getColor(R.color.white));
                    binding.Business.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.selected));
                    business=true;
                    one++;
                }else {
                    if (one>1){
                        binding.Business.setTextColor(RefineActivity.this.getResources().getColor(R.color.maincolor));
                        binding.Business.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.purpose));
                        business=false;
                        one--;
                    }else{
                        Toast.makeText(RefineActivity.this, "You needs to select at least one purpose", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        }); binding.Hobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hobi){
                    binding.Hobbies.setTextColor(RefineActivity.this.getResources().getColor(R.color.white));
                    binding.Hobbies.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.selected));
                    hobi=true;
                    one++;
                }else {
                    if (one>1){
                        binding.Hobbies.setTextColor(RefineActivity.this.getResources().getColor(R.color.maincolor));
                        binding.Hobbies.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.purpose));
                        hobi=false;
                        one--;
                    }else{
                        Toast.makeText(RefineActivity.this, "You needs to select at least one purpose", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }); binding.Friendship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!friends){
                    binding.Friendship.setTextColor(RefineActivity.this.getResources().getColor(R.color.white));
                    binding.Friendship.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.selected));
                    friends=true;
                    one++;
                }else {
                    if (one>1){
                        binding.Friendship.setTextColor(RefineActivity.this.getResources().getColor(R.color.maincolor));
                        binding.Friendship.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.purpose));
                        friends=false;
                        one--;
                    }else{
                        Toast.makeText(RefineActivity.this, "You needs to select at least one purpose", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }); binding.Movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!movie){
                    binding.Movies.setTextColor(RefineActivity.this.getResources().getColor(R.color.white));
                    binding.Movies.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.selected));
                    movie=true;
                    one++;
                }else {
                    if (one>1){
                        binding.Movies.setTextColor(RefineActivity.this.getResources().getColor(R.color.maincolor));
                        binding.Movies.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.purpose));
                        movie=false;
                        one--;
                    }else{
                        Toast.makeText(RefineActivity.this, "You needs to select at least one purpose", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }); binding.Dinning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!dinning){
                    binding.Dinning.setTextColor(RefineActivity.this.getResources().getColor(R.color.white));
                    binding.Dinning.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.selected));
                    dinning=true;
                    one++;
                }else {
                    if (one>1){
                        binding.Dinning.setTextColor(RefineActivity.this.getResources().getColor(R.color.maincolor));
                        binding.Dinning.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.purpose));
                        dinning=false;
                        one--;
                    }else{
                        Toast.makeText(RefineActivity.this, "You needs to select at least one purpose", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }); binding.Dating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!dating){
                    binding.Dating.setTextColor(RefineActivity.this.getResources().getColor(R.color.white));
                    binding.Dating.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.selected));
                    dating=true;
                    one++;
                }else {
                    if (one>1){
                        binding.Dating.setTextColor(RefineActivity.this.getResources().getColor(R.color.maincolor));
                        binding.Dating.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.purpose));
                        dating=false;
                        one--;
                    }else{
                        Toast.makeText(RefineActivity.this, "You needs to select at least one purpose", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }); binding.Matrimony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!matrimony){
                    binding.Matrimony.setTextColor(RefineActivity.this.getResources().getColor(R.color.white));
                    binding.Matrimony.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.selected));
                    matrimony=true;
                    one++;
                }else {
                    if (one>1){
                        binding.Matrimony.setTextColor(RefineActivity.this.getResources().getColor(R.color.maincolor));
                        binding.Matrimony.setBackground(ContextCompat.getDrawable(RefineActivity.this, R.drawable.purpose));
                        matrimony=false;
                        one--;
                    }else{
                        Toast.makeText(RefineActivity.this, "You needs to select at least one purpose", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        binding.status.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.countertext.setText(250 - s.toString().length() + "/250");

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String Availability = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}