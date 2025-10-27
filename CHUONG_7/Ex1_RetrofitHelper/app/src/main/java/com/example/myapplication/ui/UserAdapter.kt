package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.User

class UserAdapter (
    private val items: MutableList<User> = mutableListOf()
): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    fun submit(list: List<User>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvDisplay: TextView = itemView.findViewById(R.id.tvDisplayName)
        private val tvUser: TextView = itemView.findViewById(R.id.tvUserName)
        private val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        fun bind(user: User){
            tvDisplay.text = user.displayName
            tvUser.text = user.userName
            tvEmail.text = user.email
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "Clicked: ${user.displayName}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])
    override fun getItemCount(): Int = items.size
}