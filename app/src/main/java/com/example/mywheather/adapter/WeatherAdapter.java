package com.example.mywheather.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mywheather.R;
import com.example.mywheather.networking.WeatherModel;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder>{

    private final List<WeatherModel> weatherModelArrayList;

    public WeatherAdapter(List<WeatherModel> weatherModelArrayList) {
        this.weatherModelArrayList = weatherModelArrayList;
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weathercard_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {

        WeatherModel model = weatherModelArrayList.get(position);
        if(model != null){
            holder.cityTV.setText(model.getName());
            holder.timeTV.setText(model.getDate());
            holder.descriptionTV.setText("Temp (C): " +model.getCode());
            Glide.with(holder.itemView.getContext())
                            .load(model.getIcon())
                                    .into(holder.weatherIV);

            System.out.println(holder.cityTV.getText());
            System.out.println(holder.timeTV.getText());
            System.out.println(holder.descriptionTV.getText());


        }
    }



    @Override
    public int getItemCount() {
        if(weatherModelArrayList == null)
            return 0;
        return weatherModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View itemView;
        private final ImageView weatherIV;
        private final TextView cityTV;
        private final TextView timeTV;
        private final TextView descriptionTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            timeTV = itemView.findViewById(R.id.time);
            descriptionTV = itemView.findViewById(R.id.textDescription);
            weatherIV = itemView.findViewById(R.id.weatherImage);
            cityTV = itemView.findViewById(R.id.cityName);

        }


    }
}
