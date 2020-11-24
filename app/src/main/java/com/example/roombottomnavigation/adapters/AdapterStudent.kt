package com.example.roombottomnavigation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.interfaces.OnUserClickListener
import com.example.roombottomnavigation.adapters.holders.ViewHolderStudent
import com.example.roombottomnavigation.room.Student

class AdapterStudent(
    private val listener: OnUserClickListener,
    private val userClickCallback: (Student) -> Unit
) :
    RecyclerView.Adapter<ViewHolderStudent>() {

    var dataStudent: MutableList<Student> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderStudent {
        return ViewHolderStudent(
            LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false),
            listener,
            userClickCallback
        )
    }

    override fun onBindViewHolder(holder: ViewHolderStudent, position: Int) {
        holder.bindStudent(dataStudent[position])
    }

    override fun getItemCount(): Int {
        return dataStudent.size
    }
}