package com.example.gridview.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.gridview.R;
import com.example.gridview.data.model.Country;
import com.example.gridview.utils.CountryUtils;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends BaseAdapter {
    private final List<Country> mCountries;

    public CountryAdapter(List<Country> countries){
        if (countries != null) {
            mCountries = countries;
        } else {
            mCountries = new ArrayList<>();
        }
    }


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
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_country, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Country country = mCountries.get(position);
        holder.bindData(country);
        return convertView;
    }

    public void updateData(List<Country> countries) {
        mCountries.clear();
        mCountries.addAll(countries);
        notifyDataSetChanged();
    }

    /**
     * Lớp chứa thông tin của item view.
     */
    static class ViewHolder {
        private final ImageView mImageFlag;
        private final TextView mTextCountryName;
        private final View mItemView;

        public ViewHolder(View itemView) {
            mItemView = itemView;
            mImageFlag = itemView.findViewById(R.id.image_item_flag);
            mTextCountryName = itemView.findViewById(R.id.text_item_country);
        }

        public void bindData(Country country) {
            mTextCountryName.setText(country.getNation());
            Glide.with(mItemView.getContext())
                    .load(CountryUtils.findFlagId(country.getFlag()))
                    .error(R.drawable.vietnam)
                    .into(mImageFlag);
        }
    }
}
