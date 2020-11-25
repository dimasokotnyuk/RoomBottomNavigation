package com.example.roombottomnavigation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.interfaces.OnUserClickListener
import com.example.roombottomnavigation.adapters.holders.ViewHolderStudent
import com.example.roombottomnavigation.room.Student
import com.example.roombottomnavigation.room.StudentWithGroup

class AdapterStudent(
    private val listener: OnUserClickListener,
    private val userClickCallback: (StudentWithGroup) -> Unit
) :
    ListAdapter<StudentWithGroup, ViewHolderStudent>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<StudentWithGroup>() {
            override fun areItemsTheSame(oldItem: StudentWithGroup, newItem: StudentWithGroup): Boolean {
                return oldItem.student.id == newItem.student.id
            }

            override fun areContentsTheSame(oldItem: StudentWithGroup, newItem: StudentWithGroup): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderStudent {
        return ViewHolderStudent(
            LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false),
            listener,
            userClickCallback
        )
    }

    override fun onBindViewHolder(holder: ViewHolderStudent, position: Int) {
        holder.bindStudent(getItem(position))
    }

}