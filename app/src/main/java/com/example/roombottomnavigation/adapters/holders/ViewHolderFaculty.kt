package com.example.roombottomnavigation.adapters.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.room.Faculty
import com.example.roombottomnavigation.room.Group

class ViewHolderFaculty(private val listItemView: View) : RecyclerView.ViewHolder(listItemView) {

    fun bindFaculty(item: Faculty) {
        listItemView.findViewById<TextView>(R.id.tvNameFaculty).text = item.nameFaculty
        listItemView.findViewById<TextView>(R.id.tvGroup).text = item.group
        listItemView.findViewById<TextView>(R.id.tvUniversity).text = item.university
    }
}