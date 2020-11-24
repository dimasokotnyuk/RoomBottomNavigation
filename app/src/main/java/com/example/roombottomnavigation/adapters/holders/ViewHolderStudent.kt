package com.example.roombottomnavigation.adapters.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.interfaces.OnUserClickListener
import com.example.roombottomnavigation.room.Student

class ViewHolderStudent(
    private val listItemView: View,
    private val listener: OnUserClickListener,
    private val callback: (Student) -> Unit
) : RecyclerView.ViewHolder(listItemView) {

    fun bindStudent(item: Student) {
        listItemView.findViewById<TextView>(R.id.tvFirstName).text = item.firstName
        listItemView.findViewById<TextView>(R.id.tvLastName).text = item.lastName
        listItemView.findViewById<TextView>(R.id.tvFaculty).text = item.faculty
        listItemView.findViewById<TextView>(R.id.tvGroup).text = item.group
        listItemView.findViewById<TextView>(R.id.tvUniversity).text = item.university

        listItemView.setOnClickListener {
//            listener.onUserClick(item)
//            callback(item)
            callback.invoke(item)
        }
    }
}