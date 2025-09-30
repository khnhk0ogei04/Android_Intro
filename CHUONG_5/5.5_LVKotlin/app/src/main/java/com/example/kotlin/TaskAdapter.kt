package com.example.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class TaskAdapter(
    private val context: Context,
    private val tasks: MutableList<String>
) : BaseAdapter() {
    override fun getCount(): Int {
        return tasks.size
    }

    override fun getItem(position: Int): Any {
        return tasks[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.list_item_task, parent, false
        )
        val textViewTaskName = view.findViewById<TextView>(R.id.textViewTaskName)
        val buttonDelete = view.findViewById<Button>(R.id.buttonDelete)

        textViewTaskName.text = tasks[position]
        buttonDelete.setOnClickListener {
            tasks.removeAt(position)
            notifyDataSetChanged()
        }
        return view
    }
}