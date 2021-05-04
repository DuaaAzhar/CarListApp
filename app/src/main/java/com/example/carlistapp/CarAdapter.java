package com.example.carlistapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
   private ArrayList<Cars> cars;
   CarSelected myActivity;
   public CarAdapter(Context context, ArrayList<Cars> list){
       myActivity=(CarSelected) context;
       cars=list;
   }
   public interface CarSelected{
       void onCarClick(int index);
   }
   public class ViewHolder extends RecyclerView.ViewHolder{
       TextView tvOwnName, tvNumber,tvCarName;
       ImageView ivCar;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);
          tvOwnName=itemView.findViewById(R.id.tvOwnName);
          tvNumber=itemView.findViewById(R.id.tvNumber);
          tvCarName=itemView.findViewById(R.id.tvCarName);
          ivCar=itemView.findViewById(R.id.ivCar);
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  myActivity.onCarClick(cars.indexOf(itemView.getTag()));
              }
          });
       }
   }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.carlist,parent,false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.itemView.setTag(cars.get(position));
       holder.tvOwnName.setText(cars.get(position).getName());
       holder.tvCarName.setText(cars.get(position).getCarName());
       holder.ivCar.setImageResource(cars.get(position).getImage());
    }


    @Override
    public int getItemCount() {
        return cars.size();
    }
}
