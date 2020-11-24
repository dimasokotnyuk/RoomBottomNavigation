package com.example.roombottomnavigation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R

import com.example.roombottomnavigation.adapters.holders.ViewHolderGroup
import com.example.roombottomnavigation.room.Group

class AdapterGroup : RecyclerView.Adapter<ViewHolderGroup>() {

    var dataGroups: MutableList<Group> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGroup {
        return ViewHolderGroup(
            LayoutInflater.from(parent.context).inflate(R.layout.item_group, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderGroup, position: Int) {
        holder.bindGroup(dataGroups[position])
    }

    override fun getItemCount(): Int {
        return dataGroups.size
    }
}