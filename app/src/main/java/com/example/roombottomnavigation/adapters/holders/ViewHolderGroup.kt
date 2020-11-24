package com.example.roombottomnavigation.adapters.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.room.Group

class ViewHolderGroup(private val listItemView: View) : RecyclerView.ViewHolder(listItemView) {

    fun bindGroup(item: Group) {
        listItemView.findViewById<TextView>(R.id.tvNameGroup).text = item.nameGroup
        listItemView.findViewById<TextView>(R.id.tvFaculty).text = item.faculty
        listItemView.findViewById<TextView>(R.id.tvUniversity).text = item.univeristy
    }
}