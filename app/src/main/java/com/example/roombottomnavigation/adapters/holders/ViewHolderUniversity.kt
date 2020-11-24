package com.example.roombottomnavigation.adapters.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.room.Group
import com.example.roombottomnavigation.room.University

class ViewHolderUniversity(private val listItemView: View) : RecyclerView.ViewHolder(listItemView) {

    fun bindUniversity(item: University) {
        listItemView.findViewById<TextView>(R.id.tvNameUniversity).text = item.nameUniversity
        listItemView.findViewById<TextView>(R.id.tvFaculty).text = item.faculty
        listItemView.findViewById<TextView>(R.id.tvGroup).text = item.group
    }
}