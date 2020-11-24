package com.example.roombottomnavigation.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.adapters.holders.ViewHolderFaculty
import com.example.roombottomnavigation.room.Faculty

class AdapterFaculty : RecyclerView.Adapter<ViewHolderFaculty>() {

    var dataFaculty: MutableList<Faculty> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFaculty {
        return ViewHolderFaculty(
            LayoutInflater.from(parent.context).inflate(R.layout.item_faculty, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderFaculty, position: Int) {
        holder.bindFaculty(dataFaculty[position])
    }

    override fun getItemCount(): Int {
        return dataFaculty.size
    }
}