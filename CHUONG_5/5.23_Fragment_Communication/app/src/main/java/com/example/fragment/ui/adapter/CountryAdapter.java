package com.example.fragment.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fragment.R;
import com.example.fragment.data.model.Country;
import com.example.fragment.data.repository.Utils;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private final Context context;
    private final List<Country> countries;
    private final OnItemClickListener listener;

    public CountryAdapter(Context context, OnItemClickListener listener){
        this.context = context;
        this.countries = new ArrayList<>();
        this.listener = listener;
    }

    public void setCountries(List<Country> countries) {
        this.countries.clear();
        this.countries.addAll(countries);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.bind(country, listener);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageFlag;
        private final TextView textCountry;
        private final TextView textCapital;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFlag = itemView.findViewById(R.id.image_flag);
            textCountry = itemView.findViewById(R.id.text_name);
            textCapital = itemView.findViewById(R.id.text_capital);
        }

        public void bind(Country country, OnItemClickListener listener) {
            itemView.setOnClickListener(l -> listener.onItemClick(country));
            textCapital.setText(country.getCapital());
            textCountry.setText(country.getName());
            setImage(country);
        }

        private void setImage(Country country) {
            Glide.with(itemView).load(Utils.getDrawableId(itemView.getContext(), country.getFlag()))
                    .into(imageFlag);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Country country);
    }
}
