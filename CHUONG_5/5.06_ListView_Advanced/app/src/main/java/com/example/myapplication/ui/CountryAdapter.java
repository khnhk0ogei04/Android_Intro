package com.example.myapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.data.Country;
import com.example.myapplication.utils.CountryUtils;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends BaseAdapter {
    private final List<Country> mCountries = new ArrayList<>();
    @Override
    public int getCount() {
        return mCountries.size();
    }

    @Override
    public Object getItem(int position) {
        return mCountries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountryViewHolder holder;
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.item_country, parent, false);
            holder = new CountryViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (CountryViewHolder) convertView.getTag();
        }
        holder.bind(mCountries.get(position));
        return convertView;
    }

    public void updateCountries(List<Country> countries){
        mCountries.clear();
        mCountries.addAll(countries);
        notifyDataSetChanged();
    }

    static class CountryViewHolder{
        private final ImageView mImageFlag;
        private final TextView mTextCountryName;
        private final TextView mTextCountryCapital;
        public CountryViewHolder(View view){
            mImageFlag = view.findViewById(R.id.image_flag);
            mTextCountryName = view.findViewById(R.id.text_country_name);
            mTextCountryCapital = view.findViewById(R.id.text_country_capital);
        }
        public void bind(Country country) {
            mImageFlag.setImageResource(CountryUtils.getFlagResId(country.getFlag()));
            mTextCountryName.setText(country.getName());
            mTextCountryCapital.setText(country.getCapital());
        }
    }
}
