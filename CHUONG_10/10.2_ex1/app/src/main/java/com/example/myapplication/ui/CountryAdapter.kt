package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.myapplication.R
import com.example.myapplication.data.Country
import com.example.myapplication.utils.CountryUtils

class CountryAdapter (
    private val listener: OnItemClickListener
): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    private val countries = mutableListOf<Country>()
    class CountryViewHolder(
        itemView: View,
        private val listener: OnItemClickListener
    ): RecyclerView.ViewHolder(itemView) {
        private val flagImageView: ImageView = itemView.findViewById(R.id.image_flag)
        private val textCountryName: TextView = itemView.findViewById(R.id.text_name)
        private val textCapital: TextView =  itemView.findViewById(R.id.text_capital)

        fun bind(country: Country){
            flagImageView.setImageResource(CountryUtils.getDrawableResource(country.flag))
            textCountryName.text = country.name
            textCapital.text = country.capital
            itemView.setOnClickListener {
                listener.onClick(country)
            }
        }
    }
    interface OnItemClickListener {
        fun onClick(country: Country)
    }

    fun submitData(countries: List<Country>) {
        this.countries.clear()
        this.countries.addAll(countries)
        notifyItemRangeInserted(0, countries.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view, listener)
    }


    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }
}