package com.example.gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

data class Product(
    val name: String,
    val imageResId: Int
)
class ProductAdapter(
    private val context: Context,
    private val products: MutableList<Product>
) : BaseAdapter() {
    override fun getCount(): Int {
        return products.size
    }

    override fun getItem(position: Int): Any {
        return products[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.grid_item_product, parent, false)
        val imageViewProduct = view.findViewById<ImageView>(
            R.id.imageViewProduct
        )
        val textViewProductName = view.findViewById<TextView>(R.id.textViewProductName)
        val buttonDelete = view.findViewById<Button>(R.id.buttonDelete)

        val product = products[position]
        imageViewProduct.setImageResource(product.imageResId)
        textViewProductName.text = product.name

        buttonDelete.setOnClickListener {
            products.removeAt(position)
            notifyDataSetChanged()
        }

        return view
    }

}