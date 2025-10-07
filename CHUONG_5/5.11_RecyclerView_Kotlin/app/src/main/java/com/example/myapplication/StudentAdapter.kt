package com.example.myapplication

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.w3c.dom.Text

class StudentAdapter(
    private val listener: OnStudentClickListener
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    private val students = mutableListOf<Student>()
    class StudentViewHolder(
        itemView: View,
        private val listener: OnStudentClickListener
    ): ViewHolder(itemView) {
        private val imageAvatar: ImageView = itemView.findViewById(R.id.image_avatar)
        private val textId: TextView = itemView.findViewById(R.id.text_student_id)
        private val textFullName: TextView = itemView.findViewById(R.id.text_full_name)
        private val textGpa: TextView = itemView.findViewById(R.id.text_gpa)

        fun bind(student: Student){
            textFullName.text = student.fullName.toString()
            textGpa.text = student.gpa.toString()
            textId.text = student.id
            imageAvatar.setImageResource(Utils.getAvatar(student.gender))
            itemView.setOnClickListener{
                listener.onClick(student)
            }
        }
    }

    fun updateStudents(studentList: List<Student>){
        val oldSize = students.size
        students.clear()
        students.addAll(studentList)
        notifyItemRangeRemoved(0, oldSize)
        notifyItemRangeInserted(0, students.size)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder, position: Int) {
       val student = students[position]
        holder.bind(student)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    interface OnStudentClickListener {
        fun onClick(student: Student)
    }

}